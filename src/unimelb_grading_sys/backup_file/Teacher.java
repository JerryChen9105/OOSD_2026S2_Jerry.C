package unimelb_grading_sys.backup_file;

public class Teacher {
    int tid;
    String fname;
    String lname;
    Datetime employDate;

    public Teacher(int tid, String fname, String lname, Datetime employDate) {
        this.tid = tid;
        this.fname = fname;
        this.lname = lname;
        this.employDate = employDate;
    }
    
}
