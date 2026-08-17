package java_foundation.basic_practice;

import java.util.Scanner;
import java_foundation.shape_2D.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);
        System.out.printf("please enter your name: ");
        String str = scanner.nextLine();
        System.out.println("Nice to meet you, " + str + "!");
        scanner.close();

        Shape shape = new Shape(1, 0, 1, 1);
        shape.printShape();
        if (shape.isEmpty()) System.out.println("this shape is empty");

        Triangle shape2 = new Triangle(90, 45, 2.0f + Math.sqrt(2));
        if (shape2.equals(shape)) System.out.println("these 2 shape is equal");
        shape2.printShape();

        System.out.println(Shape.convertToRadian(150) / Math.PI + "PI");

        //System.out.println(Math.pow(3, 2));
    }
}
