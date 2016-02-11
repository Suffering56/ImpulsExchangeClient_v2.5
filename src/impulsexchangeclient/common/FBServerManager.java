package impulsexchangeclient.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class FBServerManager {

    private FBServerManager() {
        //private!
    }

    /**
     * SingleTone.
     *
     * @return Новый экземпляр FBServerManager при первом вызове данного метода.
     * При повторном вызове будет вовзращен уже существующий экземпляр.
     */
    public static FBServerManager getInstance() {
        if (instance == null) {
            instance = new FBServerManager();
        }
        return instance;
    }

    /**
     * Проверяет, запущен ли Firebird-сервер на данном компьютере, необходимый
     * для работы программы. Если сервер не был запущен - запускает его.
     */
    public void run() {
        try {
            String line;
            String result = "";
            Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe /FI \"IMAGENAME eq " + FB_SERVER_PROCESS_NAME + "\" /NH");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = in.readLine()) != null) {
                result += line;
            }
            in.close();

            if (!result.contains("fbserver.exe")) {
                Runtime.getRuntime().exec(Options.getFbserverPath() + " -a");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка при запуске Firebird-сервера: <exec(" + FB_SERVER_PROCESS_NAME + " -a)>. \r\n"
                    + "Проверьте настройки Firebird.\r\n" + "ex.toString(): " + ex, "FBServerManager.run()", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static FBServerManager instance = null;
    private static final String FB_SERVER_PROCESS_NAME = "fbserver.exe";
}
