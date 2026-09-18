package unimelb_grading_sys.class_package.Student;

import unimelb_grading_sys.EnrollInterface.EnrollMethod;
import unimelb_grading_sys.backup_file.Datetime;
import unimelb_grading_sys.class_package.*;
import java.util.*;

public class Student {
    int sid; //primary key
    String fname;
    String lname;
    Datetime birthday;
    String courseID;
    String majorID;
    ArrayList<String> subjectName;
    EnrollMethod enrollMethod;
    

    public Student(int sid, String fname, String lname, Datetime birthday) {
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
        this.courseID = null;
        this.birthday = birthday;
        this.majorID = null;
    }

    public void enrollSubject(String subjectCode) {
        if (enrollMethod.EnrollSubject(subjectCode)) {
            System.out.println("Enroll Successfully");
        } else {
            System.out.println("Failed to enroll ... ");
        }
    }

}
