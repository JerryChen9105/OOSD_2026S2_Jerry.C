package unimelb_grading_sys;

import java.sql.SQLException;
import java.util.*;

public class App {

    public static void main(String[] args) {
        System.out.println("+".repeat(45) + "\n");
        System.out.println("Unimelb virtual learning management system\n");
        System.out.println("+".repeat(45) + "\n");

        queryAllSubject();
        queryAllStudyField();

        Student s1 = new Student(1767173, "aaaa", "bbbb", new Datetime(2000, 1, 1));
        if (insertStudent(s1)) {
            System.out.println("Student " + s1.toString() + "insert successfully\n");
        } else {
            System.out.println(DBHelper.resultIterateError + "\n");
        }

        if (deleteStudent(1767174)) {
            System.out.println("Student delete successfully\n");
        } else {
            System.out.println(DBHelper.resultIterateError + "\n");
        }

        queryAskedStudentEnrolment(1767172);

    }

    public static void queryAllSubject() {
        String sql = "select * from subject order by subjectCode asc";
        String[] keyOrder = {"fieldPrefix", "subjectCode", "creditPoint", "subjectName"};
        List<Map<String, Object>> rl = DBHelper.executeQuery(sql);

        for (Map<String, Object> map : rl) {
            for (String key : keyOrder) {
                Object value = map.get(key);
                System.out.printf("%-15s", value);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    public static void queryAllStudyField() {
        String sql = "select * from study_field";
        List<Map<String, Object>> rl = DBHelper.executeQuery(sql);

        for (Map<String, Object> map : rl) {
            map.forEach(
                (key, value) -> {
                    System.out.printf("%-30s", value);
                }
            );
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    public static void queryAskedStudentEnrolment(int sid) {
        String sql = "select * from (\n" + //
                        "select a.fieldPrefix, a.subjectCode, b.subjectName, a.enrolmentDatetime, a.subjectType, a.score\n" + //
                        "from student_enrolment as a inner join subject as b on a.fieldPrefix = b.fieldPrefix and a.subjectCode = b.subjectCode\n" + //
                        "where a.sid = 1767172 order by a.subjectCode asc ) as c\n" + //
                        "order by c.subjectType asc";
        String[] keyOrder = {"fieldPrefix", "subjectCode", "subjectName", "enrolmentDatetime", "subjectType", "score"};
        List<Map<String, Object>> rl = DBHelper.executeQuery(sql);

        System.out.println("student " + Integer.toString(sid) + "'s enrolment subjects: ");
        for (Map<String, Object> map : rl) {
            for (int i = 0; i < 6; i++) {
                if (i == 2) System.out.printf("%-40s", map.get(keyOrder[2]));
                else if (i == 3) System.out.printf("%-25s", map.get(keyOrder[3]));
                else System.out.printf("%-12s", map.get(keyOrder[i]));
            }
            System.out.printf("\n");
        }
    }

    public static boolean insertStudent(Student student) {
        String sql = "insert into student (sid, fname, lname, courseID, birthday, majorID) values (?, ?, ?, ?, ?, ?)";

        List<Object> params = new ArrayList<>();
        params.add(student.sid);
        params.add(student.fname);
        params.add(student.lname);
        params.add(student.courseID);
        params.add(student.birthday.date);
        params.add(student.majorID);

        return DBHelper.executeUpdate(sql, pstmt -> {
            try {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }) > 0;
    }

    public static boolean deleteStudent(int sid) {
        String sql = "delete from student where sid = ?";

        return DBHelper.executeUpdate(sql, pstmt -> {
            try {
                pstmt.setInt(1, sid);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }) > 0;

    }
    
}
