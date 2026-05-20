import java.util.Arrays;

public class Lessons2 {
    public static void main(String[] args) {
        System.out.println(method1(12, 9));
        method2(-10);
        System.out.println(method3(-11));
        method4(10, "Привет");
        System.out.println(method5(1900));
        method6();
        method7();
        method8();
        method9();
        System.out.println(Arrays.toString(method10(120, 10)));
    }

    public static boolean method1(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void method2(int c) {
        if (c >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean method3(int d) {
        return d < 0;
    }

    public static void method4(int e, String str) {
        for (int i = 0; i < e; i++) {
            System.out.println(str);
        }
    }

    public static boolean method5(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }


    public static void method6() {
        int[] numbers = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                numbers[i] = 0;
            } else {
                numbers[i] = 1;
            }
        }
        System.out.println("Массив после замены: " + Arrays.toString(numbers));
    }

    public static void method7() {
        int[] number = new int[100];
        for (int i = 0; i < number.length; i++) {
            number[i] = i + 1;
        }
        System.out.println(Arrays.toString(number));
    }

    public static void method8() {
        int[] numbe = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < numbe.length; i++) {
            if (numbe[i] < 6) {
                numbe[i] = numbe[i] * 2;
            }
        }
        System.out.println("Массив после замены: " + Arrays.toString(numbe));
    }

    public static void method9() {
        int[][] numb = new int[3][3];
        for (int i = 0; i < numb.length; i++) {
            numb[i][i] = 1;
        }
        for (int i = 0; i < numb.length; i++) {
            for (int j = 0; j < numb[i].length; j++) {
                System.out.print(numb[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] method10(int len, int initialValue) {
        int[] num = new int[len];
        for (int i = 0; i < num.length; i++) {
            num[i] = initialValue;
        }
        return num;
    }
}

