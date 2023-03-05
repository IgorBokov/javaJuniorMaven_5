package lesson23;

public class Streptiz extends Voce1 {
    private int count = 0;
    @Override
    public void run() {
        Thread.currentThread().setName("strepizerscha");
        System.out.println(Thread.currentThread().getName());
        synchronized (Monitors.MIKROFON){
            try {
                Monitors.MIKROFON.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        while (count < 4) {
            count++;
            for (int i = 0; i < 6; i++) {
                System.out.println("Streptiz _" + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
                synchronized (Monitors.SHAR){
                    Monitors.SHAR.notify();

                }
            }
        }
    }
}