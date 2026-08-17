package java_foundation.basic_practice;

public class P1 {

    public static void main(String[] args) {

        double[] array = {78.5, 92.0, 45.5, 66.0, 81.0, 55.5};
        String statsResult = GradeStats.calculateStats(array);
        System.out.println(statsResult);

        String format = "%.2f -> ";
        for (double s : array) {
            System.out.println(String.format(format, s) + GradeStats.getLetterGrade(s));
        }

        System.out.println(NameFormatter.formatFullName("jERRY", "cHen"));
        

    }

}
