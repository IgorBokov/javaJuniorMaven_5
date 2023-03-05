package lesson23;

public class Voce1 extends Thread {
    private int count = 0;
    @Override
    public void run() {
        Thread.currentThread().setName("LOG Voce");
        System.out.println(Thread.currentThread().getName());
        while (count < 2) {
            count++;
            for (int i = 0; i < 3; i++) {
                System.out.println("поет " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (Monitors.MIKROFON) {
                Monitors.MIKROFON.notify();     // будит следуещего
            }
            synchronized (Monitors.FLAG) {
                try {
                    Monitors.FLAG.wait();       // Ждет очереди
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}