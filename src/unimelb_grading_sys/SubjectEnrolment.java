package unimelb_grading_sys;

public class SubjectEnrolment {
    int sid; //primary foreign key
    String fieldPrefix; //primary foreign key
    int subjectCode; //primary foreign key
    Datetime enrolmentDatetime;
    SubjectType subjectType;
    Grade grade;

    public SubjectEnrolment(int sid, String fieldPrefix, int subjectCode, float score, Datetime enrolmentDatetime) {
        this.sid = sid;
        this.fieldPrefix = fieldPrefix;
        this.subjectCode = subjectCode;
        this.enrolmentDatetime = enrolmentDatetime;
        this.subjectType = null;
        this.grade = new Grade(score);
    }
}
