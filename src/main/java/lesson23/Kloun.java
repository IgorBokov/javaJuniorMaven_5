package lesson23;

public class Kloun implements Runnable {
    @Override
    public void run() {
       while (true){
           synchronized (Monitors.MIKROFON) {
               try {
                   Monitors.MIKROFON.wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
           for (int i = 0; i < 3; i++) {
               System.out.println("жонглирует " + i);
           }
           synchronized (Monitors.MIKROFON){
               Monitors.MIKROFON.notify();
           }
       }
    }
}
