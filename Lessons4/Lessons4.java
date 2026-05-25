package Lessons4;

public class Lessons4 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик");
        Dog dog1 = new Dog("Шарик");
        BowlOfFood bowl1 = new BowlOfFood(10);
        cat1.run(300);
        cat1.swim(8);
        dog1.run(600);
        dog1.swim(12);


        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        cat1.eat(bowl1, 5);

    }
}

class BowlOfFood {
    private int foodAmount;

    public BowlOfFood(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public boolean getFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            System.out.println("  Из миски взяли " + amount + " кг. Осталось: " + foodAmount + " кг");
            return true;
        }
        else {
            System.out.println("  В миске недостаточно еды! Нужно " + amount + " кг, а есть только " + foodAmount + " кг");
            return false;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount +=amount;
            System.out.println("Добавлено " + amount + " кг еды. Теперь в миске " + foodAmount + " кг");
        }
    }
}

class Animal {
    public String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м");
    };

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м");
    };

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety;

   public Cat (String name) {
       super(name);
       catCount++;
       this.satiety = false;
   }

    public void eat(BowlOfFood bowl, int amount) {
        if (satiety) {
            System.out.println(name + " уже сыт и не хочет есть");
            return;
        }

        System.out.print(name + " пытается съесть " + amount + " кг: ");
        if (bowl.getFood(amount)) {
            satiety = true;
            System.out.println("  " + name + " насытился!");
        } else {
            System.out.println("  " + name + " остался голодным");
        }
    }

    public boolean getSatiety() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }

   @Override
   public void swim(int distance) {
       System.out.println(name + " не умеет плавать");
   };

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println(name + " может пробежать не более 200 м");
        } else {
            System.out.println(name + " пробежал " + distance + " м");
        }
    };

}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    };

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(name + " может проплыть не более 10 м");
        } else {
            System.out.println(name + " проплыл " + distance + " м");
        }
    };

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(name + " может пробежать не более 500 м");
        } else {
            System.out.println(name + " пробежал " + distance + " м");
        }
    };
}
