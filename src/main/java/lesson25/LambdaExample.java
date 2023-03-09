package lesson25;

import java.util.ArrayList;

public class LambdaExample {
    public static void filtering(ArrayList<User> userArrayList, Presicate<User> presicate) {
        for (User user : userArrayList) {
            if (presicate.test(user)) {
                System.out.println(user);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        UserService service = new UserService();
        try {
            for(int i =0; i <5; i++){
                users.add(service.getRandomUser()); //составляем список из пяти user
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        for(User user: users) {               // выводим список на экран
            System.out.println(user);
        }
        System.out.println();
        filtering(users, new Presicate<User>() {    // анонимный класс
            @Override
            public boolean test(User user) {
                return user.getGender().equals("male"); // сортировака по "male"
            }
        });
        System.out.println();
        filtering(users, user -> user.getGender().equals("male"));

    }
}

interface Presicate<T> {
    boolean test(T t); // metod "test" return "boolean"
}