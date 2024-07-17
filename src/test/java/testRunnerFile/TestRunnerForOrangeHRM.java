package testRunnerFile;

import TestCaseFunctionality.AllTestCasesFunctions;
import com.aventstack.extentreports.Status;

import driverinitialization.*;
import extentreport.ExtentTestManager;
import org.openqa.selenium.WebDriver;


import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdatareader.TestDataReader;
import userdefinedExceptions.TestCaseOrFlagNotFoundException;

import java.time.Duration;
import java.util.Map;

public class TestRunnerForOrangeHRM extends ExtentReportGenerationClass{

    WebDriver driver;

    Map<String,String> excelsheetdata;


    @BeforeMethod
    public void initializeEnvironment(){

    }
    @Test()
    public void TestCase1(){
        TestDataReader read=new TestDataReader();
        startWritingInTestResult("Test Case 1: Login Functionality");
        try {
            excelsheetdata=read.readTestData("Test Case 1: Login Functionality");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("UAT");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Swarup Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Chrome");
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(excelsheetdata.get("URL"));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
            new  AllTestCasesFunctions().TestOranageHRM1(driver,read.getData("Username"),read.getData("Password"));
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }


    }

    @Test()
    public void TestCase2(){

        TestDataReader read=new TestDataReader();
        startWritingInTestResult("Test Case 2: Logout Functionality");
        try {
            excelsheetdata=read.readTestData("Test Case 2: Logout Functionality");
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
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
            new  AllTestCasesFunctions().TestOranageHRM2(driver,read.getData("Username"),read.getData("Password"));
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }


    }

    @Test(dependsOnMethods = "TestCase1")
    public void TestCase3(){
        TestDataReader read=new TestDataReader();
        startWritingInTestResult("Test Case 3: AdminLink Logout Functionality");
        try {
            excelsheetdata=read.readTestData("Test Case 3: AdminLink Logout Functionality");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Sanity");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Saksham Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Chrome");
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.get(excelsheetdata.get("URL"));
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
            new  AllTestCasesFunctions().TestOranageHRM3(driver,read.getData("Username"),read.getData("Password"));
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


            ThreadLocalDriver.getInstance().closeBrowser();

        }

    }

}
