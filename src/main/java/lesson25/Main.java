package lesson25;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();
        try {
            User user = service.getRandomUser();
            System.out.println(user);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
