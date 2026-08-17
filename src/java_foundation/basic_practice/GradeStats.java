package java_foundation.basic_practice;

public class GradeStats {

    public static String calculateStats(double[] scores) {
        if (scores == null) {
            System.err.println("empty score records");
            return null;
        }
        double min = 100.0, max = 0.0, total = 0.0;
        int pass = 0, num = 0;
        for (double s : scores) {
            if (max <= s) max = s;
            if (min >= s) min = s;
            if (s >= 60.0) pass++;
            total += s;
            num++;
        }
        double avg = total / num;
        double passRate = (pass * 1.0 / num) * 100;
        String rs = "Average: %.2f, Highest: %.2f, Lowest: %.2f, Pass Rate: %.2f";
        return String.format(rs, avg, max, min, passRate);
    }

    public static String getLetterGrade(double score) {
        if (score < 0 || score > 100) {
            System.err.println("invalid score");
            return null;
        }
        if (score < 50) return "F";
        if (score < 60) return "P";
        if (score < 70) return "C";
        if (score < 80) return "D";
        return "HD";
    }
}
