package Lessons6;

import java.io.*;
import java.util.Arrays;

public class SimpleCSV {

    public static void main(String[] args) {
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {{1, 2, 3}, {4, 5, 6}};

        AppData app = new AppData(header, data);
        app.save("data.csv");

        AppData loaded = AppData.load("data.csv");

        System.out.println("Заголовок: " + Arrays.toString(loaded.getHeader()));
        System.out.println("Данные: " + Arrays.deepToString(loaded.getData()));
    }
}

class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write((String.join(";", header) + "\n").getBytes());

            for (int[] row : data) {
                String line = row[0] + ";" + row[1] + ";" + row[2] + "\n";
                fos.write(line.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData load(String filename) {
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String content = new String(bytes);

            String[] lines = content.split("\n");
            String[] header = lines[0].split(";");

            int rows = lines.length - 1;
            int cols = header.length;
            int[][] data = new int[rows][cols];

            for (int i = 1; i < lines.length; i++) {
                String[] values = lines[i].split(";");
                for (int j = 0; j < cols; j++) {
                    data[i-1][j] = Integer.parseInt(values[j]);
                }
            }

            return new AppData(header, data);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }
}
