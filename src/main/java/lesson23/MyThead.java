package lesson23;

public class MyThead extends Thread{
    @Override
    public void run() {
        for (int i= 100;  i<110 ;i++) {
            System.out.println(i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
