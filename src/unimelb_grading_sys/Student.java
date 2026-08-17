package unimelb_grading_sys;
import java.util.*;
public class Student {
    int sid; //primary key
    String fname;
    String lname;
    Datetime birthday;
    String courseID;
    String majorID;
    Vector <String> subjectName;
    

    public Student(int sid, String fname, String lname, Datetime birthday) {
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
        this.courseID = null;
        this.birthday = birthday;
        this.majorID = null;
    }



}
