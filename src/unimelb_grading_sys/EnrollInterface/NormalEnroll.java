package unimelb_grading_sys.EnrollInterface;

public class NormalEnroll implements EnrollMethod {
    
    public boolean enrollSubject(String subjectCode) {
        if (subjectCode.isEmpty() || subjectCode.isBlank()) return false;

        String fieldPrefix = subjectCode.substring(0, 4);
        int subjectSufixx = Integer.parseInt(subjectCode.substring(4));
        // add code
        return true;
    }

}
