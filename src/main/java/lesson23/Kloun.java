package lesson23;

public class Kloun implements Runnable {
    private int count = 0;

    @Override
    public String toString() {
        return "Kloun{" +
                "count=" + count +
                '}';
    }

    @Override
    public void run() {
        Thread.currentThread().setName("LOG kloun");
        System.out.println(Thread.currentThread().getName());
        while (true) {
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
