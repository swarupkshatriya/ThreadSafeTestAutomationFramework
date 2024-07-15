package testRunnerFile;
import TestCaseFunctionality.AllTestCasesFunctions;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import driverinitialization.DriverInitializationManager;
import driverinitialization.DriverInitiatization;
import extentreport.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import testdatareader.TestDataReader;
import userdefinedExceptions.TestCaseOrFlagNotFoundException;

import java.net.MalformedURLException;
import java.util.Map;

public class TestingTestNGTestCase extends ExtentReportGenerationClass{
    WebDriver driver;
    Map<String,String>excelsheetdata;
    @Test()
    public void TestCase1(){
        try{
        TestDataReader read=new TestDataReader();
        excelsheetdata=read.readTestData("Test Case 1: Register User");
        ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
        ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            String code = "<root>" +
                    "\n  <Person>" +
                    "\n    <Name>Swarup Kshatriya</Name>" +
                    "\n    <StartDate>2024-07-04</StartDate>" +
                    "\n    <EndDate>2024-07-05</EndDate>" +
                    "\n    <Location>USA</Location>" +
                    "\n  </Person>" +
                    "\n</root>";
            Markup m = MarkupHelper.createCodeBlock(code);
            ExtentTestManager.getInstance(test).getTest().info(m);
       // startWritingInTestResult(excelsheetdata.get("TestCaseName"));
        if(read.getData("RunMode").equalsIgnoreCase("Y")){
               // DriverInitiatization webDriver=new DriverInitiatization(excelsheetdata.get("Browser"));
                driver=DriverInitializationManager.getInstance(excelsheetdata.get("Browser"),"").getDriver();
             //   driver=webDriver.driverReturn(); // this was step :-1
                driver.get(excelsheetdata.get("URL"));  //Step:-2
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test  Case On "+excelsheetdata.get("Browser")+" Browser");
               // driver.manage().window().fullscreen();
                ExtentTestManager.getInstance(test).getTest().pass("FullScreen has been done");
                new AllTestCasesFunctions().TestCase1(driver,read.getData("Name"),read.getData("EmailAddress")
                        ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
                        ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
                        read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
                        read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"),read.getData("TestDataOutputWorkBook"),read.getData("TestDataOutputSheet"),
                        read.getData("OutputTestCaseName"),read.getData("TestOutputColumn"),read.getData("TestOutColumnPassword"));


            }else{
                throw new SkipException("Skipping the test cases");
            }

        }catch (TestCaseOrFlagNotFoundException | MalformedURLException ex){
            System.out.println(ex.getMessage());
            ExtentTestManager.getInstance(test).getTest().skip(ex.getMessage());
            throw new SkipException("Skipping the test cases");
        }
    }

