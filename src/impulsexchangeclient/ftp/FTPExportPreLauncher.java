package impulsexchangeclient.ftp;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import org.apache.commons.net.ftp.FTPClient;

public class FTPExportPreLauncher {

    public FTPExportPreLauncher(JProgressBar progressBar, DefaultListModel exportOrdersModel) {
        this.progressBar = progressBar;
        this.exportOrdersModel = exportOrdersModel;
        this.progressBar.setString(null);
        this.progressBar.setValue(0);
        createTimer();
    }

    /**
     * Инициализация соединения с FTP и запуск дополнительного потока для
     * отправки файла обмена и информации об отправляемых заказах на FTP-сервер.
     * А так же запуск таймера для слежения за новым потоком.
     */
    public void runExport() {
        ftpInstance = FTPConnector.getInstance();
        FTPClient ftpConnection = ftpInstance.connect();
        if (ftpConnection != null) {
            dataExportThread = new FTPExportThread(ftpConnection, copyModelToList(exportOrdersModel));
            timer.start();
            dataExportThread.start();
        }
    }

    /**
     * Создает копию списка заказов, для экспорта на FTP-сервер. И для упрощения
     * конвертирует его в ArrayList.
     *
     * @param dm - Список заказов для экспорта на FTP (exportOrdersModel).
     * @return - ArrayList с теми же заказами (но их изменение не повлечет
     * изменений в exportOrdersModel)
     */
    private List copyModelToList(DefaultListModel dm) {
        List<String> result = new ArrayList();
        for (int i = 0; i < dm.getSize(); i++) {
            result.add(i, dm.get(i).toString());
        }
        return result;
    }

    /**
     * Инициализация таймера, который будет следить за процессом отправки файла
     * обмена на FTP-сервер, и выполнением соответствующих действий при
     * завершении этого процесса, либо возникновении каких-либо ошибок.
     */
    private void createTimer() {
        timer = new Timer(10, (ActionEvent e) -> {
            if (dataExportThread.isAlive()) {
                progressBar.setValue(dataExportThread.getProgress());
            } else {
                if (!dataExportThread.isError()) {
                    progressBar.setValue(100);
                    progressBar.setString("Завершено!");
                    exportOrdersModel.clear();
                } else {
                    progressBar.setValue(100);
                    progressBar.setString("Ошибка!");
                }
                ftpInstance.disconnect();                                       //вызываем FTP.disconnect() по окончанию действия потока.
                timer.stop();
            }
        });
    }

    private final JProgressBar progressBar;
    private final DefaultListModel exportOrdersModel;
    private FTPExportThread dataExportThread;
    private FTPConnector ftpInstance;
    private Timer timer;
}
