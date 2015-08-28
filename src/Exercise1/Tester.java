package Exercise1;

import Exercise1.LoadImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tobias Jacobsen
 */
public class Tester {

    private LoadImage loadInst1;
    private LoadImage loadInst2;
    private LoadImage loadInst3;

    private int totalSum;

    private final String URL1 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png";
    private final String URL2 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png";
    private final String URL3 = "https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png";

    public Tester() {
        totalSum = 0;
        init();
    }

    private void init() {
        loadInst1 = new LoadImage(URL1);
        loadInst2 = new LoadImage(URL2);
        loadInst3 = new LoadImage(URL3);
        Thread t1 = new Thread(loadInst1);
        Thread t2 = new Thread(loadInst2);
        Thread t3 = new Thread(loadInst3);

        long start = System.nanoTime(); //Log time (start)

        t1.start(); //set to run() for sequential execution. start() for parralel execution
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }

        long end = System.nanoTime(); //Log time (end)
//        System.out.println("Time Sequental: " + (end - start)); //result: 1.886.572.000
        System.out.println("Time Parallel: " + (end - start)); //result: 1.062.340.000

        totalSum = loadInst1.getByteSum() + loadInst2.getByteSum() + loadInst3.getByteSum();
        System.out.println("Total sum is: " + totalSum);

    }
}
