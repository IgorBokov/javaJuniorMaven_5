package lesson23;

public class Voce1 extends Thread {
    private int count = 0;
    @Override
    public void run() {
        while (count < 2) {
            count++;
            for (int i = 0; i < 3; i++) {
                System.out.println("поет " + i);
            }
            synchronized (Monitors.MIKROFON) {     // будит следуещего
                Monitors.MIKROFON.notify();
            }
            synchronized (Monitors.MIKROFON) {
                try {
                    Monitors.MIKROFON.wait();       // Ждет очереди
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}