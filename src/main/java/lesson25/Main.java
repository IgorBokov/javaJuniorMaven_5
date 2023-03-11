package lesson25;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        UserService service = new UserService();
        try {
            User user = service.getRandomUser();
            System.out.println(user);
        }catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<User> country = service.getRandomUserCountry(3, "Canada");
        System.out.println(country);
    }
}
