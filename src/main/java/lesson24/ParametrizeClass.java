package lesson24;

import lesson23.Kloun;

public class ParametrizeClass {
    public static void main(String[] args) {
        MyClass<Integer> c = new MyClass(32565); // В классе "MyClass" будем работать типом "Integer"
        System.out.println(c);
        MyClass<String> c1 = new MyClass("Igor"); // В классе "MyClass" будем работать типом "String"
        System.out.println(c1);

        ParametrizeMetod p = new ParametrizeMetod();
        p.myMetod("Igor");
        p.myMetod(324980);
        p.myMetod(new Kloun());
        System.out.println(p.type(123, "asdfg"));
    }
}