package Exercise1;

/**
 *
 * @author Tobias Jacobsen
 */
public class RunThis {

    public static void main(String[] args) {
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
        Tester test = new Tester();
    }
}
