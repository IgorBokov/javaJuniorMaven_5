package lesson26;

import lesson25.User;
import lesson25.UserService;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamExample {
    public static void main(String[] args) {
        ArrayList<User> polz = new ArrayList<>();
        try {
            UserService service = new UserService();
            for (int i = 0; i < 5; i++) {
                polz.add(service.getRandomUser()); //составляем список из пяти user
            }
            for (User user : polz) {
                System.out.println("1 list " + user);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        polz.stream().forEach(System.out::println);             //выводим список на экран
//        List<String> collect = polz.stream()
//                .filter(p -> p.getDob().getYear() > 1990)     // отбираем кто больше 1994
//                .map(m -> m.getFirsName())                       // выбираем поле FirsName
//                //.forEach(System.out::println+ " 1 list");                 // выводим всех попавших на экран
//                .peek(System.out::println)
//                .collect(Collectors.toList());// сохранили результат отбора в collect
//        for (String userList:collect) {
//            System.out.println(userList+"  3 list");
//        polz.stream()
//                .skip(2)        // пропустить первых 2-х из списка
//                .limit(2)       // вывели первых 2-х из списка
//                .sorted((o1, o2) -> o1.getFirsName().compareTo(o2.getFirsName())) // сортировка по имени
//                .sorted(Comparator.comparing(User::getFirsName))          // сортировка по имени сокращенный вариант
//                .forEach(System.out::println);
//        Stream.of(1, 2, 2, 2, 3, 4, 4, 8, 0, 5, 5, 66, 66, 7)
//                .distinct().forEach(System.out::print); // distinct убирает дубли
//        polz.stream()
//                .sorted(Comparator.comparing(User::getDob))
//                .forEach(System.out::println);  // сортирует по возрасту
        polz.stream()
                .map(User::getFirsName).forEach(System.out::println);
    }

}