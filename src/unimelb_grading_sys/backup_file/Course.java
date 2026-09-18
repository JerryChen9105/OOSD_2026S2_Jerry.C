package unimelb_grading_sys.backup_file;


public class Course {
    int courseID; //primary key
    String courseName;
    String courseDescription;
    int requiredTotalCredit;

    public Course(int courseID, String courseName, String courseDescription, int creditNum) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.requiredTotalCredit = creditNum;
    }

    public String getCourseName(int courseID) {
        return this.courseName;
    }
}
