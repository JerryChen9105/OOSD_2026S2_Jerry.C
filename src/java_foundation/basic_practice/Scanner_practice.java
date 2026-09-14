package java_foundation.basic_practice;

import java.util.Scanner;
//import java.util.regex.Pattern;

public class Scanner_practice {
    
    public static void main(String[] args) {
        Object[] lst = new Object[5];
        System.out.println("Please enter double, int, char, string and boolean: ");
        Scanner terminalScanner = new Scanner(System.in);
        double lf = terminalScanner.nextDouble();
        int num = terminalScanner.nextInt();
        char c = terminalScanner.next().charAt(0);
        String str = terminalScanner.nextLine();

        lst[1] = lf;
        lst[2] = num;
        lst[3] = c;
        lst[4] = str;

        System.err.printf("%f => %d => %c => %s\n", lst[1], lst[2], lst[3], lst[4]);

        terminalScanner.close();

    }

}
