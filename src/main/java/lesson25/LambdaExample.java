package lesson25;

import java.time.LocalDate;
import java.util.ArrayList;

public class LambdaExample {
    public static void filtering(ArrayList<User> userArrayList,
                                 Presicate<User> presicate,
                                 Consumer<User> consumer) {
        for (User user : userArrayList) {
            if (presicate.test(user)) {
                consumer.acecpt(user);
                System.out.println(user);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        UserService service = new UserService();
        try {
            for (int i = 0; i < 5; i++) {
                list.add(service.getRandomUser()); //составляем список из пяти user
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (User user : list) {               // выводим список на экран
            System.out.println(user);
        }
        System.out.println();
//        filtering(list, new Presicate<User>() {    // анонимный класс
//            @Override
//            public boolean test(User user) {
//                return user.getGender().equals("male"); // сортировака по "male"
//            }
//        });
//        System.out.println();
//        filtering(list, user -> user.getGender().equals("male"));
//        filtering(list,(User user)-> {
//            return  user.getGender().equals("male");
//        });
        filtering(list, s -> LocalDate.now().getYear() - s.getDob().getYear() > 40, // s interface Presicate<T>
                m -> m.setFirsName(m.getFirsName().toUpperCase())                    // m interface Consumer<T>
        );

    }
}

interface Presicate<T> {   // этим сортируем
    boolean test(T t); // metod "test" return "boolean"
}

interface Consumer<T> {   // этим модернизируем сортировку
    void acecpt(T t);
}