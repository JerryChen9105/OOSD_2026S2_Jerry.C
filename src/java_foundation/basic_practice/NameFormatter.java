package java_foundation.basic_practice;

public class NameFormatter {
    static public String formatFullName(String fname, String lname) {
        if (fname.isEmpty() || lname.isEmpty()) {
            System.err.println("invalid full name input");
            return null;
        }
        fname = fname.toLowerCase();
        lname = lname.toLowerCase();
        return fname.replaceFirst(fname.charAt(0) + "", (fname.charAt(0) + "").toUpperCase()) + " " +
               lname.replaceFirst(lname.charAt(0) + "", (lname.charAt(0) + "").toUpperCase());
    }

    static public String toInitials(String fullname) {
        return null;
    }
}
