package Exercise2;

import java.util.ArrayList;
import java.util.List;

public class FibonacciTask implements Runnable {

    private long tal;

    List<FibonacciObserver> observers = new ArrayList();

    public void registerFibonacciObserver(FibonacciObserver o) {
        observers.add(o);
    }

    public FibonacciTask(long n) {
        this.tal = n;
    }

    @Override
    public void run() {
        System.out.println("Run started");
        tal = calcFib(tal);
        System.out.println(tal);
        
        System.out.println(observers.size());

        for (FibonacciObserver observer : observers) {
            System.out.println("Calculated number: " + tal);
            observer.dataReady(tal);
        }
    }

    private long calcFib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return calcFib(n - 1) + calcFib(n - 2);
        }
    }
    
}
