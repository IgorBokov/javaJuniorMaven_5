package lesson25;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;

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
