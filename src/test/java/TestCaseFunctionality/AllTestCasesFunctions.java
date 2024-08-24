package TestCaseFunctionality;

import AutomationExcercise.*;
import OrangeHRM.OrangeHRMDashBoardPage;
import OrangeHRM.OrangeHRMLoginPage;
import VehicalInsuranceApplication.AutomobileClass;
import VehicalInsuranceApplication.Camper;
import VehicalInsuranceApplication.MotorCycle;
import VehicalInsuranceApplication.Truck;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import commonLibrarymethods.CommonResuableMethods;
import extentreport.ExtentTestManager;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import testRunnerFile.ExtentReportGenerationClass;
import testdatareader.TestDataReader;
import userdefinedExceptions.CheckboxOptionIsNotAvailable;
import userdefinedExceptions.DataIsNotVisible;
import userdefinedExceptions.RadioButtonOptionIsNotAvailable;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AllTestCasesFunctions extends ExtentReportGenerationClass {
    AutomobileClass auto=new AutomobileClass();
    Truck truck=new Truck();
    MotorCycle motorCycle=new MotorCycle();
    Camper camper=new Camper();

    HomePage hp=new HomePage();
    LoginPage lp=new LoginPage();
    SignUpPage sp=new SignUpPage();
    AccountCreatePage acp=new AccountCreatePage();
    AccountDeletedPage adp=new AccountDeletedPage();
    CommonResuableMethods com=new CommonResuableMethods();
    OrangeHRMLoginPage olp= new OrangeHRMLoginPage();
    OrangeHRMDashBoardPage odp=new OrangeHRMDashBoardPage();
    public void TestOranageHRM1(WebDriver driver,String strUserName,String strUserPassword ){
        com.clickElement(driver,olp.getUserNameTextField(),"Login Button");
        com.type(driver,olp.getUserNameTextField(),"Username",strUserName);
        com.clickElement(driver,olp.getUserPasswordTextField(),"Login Button");
        com.type(driver,olp.getUserPasswordTextField(),"Password",strUserPassword);
        com.clickElement(driver,olp.getLoginButton(),"Login Button");
        com.clickElement(driver,odp.getAdminTab(),"Admin link");
        com.clickElement(driver,odp.getProfilePic(),"MandaUser link");
        com.clickElement(driver,odp.getLogoutLink(),"Logout link");
    }

    public void TestOranageHRM2(WebDriver driver,String strUserName,String strUserPassword ){
        com.clickElement(driver,olp.getUserNameTextField(),"Login Button");
        com.type(driver,olp.getUserNameTextField(),"Username",strUserName);
        com.clickElement(driver,olp.getUserPasswordTextField(),"Login Button");
        com.type(driver,olp.getUserPasswordTextField(),"Password",strUserPassword);
        com.clickElement(driver,olp.getLoginButton(),"Login Button");
        com.clickElement(driver,odp.getAdminTab(),"Admin link");
        com.clickElement(driver,odp.getProfilePic(),"MandaUser link");
        com.clickElement(driver,odp.getLogoutLink(),"Logout link");
    }

    public void TestOranageHRM3(WebDriver driver,String strUserName,String strUserPassword ){
        com.clickElement(driver,olp.getUserNameTextField(),"Login Button");
        com.type(driver,olp.getUserNameTextField(),"Username",strUserName);
        com.clickElement(driver,olp.getUserPasswordTextField(),"Login Button");
        com.type(driver,olp.getUserPasswordTextField(),"Password",strUserPassword);
        com.clickElement(driver,olp.getLoginButton(),"Login Button");
        com.clickElement(driver,odp.getAdminTab(),"Admin link");
        com.clickElement(driver,odp.getProfilePic(),"MandaUser link");
        com.clickElement(driver,odp.getLogoutLink(),"Logout link");
    }

    public void TestAutomobile1(WebDriver driver,String strMake,String strEngPer,String strDOM,
                                String strNoSeats,String strFuelType,String strListPrice,String strLicensePlate,
                                String strAnualMilege,String strFirstname,String strLastName,String strDateOfBirth,
                                String strGender,String strStreetAddress,String strCountry,String strZipCode,
                                String strCity,String strOccupation,String strHobbies,String strWebSite,
                                String strFileName,String strInsuranceSum,String strMeritRating,String strDamageInsurance,String strOptionalProduct,
                                String strCourtesyCar,String strPriceOption,String strEmail,String strPhone,String strUsername,String strPassword,
                                String strConfirmPassword,String strComments) throws CheckboxOptionIsNotAvailable, RadioButtonOptionIsNotAvailable {


        com.clickElement(driver,auto.getAutomobileLink(),"automobileLink");
        com.clickElement(driver,auto.getMakeComBoBox(),"makeCombo");
        try {
            com.selectByText(driver,auto.getMakeComBoBox(),"combo",strMake);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,auto.getEnginePerformanceKW(),"EnginePEr",strEngPer);
        com.type(driver,auto.getDateOfManufacturing(),"dateofmanu",strDOM);

        com.clickElement(driver,auto.getSelectNumberOfSeats(),"seat");
        try {
            com.selectByText(driver,auto.getSelectNumberOfSeats(),"combo",strNoSeats);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.clickElement(driver,auto.getFuelType(),"Fuel Type");
        try {
            com.selectByText(driver,auto.getFuelType(),"combo",strFuelType);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.type(driver,auto.getListPrice(),"listprice",strListPrice);
        com.type(driver,auto.getLicensePlateNumber(),"licenseplatenumber",strLicensePlate);
        com.type(driver,auto.getAnualMilege(),"Anual Milenge",strAnualMilege);
        com.clickElement(driver,auto.getNextButton(),"Next Button");
        com.type(driver,auto.getFirstNameTextField(),"FirstName",strFirstname);
        com.type(driver,auto.getLastNameTextField(),"LastName",strLastName);
        com.type(driver,auto.getDateOfBirthTextField(),"Date Of Birth",strDateOfBirth);
        if(strGender.equalsIgnoreCase("Male")){
            com.clickElement(driver,auto.getGenderMaleRadioButton(),"Gender Male radio Button");
        }else{
            com.clickElement(driver,auto.getGenFemaleRadioButton(),"Gender Female radio Button");
        }
        com.type(driver,auto.getStressAddressTextField(),"Street Address",strStreetAddress);
        com.clickElement(driver,auto.getCountrySelectDropDown(),"Country DropDown box");
        try {
            com.selectByText(driver,auto.getCountrySelectDropDown(),"County DropDown Box",strCountry);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,auto.getZipCode(),"Zip Code",strZipCode);
        com.type(driver,auto.getCityTextField(),"City",strCity);
        com.clickElement(driver,auto.getOccupationDropDown(),"Occupation DropDown box");
        try {
            com.selectByText(driver,auto.getOccupationDropDown(),"Occupation DropDown Box",strOccupation);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        switch (strHobbies.toLowerCase()){
            case "speeding":
                com.clickElement(driver,auto.getSpeeadingCheckBox(),"Speeding check Box");
                break;
            case "bungee jumping":
                com.clickElement(driver,auto.getBungeeJumpingCheckBox(),"bungee jumping check Box");
                break;
            case "cliff driving":
                com.clickElement(driver,auto.getCliffDivingCheckBox(),"Cliff Diving check Box");
                break;
            case "skydiving":
                com.clickElement(driver,auto.getSkydivingCheckBox(),"sky Diving  Box");
                break;
            case "other":
                com.clickElement(driver,auto.getOtherCheckBox(),"other check Box");
                break;
            default:
                    throw new CheckboxOptionIsNotAvailable("Hobbies value you provided is not available in application");
        }
        com.type(driver,auto.getWebSiteTextfield(),"WebSite",strWebSite);
//        com.clickElement(driver,auto.getOpenButton(),"Open Button");
//        File uploadFile = new File(System.getProperty("user.dir")+"/FileUpload/"+strFileName);
//        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
//        fileInput.sendKeys(uploadFile.getAbsolutePath());
//        driver.findElement(By.id("file-submit")).click();
//
//        WebElement fileName = driver.findElement(By.id("uploaded-files"));
//        Assertions.assertEquals("selenium-snapshot.png", fileName.getText());

        com.clickElement(driver,auto.getNextbuttonProductData(),"Next Button");
        Date date=new Date();

        SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");

        date= DateUtils.addDays(date,50);
       String advancedDate= dateFormat.format(date);
       com.type(driver,auto.getProductdataStartDate(),"Start Date",advancedDate);

       com.clickElement(driver,auto.getProductDataInsuranceSumDropDown(),"InsuranceSum DropDown ");
       try {
           com.selectByText(driver,auto.getProductDataInsuranceSumDropDown(),"InsuranceSum DropDown",strInsuranceSum);
       }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
       }

        com.clickElement(driver,auto.getProductDataMeritRating(),"Merit Rating DropDown ");
        try {
            com.selectByText(driver,auto.getProductDataMeritRating(),"Merit Rating DropDown DropDown",strMeritRating);
        }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.clickElement(driver,auto.getProductDataDamageInsurance(),"DamageInsurance DropDown ");
        try {
            com.selectByText(driver,auto.getProductDataDamageInsurance(),"DamageInsurance DropDown",strDamageInsurance);
        }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        switch (strOptionalProduct.toLowerCase()){
            case "euro protection":
                com.clickElement(driver,auto.getProductDataOptionalProudctsEuroProtectionCheckBox(),"Euro Protection check Box");
                break;
            case "legal defense insurance":
                com.clickElement(driver,auto.getProductDataLegalDefenseInsuranceCheckBox(),"legal defense Insurance check Box");
                break;

            default:
                throw new CheckboxOptionIsNotAvailable("Optional Product value you provided is not available in application");
        }

        com.clickElement(driver,auto.getProductDataCurtesyCarDropDown(),"CurtsyCar DropDown ");
        try {
            com.selectByText(driver,auto.getProductDataCurtesyCarDropDown(),"CurtsyCar DropDown",strCourtesyCar);
        }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.javascriptExecutorMethod(driver,auto.getProductDataNextSelectPriceOptionButton(),"Next button");
        com.clickElement(driver,auto.getProductDataNextSelectPriceOptionButton(),"Next Button ");

        switch (strPriceOption.toLowerCase()){
            case "silver":
                com.clickElement(driver,auto.getSelectPriceOptionSilverRadioButton(),"silver radio button ");
                break;
            case "gold":
                com.clickElement(driver,auto.getSelectPriceOptionGoldRadioButton(),"Gold Radio button ");
                break;
            case "platinum":
                com.clickElement(driver,auto.getSelectPriceOptionPlatinumRadioButton(),"Platinum Radio Button ");
                break;
            case "ultimate":
                com.clickElement(driver,auto.getSelectPriceOptionUltimateRadioButton(),"ultimate radio button");
                break;
            default:
                throw new RadioButtonOptionIsNotAvailable("Hobbies value you provided is not available in application");
        }
        com.clickElement(driver,auto.getSelectPriceOptionNextButton(),"Next Button ");
        com.type(driver,auto.getSendQuoteEmailTextField(),"Email ",strEmail);
        com.type(driver,auto.getSendQuotePhoneTextField(),"Phone ",strPhone);
        com.type(driver,auto.getSendQuoteUsernameTextField(),"Username ",strUsername);
        com.type(driver,auto.getSendQuotePasswordTextField(),"Password  ",strPassword);
        com.type(driver,auto.getSendQuoteConfirmPasswordTextField(),"Confirm Password  ",strConfirmPassword);
        com.type(driver,auto.getSendQuoteCommentTextArea(),"Comments  ",strComments);
        com.clickElement(driver,auto.getSendQuoteSendQuoteButton(),"Send Button ");
        if(com.isVisibleOnPage(driver,auto.getSendingEmailNotification())){
            String emailNotificationMessage=driver.findElement(auto.getSendingEmailNotification()).getText();
            if(emailNotificationMessage.equalsIgnoreCase("Sending e-mail success!")){
                com.clickElement(driver,auto.getOkButton(),"OK Button ");
                Assert.assertTrue(true,"Sending e-mail success!");
                ExtentTestManager.getInstance(test).getTest().log(Status.PASS,String.valueOf(" Pop up Message is "+emailNotificationMessage+" Available "));
            }else {
                ExtentTestManager.getInstance(test).getTest().log(Status.FAIL,String.valueOf(" Pop up Message is "+emailNotificationMessage+" Not Available "));
                Assert.fail("Sending e-mail success! is not available ");
            }
        }



    }
    public void TestTruck(WebDriver driver,String strMake,String strEngPer,String strDOM,
                                String strNoSeats,String strFuelType,String strPaylaod,String strTotalWeight,String strListPrice,String strLicensePlate,
                                String strAnualMilege,String strFirstname,String strLastName,String strDateOfBirth,
                                String strGender,String strStreetAddress,String strCountry,String strZipCode,
                                String strCity,String strOccupation,String strHobbies,String strWebSite,
                                String strFileName,String strInsuranceSum,String strDamageInsurance,String strOptionalProduct,
                                String strPriceOption,String strEmail,String strPhone,String strUsername,String strPassword,
                                String strConfirmPassword,String strComments) throws CheckboxOptionIsNotAvailable, RadioButtonOptionIsNotAvailable {


        com.clickElement(driver,truck.getTruckLink(),"truck Link");
        com.clickElement(driver,truck.getMakeComBoBox(),"makeCombo");
        try {
            com.selectByText(driver,truck.getMakeComBoBox(),"combo",strMake);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,truck.getEnginePerformanceKW(),"EnginePEr",strEngPer);
        com.type(driver,truck.getDateOfManufacturing(),"dateofmanu",strDOM);

        com.clickElement(driver,truck.getSelectNumberOfSeats(),"seat");
        try {
            com.selectByText(driver,truck.getSelectNumberOfSeats(),"combo",strNoSeats);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.clickElement(driver,truck.getFuelType(),"Fuel Type");
        try {
            com.selectByText(driver,truck.getFuelType(),"combo",strFuelType);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,truck.getPayLoad(),"Pay Load ",strPaylaod);
        com.type(driver,truck.getTotalWeight(),"Total Weight ",strTotalWeight);

        com.type(driver,truck.getListPrice(),"listprice",strListPrice);
        com.type(driver,truck.getLicensePlateNumber(),"licenseplatenumber",strLicensePlate);
        com.type(driver,truck.getAnualMilege(),"Anual Milenge",strAnualMilege);
        com.clickElement(driver,truck.getNextButton(),"Next Button");
        com.type(driver,truck.getFirstNameTextField(),"FirstName",strFirstname);
        com.type(driver,truck.getLastNameTextField(),"LastName",strLastName);
        com.type(driver,truck.getDateOfBirthTextField(),"Date Of Birth",strDateOfBirth);
        if(strGender.equalsIgnoreCase("Male")){
            com.clickElement(driver,truck.getGenderMaleRadioButton(),"Gender Male radio Button");
        }else{
            com.clickElement(driver,truck.getGenFemaleRadioButton(),"Gender Female radio Button");
        }
        com.type(driver,truck.getStressAddressTextField(),"Street Address",strStreetAddress);
        com.clickElement(driver,truck.getCountrySelectDropDown(),"Country DropDown box");
        try {
            com.selectByText(driver,truck.getCountrySelectDropDown(),"County DropDown Box",strCountry);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,truck.getZipCode(),"Zip Code",strZipCode);
        com.type(driver,truck.getCityTextField(),"City",strCity);
        com.clickElement(driver,truck.getOccupationDropDown(),"Occupation DropDown box");
        try {
            com.selectByText(driver,truck.getOccupationDropDown(),"Occupation DropDown Box",strOccupation);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        switch (strHobbies.toLowerCase()){
            case "speeding":
                com.clickElement(driver,truck.getSpeeadingCheckBox(),"Speeding check Box");
                break;
            case "bungee jumping":
                com.clickElement(driver,truck.getBungeeJumpingCheckBox(),"bungee jumping check Box");
                break;
            case "cliff driving":
                com.clickElement(driver,truck.getCliffDivingCheckBox(),"Cliff Diving check Box");
                break;
            case "skydiving":
                com.clickElement(driver,truck.getSkydivingCheckBox(),"sky Diving  Box");
                break;
            case "other":
                com.clickElement(driver,truck.getOtherCheckBox(),"other check Box");
                break;
            default:
                throw new CheckboxOptionIsNotAvailable("Hobbies value you provided is not available in application");
        }
        com.type(driver,truck.getWebSiteTextfield(),"WebSite",strWebSite);
//        com.clickElement(driver,auto.getOpenButton(),"Open Button");
//        File uploadFile = new File(System.getProperty("user.dir")+"/FileUpload/"+strFileName);
//        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
//        fileInput.sendKeys(uploadFile.getAbsolutePath());
//        driver.findElement(By.id("file-submit")).click();
//
//        WebElement fileName = driver.findElement(By.id("uploaded-files"));
//        Assertions.assertEquals("selenium-snapshot.png", fileName.getText());

        com.clickElement(driver,truck.getNextbuttonProductData(),"Next Button");
        Date date=new Date();

        SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");

        date= DateUtils.addDays(date,50);
        String advancedDate= dateFormat.format(date);
        com.type(driver,truck.getProductdataStartDate(),"Start Date",advancedDate);

        com.clickElement(driver,truck.getProductDataInsuranceSumDropDown(),"InsuranceSum DropDown ");
        try {
            com.selectByText(driver,truck.getProductDataInsuranceSumDropDown(),"InsuranceSum DropDown",strInsuranceSum);
        }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }



        com.clickElement(driver,truck.getProductDataDamageInsurance(),"DamageInsurance DropDown ");
        try {
            com.selectByText(driver,truck.getProductDataDamageInsurance(),"DamageInsurance DropDown",strDamageInsurance);
        }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        switch (strOptionalProduct.toLowerCase()){
            case "euro protection":
                com.clickElement(driver,truck.getProductDataOptionalProudctsEuroProtectionCheckBox(),"Euro Protection check Box");
                break;
            case "legal defense insurance":
                com.clickElement(driver,truck.getProductDataLegalDefenseInsuranceCheckBox(),"legal defense Insurance check Box");
                break;

            default:
                throw new CheckboxOptionIsNotAvailable("Optional Product value you provided is not available in application");
        }


        com.javascriptExecutorMethod(driver,truck.getProductDataNextSelectPriceOptionButton(),"Next button");
        com.clickElement(driver,truck.getProductDataNextSelectPriceOptionButton(),"Next Button ");

        switch (strPriceOption.toLowerCase()){
            case "silver":
                com.clickElement(driver,truck.getSelectPriceOptionSilverRadioButton(),"silver radio button ");
                break;
            case "gold":
                com.clickElement(driver,truck.getSelectPriceOptionGoldRadioButton(),"Gold Radio button ");
                break;
            case "platinum":
                com.clickElement(driver,truck.getSelectPriceOptionPlatinumRadioButton(),"Platinum Radio Button ");
                break;
            case "ultimate":
                com.clickElement(driver,truck.getSelectPriceOptionUltimateRadioButton(),"ultimate radio button");
                break;
            default:
                throw new RadioButtonOptionIsNotAvailable("Hobbies value you provided is not available in application");
        }
        com.clickElement(driver,truck.getSelectPriceOptionNextButton(),"Next Button ");
        com.type(driver,truck.getSendQuoteEmailTextField(),"Email ",strEmail);
        com.type(driver,truck.getSendQuotePhoneTextField(),"Phone ",strPhone);
        com.type(driver,truck.getSendQuoteUsernameTextField(),"Username ",strUsername);
        com.type(driver,truck.getSendQuotePasswordTextField(),"Password  ",strPassword);
        com.type(driver,truck.getSendQuoteConfirmPasswordTextField(),"Confirm Password  ",strConfirmPassword);
        com.type(driver,truck.getSendQuoteCommentTextArea(),"Comments  ",strComments);
        com.clickElement(driver,truck.getSendQuoteSendQuoteButton(),"Send Button ");
        if(com.isVisibleOnPage(driver,truck.getSendingEmailNotification())){
            String emailNotificationMessage=driver.findElement(truck.getSendingEmailNotification()).getText();
            if(emailNotificationMessage.equalsIgnoreCase("Sending e-mail success!")){
                com.clickElement(driver,truck.getOkButton(),"OK Button ");
                Assert.assertTrue(true,"Sending e-mail success!");
                ExtentTestManager.getInstance(test).getTest().log(Status.PASS,String.valueOf(" Pop up Message is "+emailNotificationMessage+" Available "));
            }else {
                ExtentTestManager.getInstance(test).getTest().log(Status.FAIL,String.valueOf(" Pop up Message is "+emailNotificationMessage+" Not Available "));
                Assert.fail("Sending e-mail success! is not available ");
            }
        }



    }



    public void TestMotorCycle(WebDriver driver,String strMake,String strModel,String strCylinderCapacity,String strEngPer,String strDOM,
                          String strNoSeats,String strListPrice,
                          String strAnualMilege,String strFirstname,String strLastName,String strDateOfBirth,
                          String strGender,String strStreetAddress,String strCountry,String strZipCode,
                          String strCity,String strOccupation,String strHobbies,String strWebSite,
                          String strFileName,String strInsuranceSum,String strDamageInsurance,String strOptionalProduct,
                          String strPriceOption,String strEmail,String strPhone,String strUsername,String strPassword,
                          String strConfirmPassword,String strComments) throws CheckboxOptionIsNotAvailable, RadioButtonOptionIsNotAvailable {


        com.clickElement(driver,motorCycle.getMotorCycleLink(),"MotorCycle Link");
        com.clickElement(driver,motorCycle.getMakeComBoBox(),"makeCombo");
        try {
            com.selectByText(driver,motorCycle.getMakeComBoBox(),"combo",strMake);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.clickElement(driver,motorCycle.getModel(),"Model Combo ");
        try {
            com.selectByText(driver,motorCycle.getModel(),"Model dropdown ",strModel);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,motorCycle.getCylinderCapacity(),"Cyclinder Capacity ",strCylinderCapacity);
        com.type(driver,motorCycle.getEnginePerformanceKW(),"EnginePEr",strEngPer);
        com.type(driver,motorCycle.getDateOfManufacturing(),"dateofmanu",strDOM);

        com.clickElement(driver,motorCycle.getNumberOfSeatsMotorCycle(),"seat");
        try {
            com.selectByText(driver,motorCycle.getNumberOfSeatsMotorCycle(),"combo",strNoSeats);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.type(driver,motorCycle.getListPrice(),"listprice",strListPrice);

        com.type(driver,motorCycle.getAnualMilege(),"Anual Milenge",strAnualMilege);
        com.clickElement(driver,motorCycle.getNextButton(),"Next Button");
        com.type(driver,motorCycle.getFirstNameTextField(),"FirstName",strFirstname);
        com.type(driver,motorCycle.getLastNameTextField(),"LastName",strLastName);
        com.type(driver,motorCycle.getDateOfBirthTextField(),"Date Of Birth",strDateOfBirth);
        if(strGender.equalsIgnoreCase("Male")){
            com.clickElement(driver,motorCycle.getGenderMaleRadioButton(),"Gender Male radio Button");
        }else{
            com.clickElement(driver,motorCycle.getGenFemaleRadioButton(),"Gender Female radio Button");
        }
        com.type(driver,motorCycle.getStressAddressTextField(),"Street Address",strStreetAddress);
        com.clickElement(driver,motorCycle.getCountrySelectDropDown(),"Country DropDown box");
        try {
            com.selectByText(driver,motorCycle.getCountrySelectDropDown(),"County DropDown Box",strCountry);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,motorCycle.getZipCode(),"Zip Code",strZipCode);
        com.type(driver,motorCycle.getCityTextField(),"City",strCity);
        com.clickElement(driver,motorCycle.getOccupationDropDown(),"Occupation DropDown box");
        try {
            com.selectByText(driver,motorCycle.getOccupationDropDown(),"Occupation DropDown Box",strOccupation);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        switch (strHobbies.toLowerCase()){
            case "speeding":
                com.clickElement(driver,motorCycle.getSpeeadingCheckBox(),"Speeding check Box");
                break;
            case "bungee jumping":
                com.clickElement(driver,motorCycle.getBungeeJumpingCheckBox(),"bungee jumping check Box");
                break;
            case "cliff driving":
                com.clickElement(driver,motorCycle.getCliffDivingCheckBox(),"Cliff Diving check Box");
                break;
            case "skydiving":
                com.clickElement(driver,motorCycle.getSkydivingCheckBox(),"sky Diving  Box");
                break;
            case "other":
                com.clickElement(driver,motorCycle.getOtherCheckBox(),"other check Box");
                break;
            default:
                throw new CheckboxOptionIsNotAvailable("Hobbies value you provided is not available in application");
        }
        com.type(driver,motorCycle.getWebSiteTextfield(),"WebSite",strWebSite);
//        com.clickElement(driver,auto.getOpenButton(),"Open Button");
//        File uploadFile = new File(System.getProperty("user.dir")+"/FileUpload/"+strFileName);
//        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
//        fileInput.sendKeys(uploadFile.getAbsolutePath());
//        driver.findElement(By.id("file-submit")).click();
//
//        WebElement fileName = driver.findElement(By.id("uploaded-files"));
//        Assertions.assertEquals("selenium-snapshot.png", fileName.getText());

        com.clickElement(driver,motorCycle.getNextbuttonProductData(),"Next Button");
        Date date=new Date();

        SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");

        date= DateUtils.addDays(date,50);
        String advancedDate= dateFormat.format(date);
        com.type(driver,motorCycle.getProductdataStartDate(),"Start Date",advancedDate);

        com.clickElement(driver,motorCycle.getProductDataInsuranceSumDropDown(),"InsuranceSum DropDown ");
        try {
            com.selectByText(driver,motorCycle.getProductDataInsuranceSumDropDown(),"InsuranceSum DropDown",strInsuranceSum);
        }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }



        com.clickElement(driver,motorCycle.getProductDataDamageInsurance(),"DamageInsurance DropDown ");
        try {
            com.selectByText(driver,motorCycle.getProductDataDamageInsurance(),"DamageInsurance DropDown",strDamageInsurance);
        }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        switch (strOptionalProduct.toLowerCase()){
            case "euro protection":
                com.clickElement(driver,motorCycle.getProductDataOptionalProudctsEuroProtectionCheckBox(),"Euro Protection check Box");
                break;
            case "legal defense insurance":
                com.clickElement(driver,motorCycle.getProductDataLegalDefenseInsuranceCheckBox(),"legal defense Insurance check Box");
                break;

            default:
                throw new CheckboxOptionIsNotAvailable("Optional Product value you provided is not available in application");
        }


        com.javascriptExecutorMethod(driver,motorCycle.getProductDataNextSelectPriceOptionButton(),"Next button");
        com.clickElement(driver,motorCycle.getProductDataNextSelectPriceOptionButton(),"Next Button ");

        switch (strPriceOption.toLowerCase()){
            case "silver":
                com.clickElement(driver,motorCycle.getSelectPriceOptionSilverRadioButton(),"silver radio button ");
                break;
            case "gold":
                com.clickElement(driver,motorCycle.getSelectPriceOptionGoldRadioButton(),"Gold Radio button ");
                break;
            case "platinum":
                com.clickElement(driver,motorCycle.getSelectPriceOptionPlatinumRadioButton(),"Platinum Radio Button ");
                break;
            case "ultimate":
                com.clickElement(driver,motorCycle.getSelectPriceOptionUltimateRadioButton(),"ultimate radio button");
                break;
            default:
                throw new RadioButtonOptionIsNotAvailable("Hobbies value you provided is not available in application");
        }
        com.clickElement(driver,motorCycle.getSelectPriceOptionNextButton(),"Next Button ");
        com.type(driver,motorCycle.getSendQuoteEmailTextField(),"Email ",strEmail);
        com.type(driver,motorCycle.getSendQuotePhoneTextField(),"Phone ",strPhone);
        com.type(driver,motorCycle.getSendQuoteUsernameTextField(),"Username ",strUsername);
        com.type(driver,motorCycle.getSendQuotePasswordTextField(),"Password  ",strPassword);
        com.type(driver,motorCycle.getSendQuoteConfirmPasswordTextField(),"Confirm Password  ",strConfirmPassword);
        com.type(driver,motorCycle.getSendQuoteCommentTextArea(),"Comments  ",strComments);
        com.clickElement(driver,motorCycle.getSendQuoteSendQuoteButton(),"Send Button ");
        if(com.isVisibleOnPage(driver,motorCycle.getSendingEmailNotification())){
            String emailNotificationMessage=driver.findElement(motorCycle.getSendingEmailNotification()).getText();
            if(emailNotificationMessage.equalsIgnoreCase("Sending e-mail success!")){
                com.clickElement(driver,motorCycle.getOkButton(),"OK Button ");
                Assert.assertTrue(true,"Sending e-mail success!");
                ExtentTestManager.getInstance(test).getTest().log(Status.PASS,String.valueOf(" Pop up Message is "+emailNotificationMessage+" Available "));
            }else {
                ExtentTestManager.getInstance(test).getTest().log(Status.FAIL,String.valueOf(" Pop up Message is "+emailNotificationMessage+" Not Available "));
                Assert.fail("Sending e-mail success! is not available ");
            }
        }



    }


    public void TestCamper(WebDriver driver,String strMake,String strEngPer,String strDOM,
                          String strNoSeats,String strRightHandDrive,String strFuelType,String strPaylaod,String strTotalWeight,String strListPrice,String strLicensePlate,
                          String strAnualMilege,String strFirstname,String strLastName,String strDateOfBirth,
                          String strGender,String strStreetAddress,String strCountry,String strZipCode,
                          String strCity,String strOccupation,String strHobbies,String strWebSite,
                          String strFileName,String strInsuranceSum,String strDamageInsurance,String strOptionalProduct,
                          String strPriceOption,String strEmail,String strPhone,String strUsername,String strPassword,
                          String strConfirmPassword,String strComments) throws CheckboxOptionIsNotAvailable, RadioButtonOptionIsNotAvailable {


        com.clickElement(driver,camper.getCamperLink(),"camper Link");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        com.clickElement(driver,camper.getMakeComBoBox(),"makeCombo");
        try {
            com.javascriptExecutorMethod(driver,camper.getMakeComBoBox(),"makeCombo");
            com.selectByText(driver,camper.getMakeComBoBox(),"combo",strMake);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,camper.getEnginePerformanceKW(),"EnginePEr",strEngPer);
        com.type(driver,camper.getDateOfManufacturing(),"dateofmanu",strDOM);

        com.clickElement(driver,camper.getSelectNumberOfSeats(),"seat");
        try {
            com.selectByText(driver,camper.getSelectNumberOfSeats(),"combo",strNoSeats);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        switch (strRightHandDrive.toLowerCase()){
            case "yes":
                com.clickElement(driver,camper.getRightHadDriverYesRadioButton(),"Euro Protection check Box");
                break;
            case "no":
                com.clickElement(driver,camper.getRightHandDriverNoRadioButton(),"legal defense Insurance check Box");
                break;

            default:
                throw new RadioButtonOptionIsNotAvailable("Right Hand Drive value you provided is not available in application");
        }

        com.clickElement(driver,camper.getFuelType(),"Fuel Type");
        try {
            com.selectByText(driver,camper.getFuelType(),"combo",strFuelType);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,camper.getPayLoad(),"Pay Load ",strPaylaod);
        com.type(driver,camper.getTotalWeight(),"Total Weight ",strTotalWeight);

        com.type(driver,camper.getListPrice(),"listprice",strListPrice);
        com.type(driver,camper.getLicensePlateNumber(),"licenseplatenumber",strLicensePlate);
        com.type(driver,camper.getAnualMilege(),"Anual Milenge",strAnualMilege);
        com.clickElement(driver,camper.getNextButton(),"Next Button");
        com.type(driver,camper.getFirstNameTextField(),"FirstName",strFirstname);
        com.type(driver,camper.getLastNameTextField(),"LastName",strLastName);
        com.type(driver,camper.getDateOfBirthTextField(),"Date Of Birth",strDateOfBirth);
        if(strGender.equalsIgnoreCase("Male")){
            com.clickElement(driver,camper.getGenderMaleRadioButton(),"Gender Male radio Button");
        }else{
            com.clickElement(driver,camper.getGenFemaleRadioButton(),"Gender Female radio Button");
        }
        com.type(driver,camper.getStressAddressTextField(),"Street Address",strStreetAddress);
        com.clickElement(driver,camper.getCountrySelectDropDown(),"Country DropDown box");
        try {
            com.selectByText(driver,camper.getCountrySelectDropDown(),"County DropDown Box",strCountry);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,camper.getZipCode(),"Zip Code",strZipCode);
        com.type(driver,camper.getCityTextField(),"City",strCity);
        com.clickElement(driver,camper.getOccupationDropDown(),"Occupation DropDown box");
        try {
            com.selectByText(driver,camper.getOccupationDropDown(),"Occupation DropDown Box",strOccupation);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        switch (strHobbies.toLowerCase()){
            case "speeding":
                com.clickElement(driver,camper.getSpeeadingCheckBox(),"Speeding check Box");
                break;
            case "bungee jumping":
                com.clickElement(driver,camper.getBungeeJumpingCheckBox(),"bungee jumping check Box");
                break;
            case "cliff driving":
                com.clickElement(driver,camper.getCliffDivingCheckBox(),"Cliff Diving check Box");
                break;
            case "skydiving":
                com.clickElement(driver,camper.getSkydivingCheckBox(),"sky Diving  Box");
                break;
            case "other":
                com.clickElement(driver,camper.getOtherCheckBox(),"other check Box");
                break;
            default:
                throw new CheckboxOptionIsNotAvailable("Hobbies value you provided is not available in application");
        }
        com.type(driver,camper.getWebSiteTextfield(),"WebSite",strWebSite);
//        com.clickElement(driver,auto.getOpenButton(),"Open Button");
//        File uploadFile = new File(System.getProperty("user.dir")+"/FileUpload/"+strFileName);
//        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
//        fileInput.sendKeys(uploadFile.getAbsolutePath());
//        driver.findElement(By.id("file-submit")).click();
//
//        WebElement fileName = driver.findElement(By.id("uploaded-files"));
//        Assertions.assertEquals("selenium-snapshot.png", fileName.getText());

        com.clickElement(driver,camper.getNextbuttonProductData(),"Next Button");
        Date date=new Date();

        SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");

        date= DateUtils.addDays(date,50);
        String advancedDate= dateFormat.format(date);
        com.type(driver,camper.getProductdataStartDate(),"Start Date",advancedDate);

        com.clickElement(driver,camper.getProductDataInsuranceSumDropDown(),"InsuranceSum DropDown ");
        try {
            com.selectByText(driver,camper.getProductDataInsuranceSumDropDown(),"InsuranceSum DropDown",strInsuranceSum);
        }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }



        com.clickElement(driver,camper.getProductDataDamageInsurance(),"DamageInsurance DropDown ");
        try {
            com.selectByText(driver,camper.getProductDataDamageInsurance(),"DamageInsurance DropDown",strDamageInsurance);
        }catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        switch (strOptionalProduct.toLowerCase()){
            case "euro protection":
                com.clickElement(driver,camper.getProductDataOptionalProudctsEuroProtectionCheckBox(),"Euro Protection check Box");
                break;
            case "legal defense insurance":
                com.clickElement(driver,camper.getProductDataLegalDefenseInsuranceCheckBox(),"legal defense Insurance check Box");
                break;

            default:
                throw new CheckboxOptionIsNotAvailable("Optional Product value you provided is not available in application");
        }


        com.javascriptExecutorMethod(driver,camper.getProductDataNextSelectPriceOptionButton(),"Next button");
        com.clickElement(driver,camper.getProductDataNextSelectPriceOptionButton(),"Next Button ");

        switch (strPriceOption.toLowerCase()){
            case "silver":
                com.clickElement(driver,camper.getSelectPriceOptionSilverRadioButton(),"silver radio button ");
                break;
            case "gold":
                com.clickElement(driver,camper.getSelectPriceOptionGoldRadioButton(),"Gold Radio button ");
                break;
            case "platinum":
                com.clickElement(driver,camper.getSelectPriceOptionPlatinumRadioButton(),"Platinum Radio Button ");
                break;
            case "ultimate":
                com.clickElement(driver,camper.getSelectPriceOptionUltimateRadioButton(),"ultimate radio button");
                break;
            default:
                throw new RadioButtonOptionIsNotAvailable("Hobbies value you provided is not available in application");
        }
        com.clickElement(driver,camper.getSelectPriceOptionNextButton(),"Next Button ");
        com.type(driver,camper.getSendQuoteEmailTextField(),"Email ",strEmail);
        com.type(driver,camper.getSendQuotePhoneTextField(),"Phone ",strPhone);
        com.type(driver,camper.getSendQuoteUsernameTextField(),"Username ",strUsername);
        com.type(driver,camper.getSendQuotePasswordTextField(),"Password  ",strPassword);
        com.type(driver,camper.getSendQuoteConfirmPasswordTextField(),"Confirm Password  ",strConfirmPassword);
        com.type(driver,camper.getSendQuoteCommentTextArea(),"Comments  ",strComments);
        com.clickElement(driver,camper.getSendQuoteSendQuoteButton(),"Send Button ");
        if(com.isVisibleOnPage(driver,camper.getSendingEmailNotification())){
            String emailNotificationMessage=driver.findElement(camper.getSendingEmailNotification()).getText();
            if(emailNotificationMessage.equalsIgnoreCase("Sending e-mail success!")){
                com.clickElement(driver,camper.getOkButton(),"OK Button ");
                Assert.assertTrue(true,"Sending e-mail success!");
                ExtentTestManager.getInstance(test).getTest().log(Status.PASS,String.valueOf(" Pop up Message is "+emailNotificationMessage+" Available "));
            }else {
                ExtentTestManager.getInstance(test).getTest().log(Status.FAIL,String.valueOf(" Pop up Message is "+emailNotificationMessage+" Not Available "));
                Assert.fail("Sending e-mail success! is not available ");
            }
        }



    }



    public void TestAutomobile2(WebDriver driver,String strMake,String strEngPer,String strDOM,String strNoSeats,String strFuelType,String strListPrice,String strLicensePlate,String strAnualMilege){


        int count=1;

            com.clickElement(driver,auto.getAutomobileLink(),"automobileLink");

        com.clickElement(driver,auto.getMakeComBoBox(),"makeCombo");
        try {
            com.selectByText(driver,auto.getMakeComBoBox(),"combo",strMake);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,auto.getEnginePerformanceKW(),"EnginePEr",strEngPer);
        com.type(driver,auto.getDateOfManufacturing(),"dateofmanu",strDOM);

        com.clickElement(driver,auto.getSelectNumberOfSeats(),"seat");
        try {
            com.selectByText(driver,auto.getSelectNumberOfSeats(),"combo",strNoSeats);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.clickElement(driver,auto.getFuelType(),"Fuel Type");
        try {
            com.selectByText(driver,auto.getFuelType(),"combo",strFuelType);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.type(driver,auto.getListPrice(),"listprice",strListPrice);
        com.type(driver,auto.getLicensePlateNumber(),"licenseplatenumber",strLicensePlate);
        com.type(driver,auto.getAnualMilege(),"Anual Milenge",strAnualMilege);


    }

    public void TestAutomobile3(WebDriver driver,String strMake,String strEngPer,String strDOM,String strNoSeats,String strFuelType,String strListPrice,String strLicensePlate,String strAnualMilege){


        int count=1;

            com.clickElement(driver,auto.getAutomobileLink(),"automobileLink");

        com.clickElement(driver,auto.getMakeComBoBox(),"makeCombo");
        try {
            com.selectByText(driver,auto.getMakeComBoBox(),"combo",strMake);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,auto.getEnginePerformanceKW(),"EnginePEr",strEngPer);
        com.type(driver,auto.getDateOfManufacturing(),"dateofmanu",strDOM);

        com.clickElement(driver,auto.getSelectNumberOfSeats(),"seat");
        try {
            com.selectByText(driver,auto.getSelectNumberOfSeats(),"combo",strNoSeats);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.clickElement(driver,auto.getFuelType(),"Fuel Type");
        try {
            com.selectByText(driver,auto.getFuelType(),"combo",strFuelType);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.type(driver,auto.getListPrice(),"listprice",strListPrice);
        com.type(driver,auto.getLicensePlateNumber(),"licenseplatenumber",strLicensePlate);
        com.type(driver,auto.getAnualMilege(),"Anual Milenge",strAnualMilege);


    }


    public void TestAutomobile4(WebDriver driver,String strMake,String strEngPer,String strDOM,String strNoSeats,String strFuelType,String strListPrice,String strLicensePlate,String strAnualMilege){


        int count=1;

        com.clickElement(driver,auto.getAutomobileLink(),"automobileLink");

        com.clickElement(driver,auto.getMakeComBoBox(),"makeCombo");
        try {
            com.selectByText(driver,auto.getMakeComBoBox(),"combo",strMake);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }
        com.type(driver,auto.getEnginePerformanceKW(),"EnginePEr",strEngPer);
        com.type(driver,auto.getDateOfManufacturing(),"dateofmanu",strDOM);

        com.clickElement(driver,auto.getSelectNumberOfSeats(),"seat");
        try {
            com.selectByText(driver,auto.getSelectNumberOfSeats(),"combo",strNoSeats);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.clickElement(driver,auto.getFuelType(),"Fuel Type");
        try {
            com.selectByText(driver,auto.getFuelType(),"combo",strFuelType);
        } catch (DataIsNotVisible e) {
            throw new RuntimeException(e);
        }

        com.type(driver,auto.getListPrice(),"listprice",strListPrice);
        com.type(driver,auto.getLicensePlateNumber(),"licenseplatenumber",strLicensePlate);
        com.type(driver,auto.getAnualMilege(),"Anual Milenge",strAnualMilege);


    }


    public void TestCase1(WebDriver driver,String strName,String strEmailAddress,
                          String strTitle,String strPassword,String strDay,String strMonth,String strYear,String strFirstName,String strLastName,
                          String strCompany,String strAddress1,String strAddress2,String strCountry,String strState,String strCity,String strZipcode,
                          String strMobileNumber,String strworkbookname,String strsheetName,String strTestCaseName,String strtestdataColumnname,String strPasswordColumn){


        List<WebElement> list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        if(com.isVisibleOnPage(driver,lp.getNewUserSignInLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("New User is visible");
            Assert.assertTrue(true,"New User Signup! is visible");
        }else {
            ExtentTestManager.getInstance(test).getTest().fail("New User Signup is not Visible");
            Assert.fail("New User Signup! is not visible");
        }
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100000);
        String usernameEntered=strName+rand_int1;
        com.type(driver,lp.getName(),"Name",usernameEntered);
        com.type(driver,lp.getEmailAddress(),"Email Address",strEmailAddress+rand_int1+"@gmail.com");

        String emailAddress=driver.findElement(lp.getEmailAddress()).getAttribute("value");
        TestDataReader writer=new TestDataReader();
        try {
            writer.writeToExcelSheet(strworkbookname,strsheetName,strTestCaseName,strtestdataColumnname,emailAddress);
        }catch (InvalidFormatException|IOException e) {
            throw new RuntimeException(e);
        }
        com.clickElement(driver,lp.getSignUp(),"Sign up button");
        if(com.isVisibleOnPage(driver,sp.getEnterAccountInformationLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Enter Account Information is Visible");
            Assert.assertTrue(true,"\"Enter Account Information\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Enter Account Information is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("\"Enter Account Information\" is not Visible");
        }
        if(strTitle.equalsIgnoreCase("mr")){
                    com.clickElement(driver,sp.getTitleMr(),"Mr Title");
        }else{
            com.clickElement(driver,sp.getTitleMr(),"Mr Title");
        }

        com.type(driver,sp.getPassWord(),"Password",strPassword);

        String pass=driver.findElement(sp.getPassWord()).getAttribute("value");
        try {
            writer.writeToExcelSheet(strworkbookname,strsheetName,strTestCaseName,strPasswordColumn,pass);
        }catch (InvalidFormatException|IOException e) {
            throw new RuntimeException(e);
        }
        try {
            com.javascriptExecutorMethod(driver,sp.getDays(),"Days");
            com.clickElement(driver,sp.getDays(),"Days");
            com.selectByText(driver,sp.getDays(),"Days",strDay);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strDay+" Enter Data Information is not Visible");
        }
        try {
            com.clickElement(driver,sp.getMonths(),"Month");
            com.selectByText(driver,sp.getMonths(),"Month",strMonth);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strMonth+" Enter Data Information is not Visible");
        }
        try {
            com.clickElement(driver,sp.getYears(),"Year");
            com.selectByText(driver,sp.getYears(),"Year",strYear);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strYear+" Enter Data Information is not Visible");
        }
        com.javascriptExecutorMethod(driver,sp.getNewsLetterCheckBox(),"NewsLetter Checkbox");
        com.selectCheckBox(driver,sp.getNewsLetterCheckBox(),"select NewsLetter checkbox");
        com.javascriptExecutorMethod(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.selectCheckBox(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.javascriptExecutorMethod(driver,sp.getFirstName(),"First Name");
        com.type(driver,sp.getFirstName(),"First Name",strFirstName);
        com.javascriptExecutorMethod(driver,sp.getLastName(),"Last Name");
        com.type(driver,sp.getLastName(),"Last Name",strLastName);
        com.javascriptExecutorMethod(driver,sp.getCompany(),"Company");
        com.type(driver,sp.getCompany(),"Company",strCompany);
        com.javascriptExecutorMethod(driver,sp.getAddress1(),"Address1");
        com.type(driver,sp.getAddress1(),"Address1",strAddress1);
        com.javascriptExecutorMethod(driver,sp.getAddress2(),"Address2");
        com.type(driver,sp.getAddress2(),"Address2",strAddress2);
        com.javascriptExecutorMethod(driver,sp.getCountrySelect(),"Country");
        try {
            com.clickElement(driver,sp.getCountrySelect(),"Country");
            com.selectByText(driver,sp.getCountrySelect(),"Country",strCountry);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strCountry+" Enter Data Information is not Visible");
        }
        com.javascriptExecutorMethod(driver,sp.getState(),"State");
        com.type(driver,sp.getState(),"State",strState);
        com.javascriptExecutorMethod(driver,sp.getCity(),"City");
        com.type(driver,sp.getCity(),"City",strCity);
        com.javascriptExecutorMethod(driver,sp.getZipCode(),"Zipcode");
        com.type(driver,sp.getZipCode(),"Zipcode",strZipcode);
        com.javascriptExecutorMethod(driver,sp.getMobileNumber(),"MobileNumber");
        com.type(driver,sp.getMobileNumber(),"MobileNumber",strMobileNumber);
        com.javascriptExecutorMethod(driver,sp.getCreateAccountButton(),"Create Account Button");
        com.clickElement(driver,sp.getCreateAccountButton(),"Create Account button");
        if(com.isVisibleOnPage(driver,acp.getAccountCreatedLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Account Create! Label is Visible");
            Assert.assertTrue(true,"\"Account Create!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Account Create! Label is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("\"Account Create!\" is not Visible");
        }
        com.javascriptExecutorMethod(driver,acp.getContinueBtn(),"continue button");
        com.clickElement(driver,acp.getContinueBtn(),"continue button");
        list1=driver.findElements(By.xpath("//iframe[@id='aswift_1']"));
        if(!list1.isEmpty()){
            com.switchToFrameID(driver,"aswift_1");
            System.out.println("Switched to first Frame");
            if(!list1.isEmpty()){
                List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list3.isEmpty()){
                    if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                        if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                            System.out.println("Switched to Close Button");
                            com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                        }
                    }
                }

            }

            List<WebElement> list2=driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
            if(!list2.isEmpty()){
                com.switchToFrameID(driver,"ad_iframe");
                System.out.println("Switched to second frame");
                list1=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list1.isEmpty()){
                    List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                    if(!list3.isEmpty()){
                        if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                            if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                                System.out.println("Switched to Close Button inside Frame2");
                                com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                            }
                        }
                    }

                }

                System.out.println("switching from Second frame");
                driver.switchTo().defaultContent();

            }
            System.out.println("switching from Second frame");
            driver.switchTo().defaultContent();

        }

        if(com.isVisibleOnPage(driver,hp.getLoggedInAsUsername())){
            driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B>"+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>\"Logged in as \" </B>is not Visible");
            Assert.fail("\"Logged in as \" is not Visible");

        }
        com.clickElement(driver,hp.getDeleteAccount(),"Delete Account Link");
        if(com.isVisibleOnPage(driver,adp.getAccountDeletedLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("\"Account Deleted!\" is Visible");
            Assert.assertTrue(true,"\"Account Deleted!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("\"Account Deleted!\" is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("\"Account Deleted!\" is not Visible");
        }
        com.clickElement(driver,adp.getContinueBtn(),"Continue Button");
    }


    public void TestCase1Remote(RemoteWebDriver driver,String strName,String strEmailAddress,
                          String strTitle,String strPassword,String strDay,String strMonth,String strYear,String strFirstName,String strLastName,
                          String strCompany,String strAddress1,String strAddress2,String strCountry,String strState,String strCity,String strZipcode,
                          String strMobileNumber,String strworkbookname,String strsheetName,String strTestCaseName,String strtestdataColumnname,String ColumnPassword){
        Actions act=new Actions(driver);

        List<WebElement> list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        com.clickElementRemote(driver,hp.getSignUp_Login(),"Signup/Login");
        if(com.isVisibleOnPageRemote(driver,lp.getNewUserSignInLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("New User is visible");
            Assert.assertTrue(true,"New User Signup! is visible");
        }else {
            ExtentTestManager.getInstance(test).getTest().fail("New User Signup is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("New User Signup! is not visible");
        }
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100000);
        String usernameEntered=strName+rand_int1;
        com.typeRemote(driver,lp.getName(),"Name",usernameEntered);
        com.typeRemote(driver,lp.getEmailAddress(),"Email Address",strEmailAddress+rand_int1+"@gmail.com");
        String emailAddress=driver.findElement(lp.getEmailAddress()).getAttribute("value");
        TestDataReader writer=new TestDataReader();

        try {
            writer.writeToExcelSheet(strworkbookname,strsheetName,strTestCaseName,strtestdataColumnname,emailAddress);
        }catch (InvalidFormatException|IOException e) {
            throw new RuntimeException(e);
        }

        com.clickElementRemote(driver,lp.getSignUp(),"Sign up button");
        if(com.isVisibleOnPageRemote(driver,sp.getEnterAccountInformationLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Enter Account Information is Visible");
            Assert.assertTrue(true,"\"Enter Account Information\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Enter Account Information is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("\"Enter Account Information\" is not Visible");
        }
        if(strTitle.equalsIgnoreCase("mr")){
            com.clickElementRemote(driver,sp.getTitleMr(),"Mr Title");
        }else{
            com.clickElementRemote(driver,sp.getTitleMr(),"Mr Title");
        }

        com.typeRemote(driver,sp.getPassWord(),"Password",strPassword);
        String password=driver.findElement(sp.getPassWord()).getAttribute("value");
        try {
            com.clickElementRemote(driver,sp.getDays(),"Days Combo box");
            com.selectByTextRemote(driver,sp.getDays(),"Days",strDay);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strDay+" Enter Data Information is not Visible");
        }

        try {
            com.clickElementRemote(driver,sp.getMonths(),"Month Combo box");
            com.selectByTextRemote(driver,sp.getMonths(),"Month",strMonth);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strMonth+" Enter Data Information is not Visible");
        }

        try {
            com.clickElementRemote(driver,sp.getYears(),"Year Combo box");
            com.selectByTextRemote(driver,sp.getYears(),"Year",strYear);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strYear+" Enter Data Information is not Visible");
        }


        com.javascriptExecutorMethodRemote(driver,sp.getNewsLetterCheckBox(),"NewsLetter Checkbox");
        com.selectCheckBoxRemote(driver,sp.getNewsLetterCheckBox(),"select NewsLetter checkbox");
        com.javascriptExecutorMethodRemote(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.selectCheckBoxRemote(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.javascriptExecutorMethodRemote(driver,sp.getFirstName(),"First Name");
        com.typeRemote(driver,sp.getFirstName(),"First Name",strFirstName);
        com.javascriptExecutorMethodRemote(driver,sp.getLastName(),"Last Name");
        com.typeRemote(driver,sp.getLastName(),"Last Name",strLastName);
        com.javascriptExecutorMethodRemote(driver,sp.getCompany(),"Company");
        com.typeRemote(driver,sp.getCompany(),"Company",strCompany);
        com.javascriptExecutorMethodRemote(driver,sp.getAddress1(),"Address1");
        com.typeRemote(driver,sp.getAddress1(),"Address1",strAddress1);
        com.javascriptExecutorMethodRemote(driver,sp.getAddress2(),"Address2");
        com.typeRemote(driver,sp.getAddress2(),"Address2",strAddress2);
        com.javascriptExecutorMethodRemote(driver,sp.getCountrySelect(),"Country");
        try {
            com.clickElementRemote(driver,sp.getCountrySelect(),"Country Combo Box");
            com.selectByTextRemote(driver,sp.getCountrySelect(),"Country",strCountry);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strCountry+" Enter Data Information is not Visible");
        }
        com.javascriptExecutorMethodRemote(driver,sp.getState(),"State");
        com.typeRemote(driver,sp.getState(),"State",strState);
        com.javascriptExecutorMethodRemote(driver,sp.getCity(),"City");
        com.typeRemote(driver,sp.getCity(),"City",strCity);
        com.javascriptExecutorMethodRemote(driver,sp.getZipCode(),"Zipcode");
        com.typeRemote(driver,sp.getZipCode(),"Zipcode",strZipcode);
        com.javascriptExecutorMethodRemote(driver,sp.getMobileNumber(),"MobileNumber");
        com.typeRemote(driver,sp.getMobileNumber(),"MobileNumber",strMobileNumber);
        com.javascriptExecutorMethodRemote(driver,sp.getCreateAccountButton(),"Create Account Button");
        com.clickElementRemote(driver,sp.getCreateAccountButton(),"Create Account button");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(com.isVisibleOnPageRemote(driver,acp.getAccountCreatedLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Account Create! Label is Visible");
            Assert.assertTrue(true,"\"Account Create!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Account Create! Label is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("\"Account Create!\" is not Visible");
        }
        com.javascriptExecutorMethodRemote(driver,acp.getContinueBtn(),"continue button");
        com.clickElementRemote(driver,acp.getContinueBtn(),"continue button");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list1=driver.findElements(By.xpath("//iframe[@id='aswift_1']"));
        if(!list1.isEmpty()){
            com.switchToFrameIDRemote(driver,"aswift_1");
            System.out.println("Switched to first Frame");
           // act.moveToElement(driver.findElement(By.xpath("//iframe[@id='aswift_1']")).sendKeys();
            if(!list1.isEmpty()){
                List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list3.isEmpty()){
                    if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                        //com.switchToFrameIDRemote(driver,"ad_iframe");
                        ExtentTestManager.getInstance(test).getTest().pass("close button inside frame1 is Visible");
                        if(com.isVisibleOnPageRemote(driver,acp.getDownloadpagedismisslink())){
                            System.out.println("Switched to Close Button");
                            com.clickElementRemote(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                        }
                    }
                }
                //act.moveToElement(element3).build().perform();
            }
            List<WebElement> list2=driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
            if(!list2.isEmpty()){
                // driver.manage().window().fullscreen();
                com.switchToFrameIDRemote(driver,"ad_iframe");
                System.out.println("Switched to second frame");
                list1=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list1.isEmpty()){
                    List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                    if(!list3.isEmpty()){
                        if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                            if(com.isVisibleOnPageRemote(driver,acp.getDownloadpagedismisslink())){
                                ExtentTestManager.getInstance(test).getTest().pass("close button inside frame2 is Visible");
                                System.out.println("Switched to Close Button inside Frame2");
                                com.clickElementRemote(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                            }
                        }
                    }

                    //act.moveToElement(element3).build().perform();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("switching from Second frame");
                driver.switchTo().defaultContent();

            }
            System.out.println("switching from First frame");
            driver.switchTo().defaultContent();

        }
        if(com.isVisibleOnPageRemote(driver,hp.getLoggedInAsUsername())){
            driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B>"+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>\"Logged in as \" </B>is not Visible");
            Assert.fail("\"Logged in as \" is not Visible");

        }
        com.clickElementRemote(driver,hp.getDeleteAccount(),"Delete Account Link");
        if(com.isVisibleOnPageRemote(driver,adp.getAccountDeletedLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("\"Account Deleted!\" is Visible");
            Assert.assertTrue(true,"\"Account Deleted!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("\"Account Deleted!\" is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("\"Account Deleted!\" is not Visible");
        }
        com.clickElementRemote(driver,adp.getContinueBtn(),"Continue Button");
    }

    public void TestCase2(WebDriver driver,String strName,String strEmailAddress,
                          String strTitle,String strPassword,String strDay,String strMonth,String strYear,String strFirstName,String strLastName,
                          String strCompany,String strAddress1,String strAddress2,String strCountry,String strState,String strCity,String strZipcode,
                          String strMobileNumber){


        //**************************Pre Requisite for Test Case2 *********************************************//
        // Account is Getting Created First and this Account will be used for Test Case2 Test Cases
        Actions act=new Actions(driver);
        List<WebElement> list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        try {
            com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        } catch (StaleElementReferenceException e) {
            //com.clickElement(driver,hp.getSignup_login(),"Signup/Login");
        }
        if(com.isVisibleOnPage(driver,lp.getNewUserSignInLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("New User is visible");
            Assert.assertTrue(true,"New User Signup! is visible");
        }else {
            ExtentTestManager.getInstance(test).getTest().fail("New User Signup is not Visible");
            Assert.fail("New User Signup! is not visible");
        }
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100000);
        String usernameEntered=strName+rand_int1;
        com.type(driver,lp.getName(),"Name",usernameEntered);
        String emailAddress=strEmailAddress+rand_int1+"@gmail.com";
        com.type(driver,lp.getEmailAddress(),"Email Address",emailAddress);

        com.clickElement(driver,lp.getSignUp(),"Sign up button");
        if(com.isVisibleOnPage(driver,sp.getEnterAccountInformationLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Enter Account Information is Visible");
            Assert.assertTrue(true,"\"Enter Account Information\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Enter Account Information is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("\"Enter Account Information\" is not Visible");
        }
        if(strTitle.equalsIgnoreCase("mr")){
            com.clickElement(driver,sp.getTitleMr(),"Mr Title");
        }else{
            com.clickElement(driver,sp.getTitleMr(),"Mr Title");
        }

        com.type(driver,sp.getPassWord(),"Password",strPassword);

        com.javascriptExecutorMethod(driver,sp.getDays(),"Days Combo box");
        try {
            com.clickElement(driver,sp.getDays(),"Days ComboBox");
            com.selectByText(driver,sp.getDays(),"Days",strDay);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strDay+ "Enter Data Information is not Visible");
        }
        try {
            com.clickElement(driver,sp.getMonths(),"Month ComboBox");
            com.selectByText(driver,sp.getMonths(),"Month",strMonth);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strMonth+ "Enter Data Information is not Visible");
        }
        try {
            com.clickElement(driver,sp.getYears(),"Year ComboBox");
            com.selectByText(driver,sp.getYears(),"Year",strYear);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strYear+ "Enter Data Information is not Visible");
        }
        com.javascriptExecutorMethod(driver,sp.getNewsLetterCheckBox(),"NewsLetter Checkbox");
        com.selectCheckBox(driver,sp.getNewsLetterCheckBox(),"select NewsLetter checkbox");
        com.javascriptExecutorMethod(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.selectCheckBox(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.javascriptExecutorMethod(driver,sp.getFirstName(),"First Name");
        com.type(driver,sp.getFirstName(),"First Name",strFirstName);
        com.javascriptExecutorMethod(driver,sp.getLastName(),"Last Name");
        com.type(driver,sp.getLastName(),"Last Name",strLastName);
        com.javascriptExecutorMethod(driver,sp.getCompany(),"Company");
        com.type(driver,sp.getCompany(),"Company",strCompany);
        com.javascriptExecutorMethod(driver,sp.getAddress1(),"Address1");
        com.type(driver,sp.getAddress1(),"Address1",strAddress1);
        com.javascriptExecutorMethod(driver,sp.getAddress2(),"Address2");
        com.type(driver,sp.getAddress2(),"Address2",strAddress2);
        com.javascriptExecutorMethod(driver,sp.getCountrySelect(),"Country");
        try {
            com.clickElement(driver,sp.getCountrySelect(),"Country ComboBox");
            com.selectByText(driver,sp.getCountrySelect(),"Country",strCountry);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
        }
        com.javascriptExecutorMethod(driver,sp.getState(),"State");
        com.type(driver,sp.getState(),"State",strState);
        com.javascriptExecutorMethod(driver,sp.getCity(),"City");
        com.type(driver,sp.getCity(),"City",strCity);
        com.javascriptExecutorMethod(driver,sp.getZipCode(),"Zipcode");
        com.type(driver,sp.getZipCode(),"Zipcode",strZipcode);
        com.javascriptExecutorMethod(driver,sp.getMobileNumber(),"MobileNumber");
        com.type(driver,sp.getMobileNumber(),"MobileNumber",strMobileNumber);
        com.javascriptExecutorMethod(driver,sp.getCreateAccountButton(),"Create Account Button");
        com.clickElement(driver,sp.getCreateAccountButton(),"Create Account button");
        if(com.isVisibleOnPage(driver,acp.getAccountCreatedLabel())){
            //driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Account Create! Label is Visible");
            Assert.assertTrue(true,"\"Account Create!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Account Create! Label is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("\"Account Create!\" is not Visible");
        }
        com.clickElement(driver,acp.getContinueBtn(),"continue button");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        list1=driver.findElements(By.xpath("//iframe[@id='aswift_1']"));
//        if(!list1.isEmpty()){
//            com.switchToFrameID(driver,"aswift_1");
//            list1=driver.findElements(acp.getDownloadpagedismisslink());
//            if(!list1.isEmpty()){
//                WebElement element3=driver.findElement(acp.getDownloadpagedismisslink());
//                //act.moveToElement(element3).build().perform();
//                if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
//                    com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
//                }
//            }
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            driver.switchTo().defaultContent();
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        list1=driver.findElements(By.xpath("//iframe[@id='aswift_1']"));
        if(!list1.isEmpty()){
            com.switchToFrameID(driver,"aswift_1");
            System.out.println("Switched to first Frame");
            if(!list1.isEmpty()){
                List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list3.isEmpty()){
                    if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                        if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                            System.out.println("Switched to Close Button");
                            com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                        }
                    }
                }

                //act.moveToElement(element3).build().perform();

            }

            List<WebElement> list2=driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
            if(!list2.isEmpty()){
                // driver.manage().window().fullscreen();
                com.switchToFrameID(driver,"ad_iframe");
                System.out.println("Switched to second frame");
                list1=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list1.isEmpty()){
                    List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                    if(!list3.isEmpty()){
                        if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                            if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                                System.out.println("Switched to Close Button inside Frame2");
                                com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                            }
                        }
                    }

                    //act.moveToElement(element3).build().perform();

                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("switching from Second frame");
                driver.switchTo().defaultContent();

            }
            System.out.println("switching from First frame");
            driver.switchTo().defaultContent();

        }
       // driver.manage().window().maximize();
        if(com.isVisibleOnPage(driver,hp.getLoggedInAsUsername())){
            driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B>"+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>\"Logged in as \" </B>is not Visible");
            Assert.fail("\"Logged in as \" is not Visible");

        }
        com.clickElement(driver,hp.getLogout(),"Logout link");
        driver.manage().window().maximize();
        com.clickElement(driver,hp.getHomeLink(),"Home Page Link");
        driver.manage().window().maximize();

        //**************Test Case 2 is Starting Here ***********************************************************************************//


       list1=driver.findElements(hp.getTestCases());

        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        list1=driver.findElements(lp.getLogintoYourAccount());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Login to your account label is visible");
            Assert.assertTrue(true,"Login to your account label is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Login to your account label is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Login to your account label is not visible");
        }
        com.type(driver,lp.getEmail(),"EmailAddress",emailAddress);
        com.type(driver,lp.getPassword(),"password",strPassword);
        com.clickElement(driver,lp.getLoginButton(),"Login Button");

        if(com.isVisibleOnPage(driver,hp.getLoggedInAsUsername())){
            driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B> "+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            test.fail("<B>\"Logged in as \" </B>is not Visible");
            Assert.fail("\"Logged in as \" is not Visible");

        }
        com.clickElement(driver,hp.getDeleteAccount(),"Delete Account Link");
        if(com.isVisibleOnPage(driver,adp.getAccountDeletedLabel())){
           // driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("\"Account Deleted!\" is Visible");
            Assert.assertTrue(true,"\"Account Deleted!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("\"Account Deleted!\" is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("\"Account Deleted!\" is not Visible");
        }
        com.javascriptExecutorMethod(driver,adp.getContinueBtn(),"Continue Button");
        com.clickElement(driver,adp.getContinueBtn(),"Continue Button");

    }


    public void TestCase2_Remote(RemoteWebDriver driver, String strName, String strEmailAddress,
                                 String strTitle, String strPassword, String strDay, String strMonth, String strYear, String strFirstName, String strLastName,
                                 String strCompany, String strAddress1, String strAddress2, String strCountry, String strState, String strCity, String strZipcode,
                                 String strMobileNumber){


        //**************************Pre Requisite for Test Case2 *********************************************//
        // Account is Getting Created First and this Account will be used for Test Case2 Test Cases
        Actions act=new Actions(driver);
        List<WebElement> list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        com.clickElementRemote(driver,hp.getSignUp_Login(),"Signup/Login");
        if(com.isVisibleOnPageRemote(driver,lp.getNewUserSignInLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("New User is visible");
            Assert.assertTrue(true,"New User Signup! is visible");
        }else {
            ExtentTestManager.getInstance(test).getTest().fail("New User Signup is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("New User Signup! is not visible");
        }
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100000);
        String usernameEntered=strName+rand_int1;
        com.typeRemote(driver,lp.getName(),"Name",usernameEntered);
        String emailAddress=strEmailAddress+rand_int1+"@gmail.com";
        com.typeRemote(driver,lp.getEmailAddress(),"Email Address",emailAddress);

        try {
            com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        } catch (StaleElementReferenceException e) {
            //com.clickElement(driver,hp.getSignup_login(),"Signup/Login");
        }
        if(com.isVisibleOnPageRemote(driver,sp.getEnterAccountInformationLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Enter Account Information is Visible");
            Assert.assertTrue(true,"\"Enter Account Information\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Enter Account Information is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("\"Enter Account Information\" is not Visible");
        }
        if(strTitle.equalsIgnoreCase("mr")){
            com.clickElementRemote(driver,sp.getTitleMr(),"Mr Title");
        }else{
            com.clickElementRemote(driver,sp.getTitleMr(),"Mr Title");
        }

        com.typeRemote(driver,sp.getPassWord(),"Password",strPassword);
        try {
            com.clickElementRemote(driver,sp.getDays(),"Days Combo Box");
            com.selectByTextRemote(driver,sp.getDays(),"Days",strDay);
        }catch (DataIsNotVisible d){
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strDay+ "Enter Data Information is not Visible");
        }
        try {
            com.clickElementRemote(driver,sp.getMonths(),"Month Combo Box");
            com.selectByTextRemote(driver,sp.getMonths(),"Month",strMonth);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strMonth+ "Enter Data Information is not Visible");

        }

        try {
            com.clickElementRemote(driver,sp.getYears(),"Year Combo Box");
            com.selectByTextRemote(driver,sp.getYears(),"Year",strYear);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strYear+ "Enter Data Information is not Visible");

        }

        com.javascriptExecutorMethodRemote(driver,sp.getNewsLetterCheckBox(),"NewsLetter Checkbox");
        com.selectCheckBoxRemote(driver,sp.getNewsLetterCheckBox(),"select NewsLetter checkbox");
        com.javascriptExecutorMethodRemote(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.selectCheckBoxRemote(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.javascriptExecutorMethodRemote(driver,sp.getFirstName(),"First Name");
        com.typeRemote(driver,sp.getFirstName(),"First Name",strFirstName);
        com.javascriptExecutorMethodRemote(driver,sp.getLastName(),"Last Name");
        com.typeRemote(driver,sp.getLastName(),"Last Name",strLastName);
        com.javascriptExecutorMethodRemote(driver,sp.getCompany(),"Company");
        com.typeRemote(driver,sp.getCompany(),"Company",strCompany);
        com.javascriptExecutorMethodRemote(driver,sp.getAddress1(),"Address1");
        com.typeRemote(driver,sp.getAddress1(),"Address1",strAddress1);
        com.javascriptExecutorMethodRemote(driver,sp.getAddress2(),"Address2");
        com.typeRemote(driver,sp.getAddress2(),"Address2",strAddress2);
        com.javascriptExecutorMethodRemote(driver,sp.getCountrySelect(),"Country");
        try {
            com.clickElementRemote(driver,sp.getCountrySelect(),"Country DropDown");
            com.selectByTextRemote(driver,sp.getCountrySelect(),"Country",strCountry);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strCountry+ "Enter Data Information is not Visible");
        }
        com.javascriptExecutorMethodRemote(driver,sp.getState(),"State");
        com.typeRemote(driver,sp.getState(),"State",strState);
        com.javascriptExecutorMethodRemote(driver,sp.getCity(),"City");
        com.typeRemote(driver,sp.getCity(),"City",strCity);
        com.javascriptExecutorMethodRemote(driver,sp.getZipCode(),"Zipcode");
        com.typeRemote(driver,sp.getZipCode(),"Zipcode",strZipcode);
        com.javascriptExecutorMethodRemote(driver,sp.getMobileNumber(),"MobileNumber");
        com.typeRemote(driver,sp.getMobileNumber(),"MobileNumber",strMobileNumber);
        com.javascriptExecutorMethodRemote(driver,sp.getCreateAccountButton(),"Create Account Button");
        com.clickElementRemote(driver,sp.getCreateAccountButton(),"Create Account button");
        if(com.isVisibleOnPageRemote(driver,acp.getAccountCreatedLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Account Create! Label is Visible");
            Assert.assertTrue(true,"\"Account Create!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Account Create! Label is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("\"Account Create!\" is not Visible");
        }
        com.clickElementRemote(driver,acp.getContinueBtn(),"continue button");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list1=driver.findElements(By.xpath("//iframe[@id='aswift_1']"));
        if(!list1.isEmpty()){
            com.switchToFrameID(driver,"aswift_1");
            System.out.println("Switched to first Frame");
            if(!list1.isEmpty()){
                List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list3.isEmpty()){
                    if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                        if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                            System.out.println("Switched to Close Button");
                            com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                        }
                    }
                }

                //act.moveToElement(element3).build().perform();

            }

            List<WebElement> list2=driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
            if(!list2.isEmpty()){
                // driver.manage().window().fullscreen();
                com.switchToFrameID(driver,"ad_iframe");
                System.out.println("Switched to second frame");
                list1=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list1.isEmpty()){
                    List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                    if(!list3.isEmpty()){
                        if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                            if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                                System.out.println("Switched to Close Button inside Frame2");
                                com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                            }
                        }
                    }

                    //act.moveToElement(element3).build().perform();

                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("switching from Second frame");
                driver.switchTo().defaultContent();

            }
            System.out.println("switching from Second frame");
            driver.switchTo().defaultContent();

        }


        // driver.manage().window().maximize();
        if(com.isVisibleOnPageRemote(driver,hp.getLoggedInAsUsername())){
            driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B>"+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>\"Logged in as \" </B>is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("\"Logged in as \" is not Visible");

        }
        com.clickElementRemote(driver,hp.getLogout(),"Logout link");
        driver.manage().window().maximize();
        com.clickElementRemote(driver,hp.getHomeLink(),"Home Page Link");
        driver.manage().window().maximize();

        //**************Test Case 2 is Starting Here ***********************************************************************************//


        list1=driver.findElements(hp.getTestCases());

        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        com.clickElementRemote(driver,hp.getSignUp_Login(),"Signup/Login");
        list1=driver.findElements(lp.getLogintoYourAccount());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Login to your account label is visible");
            Assert.assertTrue(true,"Login to your account label is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Login to your account label is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Login to your account label is not visible");
        }
        com.typeRemote(driver,lp.getEmail(),"EmailAddress",emailAddress);
        com.typeRemote(driver,lp.getPassword(),"password",strPassword);
        com.clickElementRemote(driver,lp.getLoginButton(),"Login Button");

        if(com.isVisibleOnPageRemote(driver,hp.getLoggedInAsUsername())){
            driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B> "+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            test.fail("<B>\"Logged in as \" </B>is not Visible");
            Assert.fail("\"Logged in as \" is not Visible");

        }
        com.clickElementRemote(driver,hp.getDeleteAccount(),"Delete Account Link");
        if(com.isVisibleOnPageRemote(driver,adp.getAccountDeletedLabel())){
            // driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("\"Account Deleted!\" is Visible");
            Assert.assertTrue(true,"\"Account Deleted!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("\"Account Deleted!\" is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("\"Account Deleted!\" is not Visible");
        }
        com.javascriptExecutorMethodRemote(driver,adp.getContinueBtn(),"Continue Button");
        com.clickElementRemote(driver,adp.getContinueBtn(),"Continue Button");

    }


    public void TestCase3(WebDriver driver,String strworkbookname,String strsheetName,String strTestCaseName,String strEmailAddress,String strPassword){


        List<WebElement>list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        try {
            com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        } catch (StaleElementReferenceException e) {
            //com.clickElement(driver,hp.getSignup_login(),"Signup/Login");
        }
        list1=driver.findElements(lp.getLogintoYourAccount());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Login to your account label is visible");
            Assert.assertTrue(true,"Login to your account label is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Login to your account label is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Login to your account label is not visible");
        }
        String strEmail,strPass;
        TestDataReader writer=new TestDataReader();
        try {
            strEmail= writer.readFromTestDataSheet(strworkbookname,strsheetName,strTestCaseName,strEmailAddress);
        }catch (InvalidFormatException|IOException e) {
            throw new RuntimeException(e);
        }

        try {
            strPass= writer.readFromTestDataSheet(strworkbookname,strsheetName,strTestCaseName,strPassword);
        }catch (InvalidFormatException|IOException e) {
            throw new RuntimeException(e);
        }

        com.type(driver,lp.getEmail(),"EmailAddress",strEmail);
        com.type(driver,lp.getPassword(),"password",strPass);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        com.clickElement(driver,lp.getLoginButton(),"Login Button");
        if(com.isVisibleOnPage(driver,lp.getLoginIncorrectMessage())){
            String errormessage=driver.findElement(lp.getLoginIncorrectMessage()).getText();
            ExtentTestManager.getInstance(test).getTest().pass("<B>"+errormessage+"</B> message is visible");
            Assert.assertTrue(true,errormessage+" message is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Error message is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Error message is not visible");
        }
    }

    public void TestCase3Remote(RemoteWebDriver driver,String strWorkBook,String strSheet,String testcaseName,String strEmailAddress,String strPassword){


        List<WebElement>list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        try {
            com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        } catch (StaleElementReferenceException e) {
           // com.clickElement(driver,hp.getSignup_login(),"Signup/Login");
        }
        list1=driver.findElements(lp.getLogintoYourAccount());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Login to your account label is visible");
            Assert.assertTrue(true,"Login to your account label is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Login to your account label is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Login to your account label is not visible");
        }
        com.typeRemote(driver,lp.getEmail(),"EmailAddress",strEmailAddress);
        com.typeRemote(driver,lp.getPassword(),"password",strPassword);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        com.clickElementRemote(driver,lp.getLoginButton(),"Login Button");
        if(com.isVisibleOnPageRemote(driver,lp.getLoginIncorrectMessage())){
            String errormessage=driver.findElement(lp.getLoginIncorrectMessage()).getText();
            ExtentTestManager.getInstance(test).getTest().pass("<B>"+errormessage+"</B> message is visible");
            Assert.assertTrue(true,errormessage+" message is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Error message is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Error message is not visible");
        }
    }


    public void TestCase4(WebDriver driver,String strName,String strEmailAddress,
                          String strTitle,String strPassword,String strDay,String strMonth,String strYear,String strFirstName,String strLastName,
                          String strCompany,String strAddress1,String strAddress2,String strCountry,String strState,String strCity,String strZipcode,
                          String strMobileNumber){


        //**************************Pre Requisite for Test Case2 *********************************************//
        // Account is Getting Created First and this Account will be used for Test Case2 Test Cases
        Actions act=new Actions(driver);
        List<WebElement> list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        if(com.isVisibleOnPage(driver,lp.getNewUserSignInLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("New User is visible");
            Assert.assertTrue(true,"New User Signup! is visible");
        }else {
            ExtentTestManager.getInstance(test).getTest().fail("New User Signup is not Visible");
            Assert.fail("New User Signup! is not visible");
        }
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100000);
        String usernameEntered=strName+rand_int1;
        com.type(driver,lp.getName(),"Name",usernameEntered);
        String emailAddress=strEmailAddress+rand_int1+"@gmail.com";
        com.type(driver,lp.getEmailAddress(),"Email Address",emailAddress);

        try {
            com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        } catch (StaleElementReferenceException e) {
            //com.clickElement(driver,hp.getSignup_login(),"Signup/Login");
        }
        if(com.isVisibleOnPage(driver,sp.getEnterAccountInformationLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Enter Account Information is Visible");
            Assert.assertTrue(true,"\"Enter Account Information\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Enter Account Information is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("\"Enter Account Information\" is not Visible");
        }
        if(strTitle.equalsIgnoreCase("mr")){
            com.clickElement(driver,sp.getTitleMr(),"Mr Title");
        }else{
            com.clickElement(driver,sp.getTitleMr(),"Mr Title");
        }

        com.type(driver,sp.getPassWord(),"Password",strPassword);
        com.javascriptExecutorMethod(driver,sp.getDays(),"Days Checkbox");
        try {
            com.clickElement(driver,sp.getDays(),"Days Combo Box");
            com.selectByText(driver,sp.getDays(),"Days",strDay);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strDay+ "Enter Data Information is not Visible");
        }
        try {
            com.clickElement(driver,sp.getMonths(),"Month Combo Box");
            com.selectByText(driver,sp.getMonths(),"Month",strMonth);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strMonth+ "Enter Data Information is not Visible");
        }
        try {
            com.clickElement(driver,sp.getYears(),"Year Combo Box");
            com.selectByText(driver,sp.getYears(),"Year",strYear);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strYear+ "Enter Data Information is not Visible");
        }
        com.javascriptExecutorMethod(driver,sp.getNewsLetterCheckBox(),"NewsLetter Checkbox");
        com.selectCheckBox(driver,sp.getNewsLetterCheckBox(),"select NewsLetter checkbox");
        com.javascriptExecutorMethod(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.selectCheckBox(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.javascriptExecutorMethod(driver,sp.getFirstName(),"First Name");
        com.type(driver,sp.getFirstName(),"First Name",strFirstName);
        com.javascriptExecutorMethod(driver,sp.getLastName(),"Last Name");
        com.type(driver,sp.getLastName(),"Last Name",strLastName);
        com.javascriptExecutorMethod(driver,sp.getCompany(),"Company");
        com.type(driver,sp.getCompany(),"Company",strCompany);
        com.javascriptExecutorMethod(driver,sp.getAddress1(),"Address1");
        com.type(driver,sp.getAddress1(),"Address1",strAddress1);
        com.javascriptExecutorMethod(driver,sp.getAddress2(),"Address2");
        com.type(driver,sp.getAddress2(),"Address2",strAddress2);
        com.javascriptExecutorMethod(driver,sp.getCountrySelect(),"Country");
        try {
            com.clickElement(driver,sp.getCountrySelect(),"Country combo box");
            com.selectByText(driver,sp.getCountrySelect(),"Country",strCountry);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strCountry+ "Enter Data Information is not Visible");
        }
        com.javascriptExecutorMethod(driver,sp.getState(),"State");
        com.type(driver,sp.getState(),"State",strState);
        com.javascriptExecutorMethod(driver,sp.getCity(),"City");
        com.type(driver,sp.getCity(),"City",strCity);
        com.javascriptExecutorMethod(driver,sp.getZipCode(),"Zipcode");
        com.type(driver,sp.getZipCode(),"Zipcode",strZipcode);
        com.javascriptExecutorMethod(driver,sp.getMobileNumber(),"MobileNumber");
        com.type(driver,sp.getMobileNumber(),"MobileNumber",strMobileNumber);
        com.javascriptExecutorMethod(driver,sp.getCreateAccountButton(),"Create Account Button");
        com.clickElement(driver,sp.getCreateAccountButton(),"Create Account button");
        if(com.isVisibleOnPage(driver,acp.getAccountCreatedLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Account Create! Label is Visible");
            Assert.assertTrue(true,"\"Account Create!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Account Create! Label is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("\"Account Create!\" is not Visible");
        }
        com.clickElement(driver,acp.getContinueBtn(),"continue button");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        list1=driver.findElements(By.xpath("//iframe[@id='aswift_1']"));
        if(!list1.isEmpty()){
            com.switchToFrameID(driver,"aswift_1");
            System.out.println("Switched to first Frame");
            if(!list1.isEmpty()){
                List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list3.isEmpty()){
                    if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                        if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                            System.out.println("Switched to Close Button");
                            com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                        }
                    }
                }

                //act.moveToElement(element3).build().perform();

            }

            List<WebElement> list2=driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
            if(!list2.isEmpty()){
                // driver.manage().window().fullscreen();
                com.switchToFrameID(driver,"ad_iframe");
                System.out.println("Switched to second frame");
                list1=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list1.isEmpty()){
                    List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                    if(!list3.isEmpty()){
                        if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                            if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                                System.out.println("Switched to Close Button inside Frame2");
                                com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                            }
                        }
                    }

                    //act.moveToElement(element3).build().perform();

                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("switching from Second frame");
                driver.switchTo().defaultContent();

            }
            System.out.println("switching from Second frame");
            driver.switchTo().defaultContent();

        }
        if(com.isVisibleOnPage(driver,hp.getLoggedInAsUsername())){
            //driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B>"+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>\"Logged in as \" </B>is not Visible");
            Assert.fail("\"Logged in as \" is not Visible");

        }
        com.clickElement(driver,hp.getLogout(),"Logout link");
        driver.manage().window().maximize();

        com.clickElement(driver,hp.getHomeLink(),"Home Page Link");
        driver.manage().window().maximize();

        //**************Test Case 2 is Starting Here ***********************************************************************************//


        list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        try {
            com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        } catch (StaleElementReferenceException e) {
           // com.clickElement(driver,hp.getSignup_login(),"Signup/Login");
        }
        list1=driver.findElements(lp.getLogintoYourAccount());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Login to your account label is visible");
            Assert.assertTrue(true,"Login to your account label is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Login to your account label is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Login to your account label is not visible");
        }
        com.type(driver,lp.getEmail(),"EmailAddress",emailAddress);
        com.type(driver,lp.getPassword(),"password",strPassword);
        com.clickElement(driver,lp.getLoginButton(),"Login Button");

        if(com.isVisibleOnPage(driver,hp.getLoggedInAsUsername())){
            driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B> "+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>\"Logged in as \" </B>is not Visible");
            Assert.fail("\"Logged in as \" is not Visible");

        }

        com.clickElement(driver,hp.getLogout(),"Logout link");
        list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshot(driver)).build());
            Assert.fail("Home Page is not visible");
        }



    }
    public void TestCase4Remote(RemoteWebDriver driver,String strName,String strEmailAddress,
                          String strTitle,String strPassword,String strDay,String strMonth,String strYear,String strFirstName,String strLastName,
                          String strCompany,String strAddress1,String strAddress2,String strCountry,String strState,String strCity,String strZipcode,
                          String strMobileNumber){


        //**************************Pre Requisite for Test Case2 *********************************************//
        // Account is Getting Created First and this Account will be used for Test Case2 Test Cases
        Actions act=new Actions(driver);
        List<WebElement> list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        try {
            com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        } catch (StaleElementReferenceException e) {
            //com.clickElement(driver,hp.getSignup_login(),"Signup/Login");
        }
        if(com.isVisibleOnPageRemote(driver,lp.getNewUserSignInLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("New User is visible");
            Assert.assertTrue(true,"New User Signup! is visible");
        }else {
            ExtentTestManager.getInstance(test).getTest().fail("New User Signup is not Visible");
            Assert.fail("New User Signup! is not visible");
        }
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100000);
        String usernameEntered=strName+rand_int1;
        com.typeRemote(driver,lp.getName(),"Name",usernameEntered);
        String emailAddress=strEmailAddress+rand_int1+"@gmail.com";
        com.typeRemote(driver,lp.getEmailAddress(),"Email Address",emailAddress);

        com.clickElementRemote(driver,lp.getSignUp(),"Sign up button");
        if(com.isVisibleOnPageRemote(driver,sp.getEnterAccountInformationLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Enter Account Information is Visible");
            Assert.assertTrue(true,"\"Enter Account Information\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Enter Account Information is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("\"Enter Account Information\" is not Visible");
        }
        if(strTitle.equalsIgnoreCase("mr")){
            com.clickElementRemote(driver,sp.getTitleMr(),"Mr Title");
        }else{
            com.clickElementRemote(driver,sp.getTitleMr(),"Mr Title");
        }

        com.typeRemote(driver,sp.getPassWord(),"Password",strPassword);

        try {
            com.clickElementRemote(driver,sp.getDays(),"Days combo box");
            com.selectByTextRemote(driver,sp.getDays(),"Days",strDay);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strDay+ "Enter Data Information is not Visible");
        }

        try {
            com.clickElementRemote(driver,sp.getMonths(),"Month combo box");
            com.selectByTextRemote(driver,sp.getMonths(),"Month",strMonth);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strMonth+ "Enter Data Information is not Visible");
        }

        try {
            com.clickElementRemote(driver,sp.getYears(),"Year combo box");
            com.selectByTextRemote(driver,sp.getYears(),"Year",strYear);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strYear+ "Enter Data Information is not Visible");
        }


        com.javascriptExecutorMethodRemote(driver,sp.getNewsLetterCheckBox(),"NewsLetter Checkbox");
        com.selectCheckBoxRemote(driver,sp.getNewsLetterCheckBox(),"select NewsLetter checkbox");
        com.javascriptExecutorMethodRemote(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.selectCheckBoxRemote(driver,sp.getOfferCheckBox(),"select offer checkbox");
        com.javascriptExecutorMethodRemote(driver,sp.getFirstName(),"First Name");
        com.typeRemote(driver,sp.getFirstName(),"First Name",strFirstName);
        com.javascriptExecutorMethodRemote(driver,sp.getLastName(),"Last Name");
        com.typeRemote(driver,sp.getLastName(),"Last Name",strLastName);
        com.javascriptExecutorMethodRemote(driver,sp.getCompany(),"Company");
        com.typeRemote(driver,sp.getCompany(),"Company",strCompany);
        com.javascriptExecutorMethodRemote(driver,sp.getAddress1(),"Address1");
        com.typeRemote(driver,sp.getAddress1(),"Address1",strAddress1);
        com.javascriptExecutorMethodRemote(driver,sp.getAddress2(),"Address2");
        com.typeRemote(driver,sp.getAddress2(),"Address2",strAddress2);
        com.javascriptExecutorMethodRemote(driver,sp.getCountrySelect(),"Country");

        try {
            com.clickElementRemote(driver,sp.getMonths(),"Country combo box");
            com.selectByTextRemote(driver,sp.getCountrySelect(),"Country",strCountry);
        } catch (DataIsNotVisible e) {
            ExtentTestManager.getInstance(test).getTest().fail("Enter Data Information is not Visible");
            Assert.fail(strCountry+ "Enter Data Information is not Visible");
        }

        com.javascriptExecutorMethodRemote(driver,sp.getState(),"State");
        com.typeRemote(driver,sp.getState(),"State",strState);
        com.javascriptExecutorMethodRemote(driver,sp.getCity(),"City");
        com.typeRemote(driver,sp.getCity(),"City",strCity);
        com.javascriptExecutorMethodRemote(driver,sp.getZipCode(),"Zipcode");
        com.typeRemote(driver,sp.getZipCode(),"Zipcode",strZipcode);
        com.javascriptExecutorMethodRemote(driver,sp.getMobileNumber(),"MobileNumber");
        com.typeRemote(driver,sp.getMobileNumber(),"MobileNumber",strMobileNumber);
        com.javascriptExecutorMethodRemote(driver,sp.getCreateAccountButton(),"Create Account Button");
        com.clickElementRemote(driver,sp.getCreateAccountButton(),"Create Account button");
        if(com.isVisibleOnPageRemote(driver,acp.getAccountCreatedLabel())){
            driver.manage().window().maximize();
            ExtentTestManager.getInstance(test).getTest().pass("Account Create! Label is Visible");
            Assert.assertTrue(true,"\"Account Create!\" is Visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Account Create! Label is not Visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("\"Account Create!\" is not Visible");
        }
        com.clickElementRemote(driver,acp.getContinueBtn(),"continue button");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        list1=driver.findElements(By.xpath("//iframe[@id='aswift_1']"));
        if(!list1.isEmpty()){
            com.switchToFrameID(driver,"aswift_1");
            System.out.println("Switched to first Frame");
            if(!list1.isEmpty()){
                List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list3.isEmpty()){
                    if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                        if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                            System.out.println("Switched to Close Button");
                            com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                        }
                    }
                }

                //act.moveToElement(element3).build().perform();

            }

            List<WebElement> list2=driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
            if(!list2.isEmpty()){
                // driver.manage().window().fullscreen();
                com.switchToFrameID(driver,"ad_iframe");
                System.out.println("Switched to second frame");
                list1=driver.findElements(acp.getDownloadpagedismisslink());
                if(!list1.isEmpty()){
                    List<WebElement> list3=driver.findElements(acp.getDownloadpagedismisslink());
                    if(!list3.isEmpty()){
                        if(driver.findElement(acp.getDownloadpagedismisslink()).isDisplayed()){
                            if(com.isVisibleOnPage(driver,acp.getDownloadpagedismisslink())){
                                System.out.println("Switched to Close Button inside Frame2");
                                com.clickElement(driver,acp.getDownloadpagedismisslink(),"dismiss download page");
                            }
                        }
                    }

                    //act.moveToElement(element3).build().perform();

                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("switching from Second frame");
                driver.switchTo().defaultContent();

            }
            System.out.println("switching from Second frame");
            driver.switchTo().defaultContent();

        }

        if(com.isVisibleOnPageRemote(driver,hp.getLoggedInAsUsername())){
            //driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B>"+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>\"Logged in as \" </B>is not Visible");
            Assert.fail("\"Logged in as \" is not Visible");

        }
        com.clickElementRemote(driver,hp.getLogout(),"Logout link");
        driver.manage().window().maximize();

        com.clickElementRemote(driver,hp.getHomeLink(),"Home Page Link");
        driver.manage().window().maximize();

        //**************Test Case 2 is Starting Here ***********************************************************************************//


        list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Home Page is not visible");
        }
        try {
            com.clickElement(driver,hp.getSignUp_Login(),"Signup/Login");
        } catch (StaleElementReferenceException e) {
           // com.clickElement(driver,hp.getSignup_login(),"Signup/Login");
        }
        list1=driver.findElements(lp.getLogintoYourAccount());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Login to your account label is visible");
            Assert.assertTrue(true,"Login to your account label is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Login to your account label is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Login to your account label is not visible");
        }
        com.typeRemote(driver,lp.getEmail(),"EmailAddress",emailAddress);
        com.typeRemote(driver,lp.getPassword(),"password",strPassword);
        com.clickElementRemote(driver,lp.getLoginButton(),"Login Button");

        if(com.isVisibleOnPageRemote(driver,hp.getLoggedInAsUsername())){
            driver.manage().window().maximize();
            String username=driver.findElement(hp.getLoggedInAsUsername()).getText();
            if(username.equals(usernameEntered)){
                ExtentTestManager.getInstance(test).getTest().pass("\"Logged in as \"<B> "+username+" </B>is Visible");
                Assert.assertTrue(true,"\"Logged in as \"<B> "+username+" </B>is Visible");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("\"Logged in as \"<B> "+username+" </B>is not Visible");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
                Assert.fail("\"Logged in as \" "+username+" is not Visible");
            }

        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>\"Logged in as \" </B>is not Visible");
            Assert.fail("\"Logged in as \" is not Visible");

        }

        com.clickElementRemote(driver,hp.getLogout(),"Logout link");
        list1=driver.findElements(hp.getTestCases());
        if(!list1.isEmpty()){
            ExtentTestManager.getInstance(test).getTest().pass("Home Page is visible");
            Assert.assertTrue(true,"Home Page is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("Home Page is not visible");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+CommonResuableMethods.getScreenshotRemote(driver)).build());
            Assert.fail("Home Page is not visible");
        }



    }


}
