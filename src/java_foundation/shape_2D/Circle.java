package java_foundation.shape_2D;

public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        super(1, 0,
              2.0 * Math.PI * Math.max(0, radius),
              Math.PI * Math.pow(Math.max(0, radius), 2));
        if (radius < 0) {
            System.out.println(shape_err);
            return;
        }
        this.radius = radius;
    }

    @Override
    public void printShape() {
        super.printShape();
        System.out.println("radius: " + this.radius);
    }
    
}
