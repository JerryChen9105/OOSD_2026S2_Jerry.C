package java_foundation.interface_practice;

public class Car implements Racing_itf{
    int maxSpeed;
    String color;
    float weight;
    double windResistance;

    public static String parameterError = "invalid parameter, please re-enter again...";

    public Car(int maxSpeed, String color, float weight)
    {
        if (maxSpeed <= 0 || weight <= 0) {
            System.err.println(parameterError);
            this.maxSpeed = -1;
            this.weight = -1;
            this.color = null;
            return;
        }
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.weight = weight;
    }

    public boolean isEmpty()
    {
        return this.maxSpeed <= 0 || this.weight <= 0;
    }

    public void printAttribute()
    {
        if (this.isEmpty()) {
            System.err.println(parameterError);
            return;
        }
        System.out.println("car max speed: " + this.maxSpeed);
        System.out.println("car weight: " + this.weight);
        System.out.println("car color: " + this.color);
    }

    public void speedUp(int speedIncrement) {
        System.err.println(parameterError);
    }

}
