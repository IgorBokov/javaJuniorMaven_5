package lesson25;

import java.util.ArrayList;

public class LambdaExample {
    public static void filtre(ArrayList<User> userArrayList, Presicate<User> presicate) {
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
                users.add(service.getRandomUser());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        for(User user: users) {
            System.out.println(user);
        }
        System.out.println();
        filtre(users, new Presicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getGender().equals("male");
            }
        });
        System.out.println();
        filtre(users, user -> user.getGender().equals("male"));

    }
}

interface Presicate<T> {
    boolean test(T t);
}