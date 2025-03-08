import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        String name;
        int age;

        Scanner in = new Scanner(System.in);

        HashMap<Integer, List<User>> users = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            name = in.nextLine();
            System.out.println("Введите возраст пользователя " + (i +1));
            age = in.nextInt();
            in.nextLine();

            User temp = new User(name, age);
            if (users.containsKey(age)) {
                users.get(age).add(temp);
            } else {
                List<User> temp1 = new ArrayList<>();
                temp1.add(temp);
                users.put(age, temp1);
            }
        }

        System.out.println("\nВведите требуемый возраст");
        int target = in.nextInt();
        in.close();

        Comparator<User> com = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getName().compareTo(o2.getName()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        if (users.containsKey(target)) {
            List<User> result = users.get(target);
            Collections.sort(result, com);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).toString());
            }
        } else {
            System.out.println("Пользователь с возрастом '" + target + "' не найден");
        }
    }
}
