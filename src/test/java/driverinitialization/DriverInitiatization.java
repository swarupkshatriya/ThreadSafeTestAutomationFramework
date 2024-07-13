package driverinitialization;

import com.aventstack.extentreports.ExtentReports;
import extentreport.ExtentReportsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverInitiatization {
    String browserName;
    WebDriver driver;

    public DriverInitiatization(String browserName) {
      //  readApplicationPropertiesfile();
        this.browserName=browserName;

    }
    public void readApplicationPropertiesfile(){

        File file=new File(System.getProperty("user.dir")+"\\applicationproperties\\"+"testconfiguration.properties") ;
        Properties prop=new Properties();
        try {
            prop.load(new FileInputStream(file));
            browserName=prop.getProperty("browserName");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public WebDriver driverReturn(){
        switch (browserName){
            case "Chrome":
                    driver=new ChromeDriver();
                    break;
            case "Edge":
                    driver=new EdgeDriver();
                    break;
            case "FireFox":
                    driver=new FirefoxDriver();
                    break;
            default:
                    driver=null;
        }
        return driver;
    }




}