    @Test()
    public void TestCase2(){
        try{

            TestDataReader read=new TestDataReader();
            excelsheetdata=read.readTestData("Test Case 2: Login User with correct email and password");
            ExtentTestManager.getInstance(test).getTest().assignCategory("Sanity");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Swarup Kshatriya");
            String code = "<root>" +
                    "\n  <Person>" +
                    "\n    <Name>Swarup Kshatriya</Name>" +
                    "\n    <StartDate>2024-07-04</StartDate>" +
                    "\n    <EndDate>2024-07-05</EndDate>" +
                    "\n    <Location>USA</Location>" +
                    "\n  </Person>" +
                    "\n</root>";
            Markup m = MarkupHelper.createCodeBlock(code);
            ExtentTestManager.getInstance(test).getTest().info(m);
          //  startWritingInTestResult(excelsheetdata.get("TestCaseName"));
            if(read.getData("RunMode").equalsIgnoreCase("Y")){
               // DriverInitiatization webDriver=new DriverInitiatization(excelsheetdata.get("Browser"));
                driver=DriverInitializationManager.getInstance(excelsheetdata.get("Browser"),"").getDriver();
               // driver=webDriver.driverReturn();
                driver.get(excelsheetdata.get("URL"));
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On "+excelsheetdata.get("Browser")+" Browser");
               // driver.manage().window().fullscreen();
                ExtentTestManager.getInstance(test).getTest().pass("FullScreen has been done");
                new AllTestCasesFunctions().TestCase2(driver,read.getData("Name"),read.getData("EmailAddress")
                        ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
                        ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
                        read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
                        read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"));

            }else{
                throw new SkipException("Skipping the test cases");
            }
        }catch (TestCaseOrFlagNotFoundException ex){

            System.out.println(ex.getMessage());
            ExtentTestManager.getInstance(test).getTest().skip(ex.getMessage());
            throw new SkipException("Skipping the test cases");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test()
    public void TestCase3(){
        try{

            TestDataReader read=new TestDataReader();
           // startWritingInTestResult("Test Case 3: Login User with incorrect email and password");
            excelsheetdata=read.readTestData("Test Case 3: Login User with incorrect email and password");
            //ExtentReportGenerationManager.getInstance("Test Case 3: Login User with incorrect email and password")
            ExtentTestManager.getInstance(test).getTest().assignCategory("Functional");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            String code = "<root>" +
                    "\n  <Person>" +
                    "\n    <Name>Swarup Kshatriya</Name>" +
                    "\n    <StartDate>2024-07-04</StartDate>" +
                    "\n    <EndDate>2024-07-05</EndDate>" +
                    "\n    <Location>USA</Location>" +
                    "\n  </Person>" +
                    "\n</root>";
            Markup m = MarkupHelper.createCodeBlock(code);
            ExtentTestManager.getInstance(test).getTest().info(m);
           // startWritingInTestResult(excelsheetdata.get("TestCaseName"));
            if(read.getData("RunMode").equalsIgnoreCase("Y")){
              //  DriverInitiatization webDriver=new DriverInitiatization(excelsheetdata.get("Browser"));
                driver=DriverInitializationManager.getInstance(excelsheetdata.get("Browser"),"").getDriver();
               // driver=webDriver.driverReturn();
                driver.get(read.getData("URL"));
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On"+excelsheetdata.get("Browser")+" Browser");
                driver.manage().window().fullscreen();
                ExtentTestManager.getInstance(test).getTest().pass("FullScreen has been done");
                new AllTestCasesFunctions().TestCase3(driver,read.getData("TestDataInputWorkBook"),read.getData("TestDataInputSheet"),read.getData("TestInPutTestCaseName"),read.getData("TestInputColEmail"),read.getData("TestInputColPassword"));

            }else{
                throw new SkipException("Skipping the test cases");
            }
        }catch (Exception ex){//TestCaseOrFlagNotFoundException ex)
            System.out.println(ex.getMessage());
           // test.skip(ex.getMessage());
            throw new SkipException("Skipping the test cases");

        }


    }

    @Test()
    public void TestCase4(){
        try{

            TestDataReader read=new TestDataReader();

            excelsheetdata=read.readTestData("Test Case 4: Logout User");
            ExtentTestManager.getInstance(test).getTest().assignCategory("Sanity");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Swarup Kshatriya");
            String code = "<root>" +
                    "\n  <Person>" +
                    "\n    <Name>Swarup Kshatriya</Name>" +
                    "\n    <StartDate>2024-07-04</StartDate>" +
                    "\n    <EndDate>2024-07-05</EndDate>" +
                    "\n    <Location>USA</Location>" +
                    "\n  </Person>" +
                    "\n</root>";
            Markup m = MarkupHelper.createCodeBlock(code);
            ExtentTestManager.getInstance(test).getTest().info(m);
            // startWritingInTestResult(excelsheetdata.get("TestCaseName"));
            if(read.getData("RunMode").equalsIgnoreCase("Y")){
               // DriverInitiatization webDriver=new DriverInitiatization(excelsheetdata.get("Browser"));
                driver=DriverInitializationManager.getInstance(excelsheetdata.get("Browser"),"").getDriver();
               // driver=webDriver.driverReturn();
                driver.get(excelsheetdata.get("URL"));
                ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On "+excelsheetdata.get("Browser")+" Browser");
                //driver.manage().window().fullscreen();
                ExtentTestManager.getInstance(test).getTest().pass("FullScreen has been done");
                new AllTestCasesFunctions().TestCase4(driver,read.getData("Name"),read.getData("EmailAddress")
                        ,read.getData("Title"),read.getData("Password"),read.getData("Day"),read.getData("Month")
                        ,read.getData("Year"),read.getData("FirstName"),read.getData("LastName"),read.getData("Company"),
                        read.getData("Address1"),read.getData("Address2"),read.getData("Country"),read.getData("State"),
                        read.getData("City"),read.getData("Zipcode"),read.getData("MobileNumber"));

            }else{
                throw new SkipException("Skipping the test cases");
            }
        }catch (TestCaseOrFlagNotFoundException ex){

            System.out.println(ex.getMessage());
            ExtentTestManager.getInstance(test).getTest().skip(ex.getMessage());
            throw new SkipException("Skipping the test cases");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }


    @AfterMethod()
    public void tearDown(ITestResult result){

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


            case 3:
                if(ExtentTestManager.getInstance(test).getTest()!=null){
                    ExtentTestManager.getInstance(test).getTest().skip("Skip the Test Case as Flag is set as N");
                }
                break;



        }
        if(driver!=null){
            if(ExtentTestManager.getInstance(test).getTest()!=null){
                ExtentTestManager.getInstance(test).getTest().info("Browser is closed");
                ExtentTestManager.remoteAttachment();
            }
            driver.quit();
            DriverInitializationManager.remoteAttachment();
        }

    }
}
