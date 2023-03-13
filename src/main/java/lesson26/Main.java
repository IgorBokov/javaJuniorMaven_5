package lesson26;

import lesson25.User;
import lesson25.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        UserService service = new UserService();
        List<User> users = service.getUsers(100);
 //       System.out.println(users);
        ArrayList<Country> countries = new ArrayList<>();
        users.stream()
                .collect(Collectors.groupingBy(User::getCountry))
                .forEach((k,v) -> countries.add(new Country(k,v)));
        System.out.println(countries);
    }
}
class Country {
    private String name;
    private List<User> users;

    public Country(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }
}