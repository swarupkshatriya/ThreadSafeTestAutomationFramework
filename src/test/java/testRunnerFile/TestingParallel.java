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
import java.util.Map;

public class TestingParallel extends ExtentReportGenerationClass{

    WebDriver driver;
    RemoteWebDriver remoteWebDriver;
    Map<String,String> excelsheetdata;
    @Test()
    public void TestCase1(ITestContext context){

            TestDataReader read=new TestDataReader();
            String browser=context.getCurrentXmlTest().getParameter("browser");
            String execution=context.getCurrentXmlTest().getParameter("execution");
           //excelsheetdata=read.readTestData("Test Case 1: Register User");
            startWritingInTestResult("Test Case 1: Register User");
            try {
                excelsheetdata=read.readTestData("Test Case 1: Register User");
            } catch (TestCaseOrFlagNotFoundException e) {
                throw new RuntimeException(e);
            }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
                ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
                ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Edge");
                driver= ThreadLocalDriver.getInstance().getDriver();
                // driver= DriverInitializationManager.getDriver();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.get(excelsheetdata.get("URL"));
            driver.manage().window().maximize();
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"https://www.google.com");
                new AllTestCasesFunctions().TestCase1(driver,read.getData("Name"),read.getData("EmailAddress")
                        ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
                        ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
                        read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
                        read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"),
                        read.getData("TestDataOutputWorkBook"),read.getData("TestDataOutputSheet"),
                        read.getData("OutputTestCaseName"),read.getData("TestOutputColumn"),read.getData("TestOutColumnPassword"));

            }else{
                ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
                throw new SkipException("Skipping the test cases");
            }


    }

    @Test()
    public void TestCase2(ITestContext context){

        TestDataReader read=new TestDataReader();
//            String browser=context.getCurrentXmlTest().getParameter("browser");
           String execution=context.getCurrentXmlTest().getParameter("execution");
           // excelsheetdata=read.readTestData("Test Case 2: Login User with correct email and password");
        startWritingInTestResult("Test Case 2: Login User with correct email and password");
        try {
            excelsheetdata=read.readTestData("Test Case 2: Login User with correct email and password");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){
                ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
                ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
                //remoteWebDriver= DriverInitializationManager.getInstance("FireFox",execution).getRemoteWebDriver();
            try {
                //driver=DriverInitializationManager.getInstance("Chrome","Local").getDriver();
               // driver=DriverInitializationManager.getDriver();
                ThreadLocalDriver.getInstance().setDriver("Chrome");
                driver= ThreadLocalDriver.getInstance().getDriver();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.get(excelsheetdata.get("URL"));
            driver.manage().window().maximize();
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Edge Browser");
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"https://www.flipkart.com");
                new AllTestCasesFunctions().TestCase2(ThreadLocalDriver.getInstance().getDriver(),read.getData("Name"),read.getData("EmailAddress")
                        ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
                        ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
                        read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
                        read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"));

            }else{
                ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
                throw new SkipException("Skipping the test cases");
            }


    }

    @Test(dependsOnMethods = "TestCase1")
    public void TestCase3(ITestContext context){

            TestDataReader read=new TestDataReader();
//            String browser=context.getCurrentXmlTest().getParameter("browser");
//            String execution=context.getCurrentXmlTest().getParameter("execution");
            //excelsheetdata=read.readTestData("Test Case 3: Login User with incorrect email and password");
        startWritingInTestResult("Test Case 3: Login User with incorrect email and password");
        try {
            excelsheetdata=read.readTestData("Test Case 3: Login User with incorrect email and password");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

                ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
                ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
               // driver=DriverInitializationManager.getInstance("FireFox","Local").getDriver();
               // driver= DriverInitializationManager.getDriver();
                ThreadLocalDriver.getInstance().setDriver("Edge");
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.get(excelsheetdata.get("URL"));
           // driver.manage().window().maximize();
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Edge Browser");
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"https://www.irctc.co.in");
                new AllTestCasesFunctions().TestCase3(ThreadLocalDriver.getInstance().getDriver(),read.getData("TestDataInputWorkBook"),read.getData("TestDataInputSheet"),read.getData("TestInPutTestCaseName"),read.getData("TestInputColEmail"),read.getData("TestInputColPassword"));

            }else{
                ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
                throw new SkipException("Skipping the test cases");
            }


    }

    @Test()
    public void TestCase4(ITestContext context){

            TestDataReader read=new TestDataReader();
//            String browser=context.getCurrentXmlTest().getParameter("browser");
//            String execution=context.getCurrentXmlTest().getParameter("execution");
           // excelsheetdata=read.readTestData("Test Case 4: Logout User");
             startWritingInTestResult("Test Case 4: Logout User");
        try {
            excelsheetdata=read.readTestData("Test Case 4: Logout User");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){
                 ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
                 ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
               // driver=DriverInitializationManager.getInstance("Edge","Local").getDriver();
              //  driver= DriverInitializationManager.getDriver();
                ThreadLocalDriver.getInstance().setDriver("Chrome");
                driver= ThreadLocalDriver.getInstance().getDriver();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.navigate().to(excelsheetdata.get("URL"));
            driver.manage().window().maximize();
                 ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Edge Browser");
                 ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
                 ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"https://www.amazon.co.in");
                 new AllTestCasesFunctions().TestCase4(ThreadLocalDriver.getInstance().getDriver(),read.getData("Name"),read.getData("EmailAddress")
                         ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
                         ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
                         read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
                         read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"));

             }else {
                 ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
                 throw new SkipException("Skipping the test cases");
             }


    }


    @AfterMethod()
    public synchronized void tearDown(ITestResult result){

        switch (result.getStatus()){
            case 1:

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
//        if(DriverInitializationManager.getRemoteWebDriver()!=null){
//            if(ExtentTestManager.getInstance(test).getTest()!=null){
//                ExtentTestManager.getInstance(test).getTest().info("Browser is closed");
//                ExtentTestManager.remoteAttachment();
//            }
//            DriverInitializationManager.remoteRemoteAttachment();
//
//        }
        if(ThreadLocalDriver.getInstance().getDriver()!=null){
            if(ExtentTestManager.getInstance(test).getTest()!=null){
                ExtentTestManager.getInstance(test).getTest().info("Browser is closed");
                ExtentTestManager.remoteAttachment();
            }

            //DriverInitializationManager.remoteAttachment();
            ThreadLocalDriver.getInstance().closeBrowser();


        }

    }

}
