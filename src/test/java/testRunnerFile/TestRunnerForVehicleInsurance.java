package testRunnerFile;

import TestCaseFunctionality.AllTestCasesFunctions;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import driverinitialization.*;
import extentreport.ExtentReportsManager;
import extentreport.ExtentTestManager;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import scriptRecording.ScreenRecorderUtil;
import testdatareader.TestDataReader;
import userdefinedExceptions.CheckboxOptionIsNotAvailable;
import userdefinedExceptions.RadioButtonOptionIsNotAvailable;
import userdefinedExceptions.TestCaseOrFlagNotFoundException;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class TestRunnerForVehicleInsurance extends ExtentReportGenerationClass{

    WebDriver driver;
    RemoteWebDriver remoteWebDriver;
    Map<String,String> excelsheetdata;

    @DataProvider(name="ObjectDataProvider")
    public Object[][] getDataObjectDataProvider(Method method) throws TestCaseOrFlagNotFoundException, IOException {
        Object[][] arrayobject=null;
        TestDataReader reader1=new TestDataReader();
        switch (method.getName()){
            case "TestCase1_ObjectData":
                    arrayobject=reader1.getDataProviderData("Automobile");
                    break;
            case "TestCaseTruck_ObjectData":
                    arrayobject=reader1.getDataProviderData("Truck");
                    break;
            case "TestCaseMotorCycle_ObjectData":
                    arrayobject=reader1.getDataProviderData("Motorcycle");
                    break;
            case "TestCaseCamper_ObjectData":
                    arrayobject=reader1.getDataProviderData("Camper");
                break;

            default:
        }
        return  arrayobject;
    }

    @DataProvider(name="IteratorDataProvider")
    public Iterator<Object[]> getDataIterator(Method method) throws TestCaseOrFlagNotFoundException, IOException {
        Iterator<Object[]> arrayobject=null;
        TestDataReader reader1=new TestDataReader();
        switch (method.getName()){
            case "TestCase1_Iterator":
                arrayobject=reader1.getDataProviderAsIterator("Automobile");
                break;
            case "TestCase2":
                arrayobject=reader1.getDataProviderAsIterator("Truck");
                break;
            case "TestCase3":
                arrayobject=reader1.getDataProviderAsIterator("Motorcycle");
                break;
            case "TestCase4":
                arrayobject=reader1.getDataProviderAsIterator("Camper");
                break;

            default:
                arrayobject=null;
        }
        return  arrayobject;
    }


 //   @Test(dataProvider = "ObjectDataProvider")
    public void TestCase1_ObjectData(String strMake,String strEngPer,String strDateOfMfg,String strNoOfSeats,String strFuelType,String strListPrice, String strLicensePlate,String strAnnualMileage,
                                     String strFirstname,String strLastName,String strDateOfBirth,
                                     String strGender,String strStreetAddress,String strCountry,String strZipCode,
                                     String strCity,String strOccupation,String strHobbies,String strWebSite,
                                     String strFileName,String strInsuranceSum,String strMeritRating,String strDamageInsurance,String strOptionalProduct,
                                     String strCourtesyCar,String strPriceOption,String strEmail,String strPhone,String strUsername,String strPassword,
                                     String strConfirmPassword,String strComments,ITestContext context) {
        TestDataReader read=new TestDataReader();
//        String browser=context.getCurrentXmlTest().getParameter("browser");
       String executionMode=context.getCurrentXmlTest().getParameter("execution");
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
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Rameshchandra Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Chrome","remote");
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.manage().deleteAllCookies();
            driver.get("chrome://settings/clearBrowserData");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            try {
//                ScreenRecorderUtil.startRecord("Test Case 1 Automobile");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
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
//         new AllTestCasesFunctions().TestAutomobile1(ThreadLocalDriver.getInstance().getDriver(),read.getData("Make"),read.getData("EnginePerformance"),read.getData("DateOFManufacturing"),read.getData("NumberofSeats"),read.getData("FuelType"),read.getData("ListPrice"),read.getData("LicensePlateNumber"),read.getData("AnualMilege"));
            try {
                new AllTestCasesFunctions().TestAutomobile1(ThreadLocalDriver.getInstance().getDriver(),strMake,strEngPer,
                        strDateOfMfg,strNoOfSeats,strFuelType,strListPrice,strLicensePlate,strAnnualMileage,strFirstname,strLastName,strDateOfBirth,
                        strGender,strStreetAddress,strCountry,strZipCode,strCity,strOccupation,strHobbies,strWebSite,strFileName,strInsuranceSum,strMeritRating,
                        strDamageInsurance,strOptionalProduct,strCourtesyCar,strPriceOption,strEmail,strPhone,strUsername,strPassword,strConfirmPassword,strComments);
            } catch (CheckboxOptionIsNotAvailable |RadioButtonOptionIsNotAvailable e) {
                throw new RuntimeException(e);
            }
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }


    }

  //  @Test(dataProvider = "ObjectDataProvider")
    public void TestCaseTruck_ObjectData(String strMake,String strEngPer,String strDateOfMfg,String strNoOfSeats,String strFuelType,String strPayLoad,String strTotalWeight,String strListPrice, String strLicensePlate,String strAnnualMileage,
                                     String strFirstname,String strLastName,String strDateOfBirth,
                                     String strGender,String strStreetAddress,String strCountry,String strZipCode,
                                     String strCity,String strOccupation,String strHobbies,String strWebSite,
                                     String strFileName,String strInsuranceSum,String strDamageInsurance,String strOptionalProduct,
                                     String strPriceOption,String strEmail,String strPhone,String strUsername,String strPassword,
                                     String strConfirmPassword,String strComments,ITestContext context) {
        TestDataReader read=new TestDataReader();
        String executionMode=context.getCurrentXmlTest().getParameter("execution");
        startWritingInTestResult("Test Case 2: Truck");
        try {
            excelsheetdata=read.readTestData("Test Case 2: Truck");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Rameshchandra Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Chrome",executionMode);
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            try {
//                ScreenRecorderUtil.startRecord("Test Case 2 Truck");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            driver.get(excelsheetdata.get("URL"));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
            try {
                new AllTestCasesFunctions().TestTruck(ThreadLocalDriver.getInstance().getDriver(),strMake,strEngPer,
                        strDateOfMfg,strNoOfSeats,strFuelType,strPayLoad,strTotalWeight,strListPrice,strLicensePlate,strAnnualMileage,strFirstname,strLastName,strDateOfBirth,
                        strGender,strStreetAddress,strCountry,strZipCode,strCity,strOccupation,strHobbies,strWebSite,strFileName,strInsuranceSum,
                        strDamageInsurance,strOptionalProduct,strPriceOption,strEmail,strPhone,strUsername,strPassword,strConfirmPassword,strComments);
            } catch (CheckboxOptionIsNotAvailable |RadioButtonOptionIsNotAvailable e) {
                throw new RuntimeException(e);
            }
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }


    }

 //   @Test(dataProvider = "ObjectDataProvider")
    public void TestCaseMotorCycle_ObjectData(String strMake,String strModel,String strCylinderCapacity,String strEngPer,String strDateOfMfg,String strNoOfSeats,String strListPrice,String strAnnualMileage,
                                         String strFirstname,String strLastName,String strDateOfBirth,
                                         String strGender,String strStreetAddress,String strCountry,String strZipCode,
                                         String strCity,String strOccupation,String strHobbies,String strWebSite,
                                         String strFileName,String strInsuranceSum,String strDamageInsurance,String strOptionalProduct,
                                         String strPriceOption,String strEmail,String strPhone,String strUsername,String strPassword,
                                         String strConfirmPassword,String strComments,ITestContext context) {
        TestDataReader read=new TestDataReader();
       // String executionMode=context.getCurrentXmlTest().getParameter("execution");
        startWritingInTestResult("Test Case 3: MotorCycle");
        try {
            excelsheetdata=read.readTestData("Test Case 3: MotorCycle");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Rameshchandra Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Edge","Local");
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            try {
//                ScreenRecorderUtil.startRecord("Test Case 3 MotorCycle");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            driver.get(excelsheetdata.get("URL"));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
            try {
                new AllTestCasesFunctions().TestMotorCycle(ThreadLocalDriver.getInstance().getDriver(),strMake,strModel,strCylinderCapacity,strEngPer,
                        strDateOfMfg,strNoOfSeats,strListPrice,strAnnualMileage,strFirstname,strLastName,strDateOfBirth,
                        strGender,strStreetAddress,strCountry,strZipCode,strCity,strOccupation,strHobbies,strWebSite,strFileName,strInsuranceSum,
                        strDamageInsurance,strOptionalProduct,strPriceOption,strEmail,strPhone,strUsername,strPassword,strConfirmPassword,strComments);
            } catch (CheckboxOptionIsNotAvailable |RadioButtonOptionIsNotAvailable e) {
                throw new RuntimeException(e);
            }
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }


    }

  //  @Test(dataProvider = "ObjectDataProvider")
    public void TestCaseCamper_ObjectData(String strMake,String strEngPer,String strDateOfMfg,String strNoOfSeats,String strRightHandDrive,String strFuelType,String strPayLoad,String strTotalWeight,String strListPrice, String strLicensePlate,String strAnnualMileage,
                                         String strFirstname,String strLastName,String strDateOfBirth,
                                         String strGender,String strStreetAddress,String strCountry,String strZipCode,
                                         String strCity,String strOccupation,String strHobbies,String strWebSite,
                                         String strFileName,String strInsuranceSum,String strDamageInsurance,String strOptionalProduct,
                                         String strPriceOption,String strEmail,String strPhone,String strUsername,String strPassword,
                                         String strConfirmPassword,String strComments,ITestContext context) {
        TestDataReader read=new TestDataReader();
        String executionMode=context.getCurrentXmlTest().getParameter("execution");
        startWritingInTestResult("Test Case 4: Camper");
        try {
            excelsheetdata=read.readTestData("Test Case 4: Camper");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Rameshchandra Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("FireFox","Remote");
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            try {
//                ScreenRecorderUtil.startRecord("Test Case 4 Camper");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            driver.get(excelsheetdata.get("URL"));
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,excelsheetdata.get("URL"));
            try {
                new AllTestCasesFunctions().TestCamper(ThreadLocalDriver.getInstance().getDriver(),strMake,strEngPer,
                        strDateOfMfg,strNoOfSeats,strRightHandDrive,strFuelType,strPayLoad,strTotalWeight,strListPrice,strLicensePlate,strAnnualMileage,strFirstname,strLastName,strDateOfBirth,
                        strGender,strStreetAddress,strCountry,strZipCode,strCity,strOccupation,strHobbies,strWebSite,strFileName,strInsuranceSum,
                        strDamageInsurance,strOptionalProduct,strPriceOption,strEmail,strPhone,strUsername,strPassword,strConfirmPassword,strComments);
            } catch (CheckboxOptionIsNotAvailable |RadioButtonOptionIsNotAvailable e) {
                throw new RuntimeException(e);
            }
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }


    }





 //   @Test(dataProvider = "IteratorDataProvider")
    public void TestCase1_Iterator(Map<String,Object> data,ITestContext context)  {

        TestDataReader read=new TestDataReader();
//        String browser=context.getCurrentXmlTest().getParameter("browser");
       String executionMode=context.getCurrentXmlTest().getParameter("execution");
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
                ThreadLocalDriver.getInstance().setDriver("Chrome",executionMode);
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            driver.manage().deleteAllCookies();
            try {
                Thread.sleep(7000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            try {
//                ScreenRecorderUtil.startRecord("Test Case 1 Automobile");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
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
//         new AllTestCasesFunctions().TestAutomobile1(ThreadLocalDriver.getInstance().getDriver(),read.getData("Make"),read.getData("EnginePerformance"),read.getData("DateOFManufacturing"),read.getData("NumberofSeats"),read.getData("FuelType"),read.getData("ListPrice"),read.getData("LicensePlateNumber"),read.getData("AnualMilege"));
            try {
                new AllTestCasesFunctions().TestAutomobile1(ThreadLocalDriver.getInstance().getDriver(),data.get("Make").toString(),data.get("Engine Performance").toString(),data.get("Date Of Manufacture").toString(),data.get("Number of Seats").toString(),data.get("Fuel Type").toString(),data.get("List Price").toString(),data.get("License Plate Number").toString(),data.get("Annual Milege").toString(),
                        data.get("FirstName").toString(),data.get("LastName").toString(),data.get("DateOfBirth").toString(),data.get("Gender").toString(),data.get("StreetAddress").toString(),data.get("Country").toString(),data.get("Zipcode").toString(),data.get("City").toString(),data.get("Occupation").toString(),data.get("Hobbies").toString(),data.get("Website").toString(),data.get("FilePath").toString(),
                        data.get("InsuranceSum").toString(),data.get("MeritRating").toString(),data.get("DamageInsurance").toString(),data.get("OptionalProduct").toString(),data.get("CourtesyCar").toString(),data.get("PriceOption").toString(),data.get("Email").toString(),data.get("phone").toString(),data.get("Username").toString(),data.get("Password").toString(),data.get("ConfirmPassword").toString(),data.get("Comments").toString());
            } catch (CheckboxOptionIsNotAvailable | RadioButtonOptionIsNotAvailable e) {
                throw new RuntimeException(e);
            }
        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }


    }

    @Test()
    public void TestCase2(ITestContext context){

        TestDataReader read=new TestDataReader();
        String browser=context.getCurrentXmlTest().getParameter("browser");
        String executionMode=context.getCurrentXmlTest().getParameter("execution");
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
                ThreadLocalDriver.getInstance().setDriver("Edge","Local");
                driver= ThreadLocalDriver.getInstance().getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
//            try {
//                ScreenRecorderUtil.startRecord("Test Case 2 Truck");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
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

    @Test(/*dependsOnMethods = "TestCase1"*/)
    public void TestCase3(ITestContext context){
        TestDataReader read=new TestDataReader();
        String browser=context.getCurrentXmlTest().getParameter("browser");
        String executionMode=context.getCurrentXmlTest().getParameter("execution");
        //excelsheetdata=read.readTestData("Test Case 1: Register User");
        startWritingInTestResult("Test Case 3: MotorCycle");
        try {
            excelsheetdata=read.readTestData("Test Case 3: MotorCycle");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("FireFox","Local");
                driver= ThreadLocalDriver.getInstance().getDriver();
               // driver=DriverInitializationManager.getInstance("FireFox","Local").getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

//            try {
//                ScreenRecorderUtil.startRecord("Test Case 3 MotorCycle");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            driver.get(excelsheetdata.get("URL"));
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
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
        String executionMode=context.getCurrentXmlTest().getParameter("execution");
        //excelsheetdata=read.readTestData("Test Case 1: Register User");
        startWritingInTestResult("Test Case 4: Camper");
        try {
            excelsheetdata=read.readTestData("Test Case 4: Camper");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Chrome","Local");
                driver= ThreadLocalDriver.getInstance().getDriver();
//                driver=DriverInitializationManager.getInstance("Chrome","Local").getDriver();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

//            try {
//                ScreenRecorderUtil.startRecord("Test Case 4 Camper");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            driver.get(excelsheetdata.get("URL"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
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

    @Test(/*dependsOnMethods = "TestCase1"*/)
    public void TestCaseBrowserClearCache(ITestContext context){
        TestDataReader read=new TestDataReader();
        String browser=context.getCurrentXmlTest().getParameter("browser");
        String executionMode=context.getCurrentXmlTest().getParameter("execution");
        //excelsheetdata=read.readTestData("Test Case 1: Register User");
        startWritingInTestResult("Test Case 5: MotorCycle");
        try {
            excelsheetdata=read.readTestData("Test Case 5: MotorCycle");
        } catch (TestCaseOrFlagNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (excelsheetdata.get("RunMode").equalsIgnoreCase("Y")){

            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            ExtentTestManager.getInstance(test).getTest().assignCategory("Regression");
            ExtentTestManager.getInstance(test).getTest().assignAuthor("Ramesh Kshatriya");
            try {
                ThreadLocalDriver.getInstance().setDriver("Edge","Local");
                driver= ThreadLocalDriver.getInstance().getDriver();
                // driver=DriverInitializationManager.getInstance("FireFox","Local").getDriver();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }






          //  button = get_shadow_root(shadow_host).find_element(By.CSS_SELECTOR, '[data-test=handle-accept-all-button]')



//            try {
//                ScreenRecorderUtil.startRecord("Test Case 3 MotorCycle");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//            driver.get("chrome://settings/clearBrowserData");
////            JavascriptExecutor jse = (JavascriptExecutor)driver;
////            WebElement clearData =  (WebElement) jse.executeScript("return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#main\").shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > settings-section:nth-child(8) > settings-privacy-page\").shadowRoot.querySelector(\"settings-clear-browsing-data-dialog\").shadowRoot.querySelector(\"#clearBrowsingDataConfirm\")");
////            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", clearData);
//           driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);





            driver.get("chrome://settings/clearBrowserData");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



            JavascriptExecutor js= (JavascriptExecutor) driver;
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('settings-ui').shadowRoot.querySelector('settings-main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('settings-section > settings-privacy-page').shadowRoot.querySelector('settings-clear-browsing-data-dialog').shadowRoot.querySelector('#clearBrowsingDataDialog').querySelector('#clearBrowsingDataConfirm')"))).click();
          //  WebElement element=(WebElement) js.executeScript("return document.querySelector('settings-ui').shadowRoot.querySelector('#main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('settings-section').shadowRoot.querySelector('settings-privacy-page').shadowRoot.querySelector('settings-clear-browsing-data-dialog').shadowRoot.querySelector('#clearBrowsingDataDialog').shadowRoot.querySelector('#clearButton')");
          //  element.click();


            // Locate shadowHost on the current dom
            WebElement shadowHostL1 = driver.findElement(By.cssSelector("settings-ui"));

// now locate the shadowElement by traversing all shadow levels
            WebElement shadowElementL1 = getShadowElement(driver, shadowHostL1, "#main");
            WebElement shadowElementL2 = getShadowElement(driver, shadowElementL1,"settings-basic-page");
            WebElement shadowElementL3 = getShadowElement(driver, shadowElementL2,"settings-section > settings-privacy-page");
            WebElement shadowElementL4 = getShadowElement(driver, shadowElementL3,"settings-clear-browsing-data-dialog");
            WebElement shadowElementL5 = getShadowElement(driver, shadowElementL4,"#clearBrowsingDataDialog");
            WebElement clearData = shadowElementL5.findElement(By.cssSelector("#clearBrowsingDataConfirm"));
            System.out.println(clearData.getText());
            clearData.click();
           // js.executeScript("arguments[0].click();",element);

//            js.executeScript("return arguments[0].shadowRoot",driver.findElement(By.tagName("settings-ui")).getShadowRoot().findElement(By.cssSelector(".clearButton")));
//           Actions actions=new Actions(driver);
//            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.SHIFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();


//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
//            actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }



            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.manage().deleteAllCookies();
            driver.get(excelsheetdata.get("URL"));

            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            driver.get("chrome://settings/clearBrowserData");
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            //  driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,"Starting test Case On Chrome Browser");
            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf(Thread.currentThread().getId()));
            new AllTestCasesFunctions().TestAutomobile3(driver,read.getData("Make"),read.getData("EnginePerformance"),read.getData("DateOFManufacturing"),read.getData("NumberofSeats"),read.getData("FuelType"),read.getData("ListPrice"),read.getData("LicensePlateNumber"),read.getData("AnualMilege"));

        }else{
            ExtentTestManager.getInstance(test).getTest().skip("Skipping Test Cases");
            throw new SkipException("Skipping the test cases");
        }



    }

    public static WebElement getShadowElement(WebDriver driver,WebElement shadowHost, String cssOfShadowElement) {
        WebElement shardowRoot = getShadowRoot(driver, shadowHost);
        return shardowRoot.findElement(By.cssSelector(cssOfShadowElement));
    }

    private static WebElement getShadowRoot(WebDriver driver,WebElement shadowHost) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
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
                        ExtentTestManager.remoteAttachment();
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
