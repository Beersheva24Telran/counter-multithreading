package telran.multithreading;

import java.time.LocalDateTime;

public class CounterThread extends Thread{
    private static  int nIterations;
    private static long counter = 0;
    public static int getnIterations() {
        return nIterations;
    }
    public static void setnIterations(int nIterations) {
        CounterThread.nIterations = nIterations;
    }
    public static long getCounter() {
        return counter;
    }
   
    synchronized static private void counterIncrement() {
        LocalDateTime ldt = LocalDateTime.now();
     System.out.printf("time before incrementing is %s, the current value is %s\n", ldt, counter);
        counter++;
        System.out.printf("time after incrementing is %s, the current value is %s\n", LocalDateTime.now(), counter);
    }
    @Override
    public void run() {
        for(int i = 0; i < nIterations; i++) {
            counterIncrement();
        }
    }
}
