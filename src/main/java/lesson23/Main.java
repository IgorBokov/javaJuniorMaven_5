package lesson23;

public class Main {
    public static void main(String[] args) {
        MyThead myThead = new MyThead();
        myThead.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
