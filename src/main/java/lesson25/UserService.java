package lesson25;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class UserService {
    public User getRandomUser() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://randomuser.me/api"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return parseJsonResponceToUser(response.body());
    }

    public ArrayList<User> getRandomUserses(int r) {
        ArrayList<User> users = new ArrayList<>();
        UserService service = new UserService();
        try {
            for (int i = 0; i < r; i++) {
                users.add(service.getRandomUser()); //составляем список из r пользователей
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public ArrayList<User> getRandomUserCountry(int i, String country) throws IOException, InterruptedException {
        ArrayList<User> res = new ArrayList<>();
        boolean ok = true;
        while (ok) {
            User randomUser = getRandomUser();
            if (randomUser.getCountry().equals(country)) {
                res.add(randomUser);
            }
            if (res.size() >= i) {
                ok = false;
            }
        }
        return res;
    }

    public User parseJsonResponceToUser(String data) {
        JSONObject fullDataUser = new JSONObject(data).getJSONArray("results").getJSONObject(0);//получили все данные поля "results"
        User user = new User();
        user.setGender(fullDataUser.getString("gender")); //сохранили пол нашего usera
        JSONObject name = fullDataUser.getJSONObject("name");
        user.setFirsName(name.getString("first"));
        user.setLastsName(name.getString("last"));
        user.setEmail(fullDataUser.getString("email"));
        JSONObject dob = fullDataUser.getJSONObject("dob");
        ZonedDateTime zona = ZonedDateTime.parse(dob.getString("date"));
        user.setDob(zona.toLocalDate());
        user.setPhone(fullDataUser.getString("phone"));
        JSONObject location = fullDataUser.getJSONObject("location");
        user.setCountry(location.getString("country"));
        return user;
    }
}
