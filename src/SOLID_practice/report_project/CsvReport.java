package SOLID_practice.report_project;

public class CsvReport extends ReportManager {
    
    @Override 
    protected void generateFinishedMessage(String studentName, String grades) {
        System.out.println("将 " + studentName + " 的成绩 [" + grades + "] 打包为 CSV 格式...");
        System.out.println("发送到教育局邮箱。");
    }

}
