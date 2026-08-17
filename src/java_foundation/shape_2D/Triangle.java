package java_foundation.shape_2D;

public class Triangle extends Shape {
    double angle1;
    double angle2;

    public Triangle(double angle1, double angle2, double circum) {
        super(3, 3, circum, computeArea(angle1, angle2, circum));
        this.angle1 = angle1;
        this.angle2 = angle2;
    }

    public static double computeArea(double angle1, double angle2, double circum) {
        angle1 = convertToRadian(angle1);
        angle2 = convertToRadian(angle2);
        double k = circum / (Math.sin(angle1) + Math.sin(angle2) + Math.sin(angle1 + angle2));
        return 0.5 * Math.pow(k, 2) * Math.sin(angle1) * Math.sin(angle2) * Math.sin(angle1 + angle2);
    }

    @Override
    public void printShape() {
        super.printShape();
        System.out.println("angle a: " + this.angle1);
        System.out.println("angle b: " + this.angle2);
        System.out.println("angle c: " + (180.0 - this.angle1 - this.angle2));
    }

}
