package lesson23;

public class Voce1 extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 3; i++) {
                System.out.println("поет " + i);
            }
            synchronized (Monitors.MIKROFON) {
                Monitors.MIKROFON.notify();
            }
            synchronized (Monitors.MIKROFON) {
                try {

                    Monitors.MIKROFON.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }
}