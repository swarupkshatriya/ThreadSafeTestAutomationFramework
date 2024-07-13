package testRunnerFile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import extentreport.ExtentReportsManager;
import extentreport.ExtentTestManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportGenerationClass {

    public void setExtent(ExtentReports extent) {
        this.extent = extent;
    }

    public   ExtentReports extent;
    public  ExtentSparkReporter html_reproter;
    public   ExtentTest test;

    public ExtentTest getTest() {
        return test;
    }

    public ExtentReports getExtent() {
        return extent;
    }


    public ExtentReportGenerationClass() {
    }

    @BeforeSuite()
    public void reportGenerate(){
        String path = "extent_report.html";
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        String newDate=dateFormat.format(date);
        html_reproter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\TestResult\\"+newDate+"_"+path);
        extent=new ExtentReports();
        //ExtentReportsManager.getInstance(extent);
        setExtent(extent);
        html_reproter.config().setTheme(Theme.STANDARD);
        html_reproter.config().setDocumentTitle("AutomationExcerciseReport");
        html_reproter.config().setReportName("ReportName");

        html_reproter.viewConfigurer().viewOrder().as(new ViewName[] {
                        ViewName.DASHBOARD,
                        ViewName.TEST,
                        ViewName.AUTHOR,
                        ViewName.DEVICE,
                        ViewName.EXCEPTION,
                        ViewName.LOG
                })
                .apply();
        extent.attachReporter(html_reproter);
        extent.setSystemInfo("OS",System.getenv("OS"));
        extent.setSystemInfo("USER",System.getenv("USERNAME"));
        extent.setSystemInfo("JAVA_HOME",System.getenv("JAVA_HOME"));
        extent.setSystemInfo("URL","URL");
        extent.setSystemInfo("Browser","Browser");



    }
    public void startWritingInTestResult(String testCaseName){
        test=ExtentReportsManager.getInstance(extent).getExtents().createTest(testCaseName);
        ExtentTestManager.getInstance(test);
    }
    @AfterSuite()
    public void closeReport(){
        ExtentReportsManager.getInstance(extent).getExtents().flush();

    }

}
