package testRunnerFile;

import TestCaseFunctionality.AllTestCasesFunctions;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import driverinitialization.*;
import extentreport.ExtentReportsManager;
import extentreport.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import testdatareader.TestDataReader;
import userdefinedExceptions.TestCaseOrFlagNotFoundException;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Map;

public class TestRunnerForVehicleInsurance extends ExtentReportGenerationClass{

    WebDriver driver;
    RemoteWebDriver remoteWebDriver;
    Map<String,String> excelsheetdata;
    @Test()
    public void TestCase1(ITestContext context){

        TestDataReader read=new TestDataReader();
        String browser=context.getCurrentXmlTest().getParameter("browser");
        String execution=context.getCurrentXmlTest().getParameter("execution");
        //excelsheetdata=read.readTestData("Test Case 1: Register User");
        startWritingInTestResult("Test Case 1: Automobile");
        try {
            excelsheetdata=read.readTestData("Test Case 1: Automobile");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Chrome");
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(excelsheetdata.get("URL"));

           // driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
//            new AllTestCasesFunctions().TestCase1(driver,read.getData("Name"),read.getData("EmailAddress")
//                    ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
//                    ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
//                    read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
//                    read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"),
//                    read.getData("TestDataOutputWorkBook"),read.getData("TestDataOutputSheet"),
//                    read.getData("OutputTestCaseName"),read.getData("TestOutputColumn"),read.getData("TestOutColumnPassword"));
         new AllTestCasesFunctions().TestAutomobile1(ThreadLocalDriver.getInstance().getDriver(),read.getData("Make"),read.getData("EnginePerformance"),read.getData("DateOFManufacturing"),read.getData("NumberofSeats"),read.getData("FuelType"),read.getData("ListPrice"),read.getData("LicensePlateNumber"),read.getData("AnualMilege"));
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }


    }

    @Test()
    public void TestCase2(ITestContext context){

        TestDataReader read=new TestDataReader();
        String browser=context.getCurrentXmlTest().getParameter("browser");
        String execution=context.getCurrentXmlTest().getParameter("execution");
        //excelsheetdata=read.readTestData("Test Case 1: Register User");
        startWritingInTestResult("TTest Case 2: Truck");
        try {
            excelsheetdata=read.readTestData("Test Case 2: Truck");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Chrome");
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.get(excelsheetdata.get("URL"));
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           // driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
//            new AllTestCasesFunctions().TestCase1(driver,read.getData("Name"),read.getData("EmailAddress")
//                    ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
//                    ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
//                    read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
//                    read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"),
//                    read.getData("TestDataOutputWorkBook"),read.getData("TestDataOutputSheet"),
//                    read.getData("OutputTestCaseName"),read.getData("TestOutputColumn"),read.getData("TestOutColumnPassword"));
            new AllTestCasesFunctions().TestAutomobile2(driver,read.getData("Make"),read.getData("EnginePerformance"),read.getData("DateOFManufacturing"),read.getData("NumberofSeats"),read.getData("FuelType"),read.getData("ListPrice"),read.getData("LicensePlateNumber"),read.getData("AnualMilege"));
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }


    }

    @Test(dependsOnMethods = "TestCase1")
    public void TestCase3(ITestContext context){
        TestDataReader read=new TestDataReader();
        String browser=context.getCurrentXmlTest().getParameter("browser");
        String execution=context.getCurrentXmlTest().getParameter("execution");
        //excelsheetdata=read.readTestData("Test Case 1: Register User");
        startWritingInTestResult("Test Case 3: Camper");
        try {
            excelsheetdata=read.readTestData("Test Case 3: Camper");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Chrome");
                driver= ThreadLocalDriver.getInstance().getDriver();
               // driver=DriverInitializationManager.getInstance("FireFox","Local").getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.get(excelsheetdata.get("URL"));
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          //  driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
//            new AllTestCasesFunctions().TestCase1(driver,read.getData("Name"),read.getData("EmailAddress")
//                    ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
//                    ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
//                    read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
//                    read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"),
//                    read.getData("TestDataOutputWorkBook"),read.getData("TestDataOutputSheet"),
//                    read.getData("OutputTestCaseName"),read.getData("TestOutputColumn"),read.getData("TestOutColumnPassword"));
            new AllTestCasesFunctions().TestAutomobile3(driver,read.getData("Make"),read.getData("EnginePerformance"),read.getData("DateOFManufacturing"),read.getData("NumberofSeats"),read.getData("FuelType"),read.getData("ListPrice"),read.getData("LicensePlateNumber"),read.getData("AnualMilege"));
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }



    }

    @Test()
    public void TestCase4(ITestContext context){

        TestDataReader read=new TestDataReader();
        String browser=context.getCurrentXmlTest().getParameter("browser");
        String execution=context.getCurrentXmlTest().getParameter("execution");
        //excelsheetdata=read.readTestData("Test Case 1: Register User");
        startWritingInTestResult("Test Case 4: MotorCycle");
        try {
            excelsheetdata=read.readTestData("Test Case 4: MotorCycle");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Chrome");
                driver= ThreadLocalDriver.getInstance().getDriver();
//                driver=DriverInitializationManager.getInstance("Chrome","Local").getDriver();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.get(excelsheetdata.get("URL"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            //driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
//            new AllTestCasesFunctions().TestCase1(driver,read.getData("Name"),read.getData("EmailAddress")
//                    ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
//                    ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
//                    read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
//                    read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"),
//                    read.getData("TestDataOutputWorkBook"),read.getData("TestDataOutputSheet"),
//                    read.getData("OutputTestCaseName"),read.getData("TestOutputColumn"),read.getData("TestOutColumnPassword"));
            new AllTestCasesFunctions().TestAutomobile4(driver,read.getData("Make"),read.getData("EnginePerformance"),read.getData("DateOFManufacturing"),read.getData("NumberofSeats"),read.getData("FuelType"),read.getData("ListPrice"),read.getData("LicensePlateNumber"),read.getData("AnualMilege"));
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }



    }


    @AfterMethod()
    public synchronized void tearDown(ITestResult result){

        switch (result.getStatus()){
            case 1 :
                if(ExtentTestManager.getInstance(test).getTest()!=null){
                    ExtentTestManager.getInstance(test).getTest().pass("Test Case is Passed");
                    ExtentTestManager.getInstance(test).getTest().info("Test Completed");
                }
                break;

            case 2 :
                if(ExtentTestManager.getInstance(test).getTest()!=null){
                    ExtentTestManager.getInstance(test).getTest().fail("Test Case is Failed");
                }
                break;

            case 3 :
                if(ExtentTestManager.getInstance(test).getTest()!=null){
                    ExtentTestManager.getInstance(test).getTest().skip("Skip the Test Case as Flag is set as N");
                }

                break;


        }
        if(DriverInitializationManager.getRemoteWebDriver()!=null){
            if(ExtentTestManager.getInstance(test).getTest()!=null){
                ExtentTestManager.getInstance(test).getTest().info("Browser is closed");
                ExtentTestManager.remoteAttachment();
            }
            DriverInitializationManager.remoteRemoteAttachment();

        }
        if(ThreadLocalDriver.getInstance().getDriver()!=null){
            if(ExtentTestManager.getInstance(test).getTest()!=null){
                ExtentTestManager.getInstance(test).getTest().info("Browser is closed");
                ExtentTestManager.remoteAttachment();
            }

           // DriverInitializationManager.remoteAttachment();
            ThreadLocalDriver.getInstance().closeBrowser();

        }

    }

}
