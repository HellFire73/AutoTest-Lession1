package Lessons3;

public class Lessons3 {
    public static class Person {
        String fio;
        String position;
        String email;
        String phoneNumber;
        int salary;
        int age;

        public Person(String fio, String position, String email, String phoneNumber, int salary, int age) {
            this.fio = fio;
            this.position = position;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.salary = salary;
            this.age = age;
            }

        public String toString() {
            return (fio + " " + position + " " + email + " " + phoneNumber + " " + salary + " " + age);

        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("Лежанкин Владислав Константинович", "Куа", "Vladqaeng@gmail.com", "+79603779603", 200, 28);
        System.out.println(person1);
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Iva Ivan", "Engineer",

                "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Ivanov Ian", "Engineer",

                "ivivan@mailbox.com", "892312312", 30000, 40);
        persArray[2] = new Person("Ivanv Ivan", "Engineer",

                "ivivan@mailbox.com", "892312312", 30000, 50);
        persArray[3] = new Person("Ivanov Iva", "Engineer",

                "ivivan@mailbox.com", "892312312", 30000, 10);
        persArray[4] = new Person("Ivano Ivan", "Engineer",

                "ivivan@mailbox.com", "892312312", 30000, 20);
        for (int i = 0; i < persArray.length; i++) {
        if (persArray[i].age > 40) {
            System.out.println(persArray[i]);
        }
    }
    }

}