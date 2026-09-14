package SOLID_practice.report_project;

public class PdfReport extends ReportManager {
    
    @Override 
    protected void generateFinishedMessage(String studentName, String grades) {
        System.out.println("将 " + studentName + " 的成绩 [" + grades + "] 打包为 PDF 格式...");
        System.out.println("保存到本地磁盘。");
    }

}
