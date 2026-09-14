package SOLID_practice.report_project;

public abstract class ReportManager {
    
    public void generateReport(String studentName) {

        generateConnectionMessage();
        String grades = getDBData();
        generateFinishedMessage(studentName, grades);
        
    }

    private void generateConnectionMessage() {
        System.out.println("连接 MySQL: jdbc:mysql://192.168.64.1/cjy_test_db");
    }

    private String getDBData() {
        String grades = "A, B+, A-";
        return grades;
    }

    abstract protected void generateFinishedMessage(String studentName, String grades);

}
