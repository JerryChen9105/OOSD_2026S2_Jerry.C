package unimelb_grading_sys.class_package;

import unimelb_grading_sys.backup_file.Datetime;

public class Subject {
    String fieldPrefix; //primary key
    int subjectCode; //primary key
    float creditPoints;
    String subjectName;

    public Subject(String subjectMixedCode, String name, SubjectType type,
                   float creditPoints, Datetime enrolmentDate, int score) {
        this.fieldPrefix = subjectMixedCode.substring(0, 4);
        this.subjectCode = Integer.parseInt(subjectMixedCode.substring(4));
        this.subjectName = name;
        this.creditPoints = creditPoints;
    }

}
