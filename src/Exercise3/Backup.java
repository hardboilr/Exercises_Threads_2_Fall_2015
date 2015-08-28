package Exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 * @author Tobias Jacobsen
 */
public class Backup implements Runnable {

    private List<String> textList;
    private final File DEFAULTDIR = new File(new JFileChooser().getFileSystemView().getDefaultDirectory().toString());
    private final String FILENAME = "backup.txt";
    private final File FINALPATH = new File(DEFAULTDIR, FILENAME);

    public Backup(List<String> input) {
        this.textList = input;
    }

    @Override
    public void run() {
        while (true) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(FINALPATH, false); //append false
            } catch (IOException ex) {
                Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (PrintWriter out = new PrintWriter(writer)) {
                for (String s : textList) {
                    out.println(s);
                }
                System.out.println("Wrote backup to file");
            }
            try {
                Thread.sleep(15000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
