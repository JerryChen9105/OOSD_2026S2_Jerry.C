package java_foundation.shape_2D;

public class Shape {
    int edge;
    int vertex;
    double circumference;
    double area;

    public static String shape_err = "parameter error, unsatisfy 2D shape axiom.";

    public Shape(int edge, int vertex, double circum, double area) {
        if (edge < 1 || 4.0 * Math.PI * area > Math.pow(circum, 2)) {
            System.err.println(shape_err);
            return;
        }
        this.edge = edge;
        this.vertex = vertex;
        this.circumference = circum;
        this.area = area;
    }

    public static double convertToRadian(double angle) {
        return angle * Math.PI / 180.0;
    }

    public static double convertToAngle(double radian) {
        return radian * 180.0 / Math.PI;
    }

    public boolean equals(Shape shape) {
        return this.edge == shape.edge &&
               this.vertex == shape.vertex &&
               this.circumference == shape.circumference &&
               this.area == shape.area;
    }

    public boolean isEmpty() {
        return this.edge == 0 &&
               this.vertex == 0 &&
               this.circumference == 0 &&
               this.area == 0;
    }

    public void printShape() {
        System.out.println("edge: " + this.edge);
        System.out.println("vertex: " + this.vertex);
        System.out.printf("circumference: %.4f\n", this.circumference);
        System.out.printf("area: %.4f\n", this.area);
    }
}
