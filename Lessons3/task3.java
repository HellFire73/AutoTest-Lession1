package Lessons3;

import java.time.LocalTime;

public class task3 {
    public static class Park {
        public static class Attraction {
            String info;
            int price;
            LocalTime open;
            LocalTime closed;

            public Attraction(String info, int price, LocalTime open, LocalTime closed) {
                this.info = info;
                this.price = price;
                this.open = open;
                this.closed = closed;
            }

            public String toString() {
                return (info + " " + price + " " + open + " " + closed);
            }
        }
    }

    public static void main(String[] args) {
        Park.Attraction attraction1 = new Park.Attraction("Колесо обозрения", 100, LocalTime.of(10, 0), LocalTime.of(18, 0));
        System.out.println(attraction1);
    }
}
