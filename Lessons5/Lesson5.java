package Lessons5;

public class Lesson5 {

    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Ошибка: массив должен иметь 4 строки, а имеет " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Ошибка: строка " + i + " должна иметь 4 столбца, а имеет " + array[i].length);
            }
        }

        System.out.println("Массив имеет правильный размер 4x4");

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int number = Integer.parseInt(array[i][j]);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }

        return sum;
    }

    static class MyArrayDataException extends Exception {
        private int row;
        private int col;
        private String value;

        public MyArrayDataException(int row, int col, String value) {
            super(String.format("Ошибка в ячейке [%d][%d]: '%s' не является числом", row, col, value));
            this.row = row;
            this.col = col;
            this.value = value;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {

        String[][] array1 = {
                {"1", "2", "3", "44"},
                {"5", "66", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        System.out.println("=== Проверяем array1 (правильный) ===");
        try {
            int sum = processArray(array1);
            System.out.println("Сумма всех элементов: " + sum);
            System.out.println("Ожидаемая сумма: 136");
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
            System.out.println("  Строка: " + e.getRow() + ", Столбец: " + e.getCol());
            System.out.println("  Некорректное значение: " + e.getValue());
        }

        System.out.println();
    }
}
