
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    private Map<String, List<String>> directory = new HashMap<>();

    public void add(String family, String phoneNumber) {
        if (directory.containsKey(family)) {
            List<String> numbers = directory.get(family);
            numbers.add(phoneNumber);
            System.out.println("Номер добавлен к существующей записи: " + family);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            directory.put(family, numbers);
            System.out.println("Создана новая запись для: " + family);
        }
    }

    public List<String> get(String family) {
        return directory.getOrDefault(family, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneNumber phonebook = new PhoneNumber();
        phonebook.add("Иванов", "+7-123-456-78-90");

        List<String> ivanovNumbers = phonebook.get("Иванов");
        System.out.println("Номера Иванова: " + ivanovNumbers);
    }
}

