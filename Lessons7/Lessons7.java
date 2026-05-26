package Lessons7;

import java.util.*;

public class Lessons7 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Orange");
        arrayList.add("Juice");
        arrayList.add("Banana");
        arrayList.add("Tomato");
        arrayList.add("Cucumber");
        arrayList.add("Poridge");
        arrayList.add("Apple");
        arrayList.add("Cucumber");
        arrayList.add("Tomato");
        arrayList.add("Soon");


        List<String> uniqueWords = getUniqueWords(arrayList);
        System.out.println("Уникальные слова: " + uniqueWords);

        System.out.println("\nПодсчёт слов:");
        countWords(arrayList);
    }

    public static List<String> getUniqueWords(List<String> arrayList) {
        Set<String> uniqueSet = new HashSet<>(arrayList);
        return new ArrayList<>(uniqueSet);
    }

    public static void countWords(List<String> list) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : list) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)");
        }
    }
}