package java_foundation.basic_practice;

public class PermissionSys {
    
    public static void main(String[] args) {
        int age = 15;
        float height = 177.0f;
        boolean canRide = false;
        canRide = (age <= 60 && age >= 12 && height > 140.0);

        System.out.println("rider's age: " + age + " years old");
        System.out.println("rider's height: " + height + " cm");
        System.out.println("permitted to ride: " + canRide);

    }

}

