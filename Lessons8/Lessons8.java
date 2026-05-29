
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class Lessons8 {
}


public static void main(String[] args) {
    Random random = new Random();
    int[] numbers = new int[100];
    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = random.nextInt(100);
    }
    System.out.println(Arrays.toString(numbers));

    long count = Arrays.stream(numbers)
            .filter(n -> n % 2 == 0)
            .count();
    System.out.println(count);

    List<String> list = new ArrayList<>();
    list.add("Highload");
    list.add("High");
    list.add("Load");
    list.add("Highloa");

    long count1 = list.stream()
            .filter(m -> m.equals("High"))
            .count();
    System.out.println(count1);

    String firstStream = list.stream()
            .findFirst()
            .orElse("0");
    System.out.println(firstStream);

    String lastStream = list.stream()
            .reduce((first, second) -> second)
            .orElse("0");
    System.out.println(lastStream);

    List<String> list1 = new ArrayList<>();
    list1.add("f10");
    list1.add("f15");
    list1.add("f2");
    list1.add("f4");
    list1.add("f4");

    List<String> sorted = list1.stream()
            .sorted()
            .collect(Collectors.toList());

    System.out.println(sorted);

    Person person1 = new Person("Мужской", 25);
    Person person2 = new Person("Мужской", 21);
    Person person3 = new Person("Мужской", 30);
    Person person4 = new Person("Мужской", 18);
    Person person5 = new Person("Мужской", 20);
    Person person6 = new Person("Мужской", 31);

    double averageAge = Stream.of(person1, person2, person3, person4, person5, person6)
            .filter(p -> p.gender.equals("Мужской"))
            .mapToInt(p -> p.age)
            .average()
            .orElse(0.0);

    System.out.println(averageAge);

    List<Integer> ages = Stream.of(person1, person2, person3, person4, person5, person6)
            .filter(p -> p.gender.equals("Мужской"))
            .filter(p -> p.age >= 18 && p.age <= 27)
            .map(p -> p.age)
            .collect(Collectors.toList());

    System.out.println("Возраста призывников: " + ages);

    Scanner scanner = new Scanner(System.in);
    List<String> logins = new ArrayList<>();

    System.out.println("Введите логины (пустая строка для завершения):");


    while (true) {
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            break;
        }
        logins.add(input);
    }

    logins.stream()
            .filter(login -> login.startsWith("f"))
            .forEach(System.out::println);

}
    public static class Person {
        String gender;
        int age;

    public Person(String pol, int age) {
        this.gender = pol;
        this.age = age;
        }
    }
