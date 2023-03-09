package lesson24;

public class ParametrizeMetod {
    public <T> void myMetod(T t) {
        System.out.println(t);
    }

    public <T, R> T type(R r, T t) {
        System.out.println(r);
        if (t instanceof Integer) {
            Integer type = (Integer) t;
            type++;
            t = (T) type;
        }
        if (t instanceof String) {
            String type = (String) t;
            type = type.toUpperCase();
            t = (T) type;
        }
        return t;
    }

}