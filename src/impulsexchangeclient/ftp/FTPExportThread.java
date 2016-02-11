package impulsexchangeclient.ftp;

import impulsexchangeclient.common.Options;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.io.CopyStreamAdapter;

public class FTPExportThread extends Thread {

    public FTPExportThread(FTPClient ftpConnection, List newOrdersList) {
        this.ftpConnection = ftpConnection;
        this.newOrdersList = newOrdersList;
        localFile = new File(Options.getSwndFilePath());
        errorStatus = false;
    }

    @Override
    public void run() {
        try {
            setFtpDirectory();                                  //Проверяем наличие папки "номер_отдела" на FTP сервере
            uploadSwndFile();                                   //Загрузка "swndX.arc" на сервер
            uploadOrders();                                     //Загрузка информации о заказах на сервер
            updateArchive();                                    //Обновляем архив предыдущих заказов '
        } catch (IOException ex) {
            String errorMsg = "Неизвестная ошибка.";
            errorStatus = true;
            if (ex.toString().contains("UploadSwndFileException")) {
                if (ex.toString().contains("FileNotFoundException")) {
                    errorMsg = "Указан неверный путь к файлу обмена <" + Options.getSwndFileName() + "> \r\n"
                            + "Пожалуйста проверьте настройки программы. Пункт: <Путь к файлу обмена>.";
                } else if (ex.toString().contains("CopyStreamException")) {
                    errorMsg = "Ошибка отправки данных на FTP-сервер. \r\n"
                            + "Вероятно было прервано соединение с интернетом.";
                }
            } else if (ex.toString().contains("UpdateArchiveException")) {
                errorMsg = "Ошибка записи архива. Недостаточно прав доступа к папке <" + System.getProperty("user.dir") + ">.";
            }
            JOptionPane.showMessageDialog(null, errorMsg + "\r\n" + ex.toString(), "FTPExportThread.run()", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Установка активной директории на FTP-сервере, название которой
     * соответствует номеру отдела. В дальнейшем все данные будут отправляться
     * именно сюда.
     */
    private void setFtpDirectory() throws IOException {
        try {
            boolean exist = ftpConnection.changeWorkingDirectory(Options.getDepartmentName());
            if (!exist) {
                ftpConnection.makeDirectory(Options.getDepartmentName());
                ftpConnection.changeWorkingDirectory(Options.getDepartmentName());
            }
        } catch (IOException ex) {
            throw new IOException("[SetFtpDirectoryException]" + "\r\n"
                    + "ex.toString(): " + ex.toString());
        }
    }

    /**
     * Отправка на FTP-сервер файла обмена. Если файл с таким названием уже
     * имеется на FTP-сервере, то он будет заменен новым.
     */
    private void uploadSwndFile() throws IOException {
        setProgressListener();
        try (BufferedInputStream localFileStream = new BufferedInputStream(new FileInputStream(localFile))) {
            ftpConnection.storeFile(Options.getSwndFileName(), localFileStream);
        } catch (IOException ex) {
            throw new IOException("[UploadSwndFileException]" + "\r\n"
                    + "ex.toString(): " + ex.toString());
        }
    }

    /**
     * Добавление информации о поступивших заказах в соответствующий файл на
     * FTP-сервере. Формат: <номер заказа>________<дата и время отправки>
     */
    private void uploadOrders() throws IOException {
        try (BufferedOutputStream out = new BufferedOutputStream(ftpConnection.appendFileStream("orders.txt"))) {
            for (String tempList : newOrdersList) {
                String date = new Date(System.currentTimeMillis()).toLocaleString();
                out.write((tempList + "          " + date + "\r\n").getBytes());
            }
        } catch (IOException | NullPointerException ex) {
            throw new IOException("[UploadOrdersException]" + "\r\n"
                    + "ex.toString(): " + ex.toString());
        }
    }

    /**
     * Дублирование информации о поступивших заказах в файл архива
     * 'archive.bin'.
     */
    private void updateArchive() throws IOException {
        String archive = System.getProperty("user.dir") + File.separator + "archive.bin";
        String temp = System.getProperty("user.dir") + File.separator + "temp.bin";
        try {
            if (!Files.exists(Paths.get(archive))) {
                Files.createFile(Paths.get(archive));
                Files.createFile(Paths.get(temp));
            } else {
                //переименовываем старый архив, чтобы сохранить данные
                Files.move(Paths.get(archive), Paths.get(temp), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            throw new IOException("[UpdateArchiveException.create_or_rename]" + "\r\n"
                    + "ex.toString(): " + ex.toString());
        }

        //создаем новый и добавляем в архив новые заказы
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(archive, true))) {
            for (String tempList : newOrdersList) {
                String date = new Date(System.currentTimeMillis()).toLocaleString();
                out.write((tempList + "          " + date + "\r\n").getBytes());
            }
        }
        //записываем в конец старую информацию
        overwriteFromTemp(archive, temp);
    }

    /*
     Дополнительная функция, необходимая для того, чтобы новые заказы 
     записывались в начало файла архива, а не в конец.
     */
    private void overwriteFromTemp(String archive, String temp) throws IOException {
        FileChannel srcChannel = null;
        FileChannel dstChannel = null;
        try {
            srcChannel = new RandomAccessFile(temp, "r").getChannel();
            dstChannel = new RandomAccessFile(archive, "rw").getChannel();
            dstChannel.transferFrom(srcChannel, dstChannel.size(), srcChannel.size());
        } catch (IOException ex) {
            throw new IOException("[UpdateArchiveException.overwriteFromTemp(archive, temp)]" + "\r\n"
                    + "ex.toString(): " + ex.toString());
        } finally {
            if (srcChannel != null) {
                srcChannel.close();
            }
            if (dstChannel != null) {
                dstChannel.close();
            }
        }
    }

    /**
     * Инициализация слушателя событий, необходимого для вычисления прогресса
     * загрузки файла обмена на FTP-сервер.
     */
    private void setProgressListener() {
        CopyStreamAdapter streamListener = new CopyStreamAdapter() {
            private int oldProgress = 0;
            private final long length = localFile.length();

            @Override
            public void bytesTransferred(long totalBytesTransferred, int bytesTransferred, long streamSize) {
                progress = (int) (totalBytesTransferred * 100 / length);
                if ((progress != oldProgress) && (progress < 100)) {
                    oldProgress = progress;
                }
            }
        };
        ftpConnection.setCopyStreamListener(streamListener);
    }

    public boolean isError() {
        return errorStatus;
    }

    public int getProgress() {
        return progress;
    }

    private final File localFile;
    private final List<String> newOrdersList;
    private boolean errorStatus;
    private final FTPClient ftpConnection;
    private int progress = 0;
}
