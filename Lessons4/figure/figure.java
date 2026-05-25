package Lessons4.figure;

import java.awt.*;

public class figure {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0, Color.YELLOW, Color.RED);
        circle.printInfo();
        Rectangle rectangle = new Rectangle(10, 2, Color.ORANGE, Color.YELLOW);
        rectangle.printInfo();
    }
}

interface GeometricFigure {
    double calculatePerimeter();
    double calculateArea();

    Color getFillColor();
    Color getBorderColor();

    default void printInfo() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + colorToString(getFillColor()));
        System.out.println("Цвет границы: " + colorToString(getBorderColor()));
    }

    default String colorToString(Color color) {
        if (color.equals(Color.RED)) return "Красный";
        if (color.equals(Color.GREEN)) return "Зеленый";
        if (color.equals(Color.BLUE)) return "Синий";
        if (color.equals(Color.YELLOW)) return "Желтый";
        if (color.equals(Color.ORANGE)) return "Оранжевый";
        if (color.equals(Color.CYAN)) return "Голубой";
        if (color.equals(Color.MAGENTA)) return "Фиолетовый";
        if (color.equals(Color.PINK)) return "Розовый";
        if (color.equals(Color.GRAY)) return "Серый";
        if (color.equals(Color.BLACK)) return "Черный";
        if (color.equals(Color.WHITE)) return "Белый";
        return "Пользовательский цвет";
    }
}

class Circle implements GeometricFigure {
    private double radius;
    private Color fillColor;
    private Color borderColor;

    public Circle(double radius, Color fillColor, Color borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override

    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements GeometricFigure {
    private double sideA;
    private double sideB;
    private Color fillColor;
    private Color borderColor;

    public Rectangle(double sideA, double sideB, Color fillColor, Color borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (sideA + sideB);
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}


