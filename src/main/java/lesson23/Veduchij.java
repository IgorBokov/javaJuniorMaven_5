package lesson23;

public class Veduchij {
    public static void main(String[] args) {
        //System.out.println(Thread.currentThread().getName());// здесь имя потока будет main, т.к метод main
        System.out.println("Начало концерта");
        Voce1 voce1 = new Voce1();
        voce1.start();
        Thread thread = new Thread(new Kloun());
        thread.setDaemon(true);
        thread.start();
        Streptiz streptiz = new Streptiz();
        streptiz.setDaemon(true);
        streptiz.start();


        boolean konec = true;
        while (konec) {
            if (!voce1.isAlive()) {
                konec = false;
            }
        }
        System.out.println("конец");
    }
}