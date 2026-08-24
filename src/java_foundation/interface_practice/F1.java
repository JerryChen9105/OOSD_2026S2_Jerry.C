package java_foundation.interface_practice;

public class F1 extends Car implements Racing_itf{
    float elecCapacity;
    String fuel;

    public F1(int maxSpeed, String color, float weight, float elecCapacity, String fuel)
    {
        super(maxSpeed, color, weight);
        this.elecCapacity = elecCapacity;
        this.fuel = fuel;
    }

    @Override
    public void speedUp(int speedIncrement) {
        System.err.println(parameterError);
    }
}
