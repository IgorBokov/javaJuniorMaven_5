package lesson23;

public class Kloun implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        Thread.currentThread().setName("LOG kloun");
        System.out.println(Thread.currentThread().getName());
        while (count < 4) {
            synchronized (Monitors.SHAR) {
                try {
                    Monitors.SHAR.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("жонглирует " + i);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (Monitors.FLAG) {
                Monitors.FLAG.notify();
            }
        }
    }
}
