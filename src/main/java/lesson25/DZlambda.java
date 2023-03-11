package lesson25;

import java.util.ArrayList;

public class DZlambda {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        UserService userService = new UserService();
        System.out.println(userService.getRandomUserses(3));
    }
}
