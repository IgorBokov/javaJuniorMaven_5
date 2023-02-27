package lesson23;

public class Veduchij {
    public static void main(String[] args) {
        System.out.println("Начало концерта");
        Voce1 voce1 = new Voce1();
        voce1.start();
        Thread thread =new Thread(new Kloun());
        thread.start();
        boolean konec = true;
        while (konec){
            if(!thread.isAlive()){
                konec = false;
            }
        }
        System.out.println("конец");

    }
}
