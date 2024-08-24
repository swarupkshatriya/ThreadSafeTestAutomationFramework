package VehicalInsuranceApplication;

import org.openqa.selenium.By;

public class AutomobileClass {
    public By automobileLink= By.xpath("(//a[@id='nav_automobile'])[1]");
    public By makeLabel=By.xpath("//label[contains(text(),'Make')]");
    public By makeComBoBox=By.xpath("//select[@id='make']");
    public By enginePerformanceKW=By.xpath("//input[@id='engineperformance']");
    public By dateOfManufacturing=By.xpath("//input[@id='dateofmanufacture']");
    public By selectNumberOfSeats=By.xpath("//select[@id='numberofseats']");
    public By fuelType=By.xpath("//select[@id='fuel']");
    public By listPrice=By.xpath("//input[@id='listprice']");
    public By licensePlateNumber=By.xpath("//input[@id='licenseplatenumber']");
    public By AnualMilege=By.xpath("//input[@id='annualmileage']");
    public By nextButton=By.xpath("//button[@id='nextenterinsurantdata']");
    public By firstNameTextField=By.xpath("//input[@id='firstname']");
    public By lastNameTextField=By.xpath("//input[@id='lastname']");
    public By dateOfBirthTextField=By.xpath("//input[@id='birthdate']");
    public By genderMaleRadioButton=By.xpath("//label[text()='Male']");
    public By genFemaleRadioButton=By.xpath("//label[text()='Female']");
    public By stressAddressTextField=By.xpath("//input[@id='streetaddress']");
    public By countrySelectDropDown=By.xpath("//select[@id='country']");
    public By zipCode=By.xpath("//input[@id='zipcode']");
    public By cityTextField=By.xpath("//input[@name='City']");
    public By occupationDropDown=By.xpath("//select[@id='occupation']");
    public By speeadingCheckBox=By.xpath("//label[text()=' Speeding']");
    public By bungeeJumpingCheckBox=By.xpath("//label[text()='bungeejumping']");
    public By cliffDivingCheckBox=By.xpath("//label[text()='cliffdiving']");
    public By skydivingCheckBox=By.xpath("//label[text()='skydiving']");
    public By otherCheckBox=By.xpath("//input[@id='other']");
    public By webSiteTextfield=By.xpath("//input[@id='website']");
    public By openButton=By.xpath("//button[@id='open']");
    public By previousButton=By.xpath("//button[@id='preventervehicledata']");
    public By nextbuttonProductData=By.xpath("//button[@id='nextenterproductdata']");
    public By productdataStartDate=By.xpath("//input[@id='startdate']");
    public By productDataInsuranceSumDropDown=By.xpath("//select[@id='insurancesum']");
    public By productDataMeritRating=By.xpath("//select[@id='meritrating']");
    public By productDataDamageInsurance=By.xpath("//select[@id='damageinsurance']");
    public By productDataOptionalProudctsEuroProtectionCheckBox=By.xpath("//label[text()='Euro Protection']");
    public By productDataLegalDefenseInsuranceCheckBox=By.xpath("//label[text()='Legal Defense Insurance']");
    public By productDataCurtesyCarDropDown=By.xpath("//select[@id='courtesycar']");
    public By productDataPreviousInsuranceDataButton=By.xpath("//button[@id='preventerinsurancedata']");
    public By productDataNextSelectPriceOptionButton=By.xpath("//button[@id='nextselectpriceoption']");
    public By selectPriceOptionSilverRadioButton=By.xpath("(//input[@id='selectsilver'])//..");
    public By selectPriceOptionGoldRadioButton=By.xpath("(//input[@id='selectgold'])//..");
    public By selectPriceOptionPlatinumRadioButton=By.xpath("(//input[@id='selectplatinum'])//..");
    public By selectPriceOptionUltimateRadioButton=By.xpath("(//input[@id='selectultimate'])//..");
    public By selectPriceOptionViewQuoteLink=By.xpath("//a[@name='View Quote']");
    public By selectPriceOptionDownloadQuoteLink=By.xpath("//a[@name='Download Quote']");
    public By selectPriceOpitonPreviouButton=By.xpath("//button[@id='preventerproductdata']");
    public By selectPriceOptionNextButton=By.xpath("//button[@id='nextsendquote']");
    public By sendQuoteEmailTextField=By.xpath("//label[text()='E-Mail']//following::input[1]");
    public By sendQuotePhoneTextField=By.xpath("//input[@id='phone']");
    public By sendQuoteUsernameTextField=By.xpath("//input[@id='username']");
    public By sendQuotePasswordTextField=By.xpath("//input[@id='password']");
    public By sendQuoteConfirmPasswordTextField=By.xpath("//input[@id='confirmpassword']");
    public By sendQuoteCommentTextArea=By.xpath("//textarea[@id='Comments']");
    public By sendQuotePreviousSelectPriceOptionButton=By.xpath("//button[@id='prevselectpriceoption']");
    public By sendQuoteSendQuoteButton=By.xpath("//button[@id='sendemail']");
    public By sendingEmailNotification=By.xpath("//h2[text()='Sending e-mail success!']");
    public By okButton=By.xpath("//button[text()='OK']");

    public By getCityTextField() {
        return cityTextField;
    }

    public By getGenderMaleRadioButton() {
        return genderMaleRadioButton;
    }

    public By getGenFemaleRadioButton() {
        return genFemaleRadioButton;
    }

    public By getNextButton() {
        return nextButton;
    }

    public By getFirstNameTextField() {
        return firstNameTextField;
    }

    public By getLastNameTextField() {
        return lastNameTextField;
    }

    public By getDateOfBirthTextField() {
        return dateOfBirthTextField;
    }

    public By getStressAddressTextField() {
        return stressAddressTextField;
    }

    public By getCountrySelectDropDown() {
        return countrySelectDropDown;
    }

    public By getZipCode() {
        return zipCode;
    }

    public By getOccupationDropDown() {
        return occupationDropDown;
    }

    public By getSpeeadingCheckBox() {
        return speeadingCheckBox;
    }

    public By getBungeeJumpingCheckBox() {
        return bungeeJumpingCheckBox;
    }

    public By getCliffDivingCheckBox() {
        return cliffDivingCheckBox;
    }

    public By getSkydivingCheckBox() {
        return skydivingCheckBox;
    }

    public By getOtherCheckBox() {
        return otherCheckBox;
    }

    public By getWebSiteTextfield() {
        return webSiteTextfield;
    }

    public By getOpenButton() {
        return openButton;
    }

    public By getPreviousButton() {
        return previousButton;
    }

    public By getNextbuttonProductData() {
        return nextbuttonProductData;
    }

    public By getProductdataStartDate() {
        return productdataStartDate;
    }

    public By getProductDataInsuranceSumDropDown() {
        return productDataInsuranceSumDropDown;
    }

    public By getProductDataMeritRating() {
        return productDataMeritRating;
    }

    public By getProductDataDamageInsurance() {
        return productDataDamageInsurance;
    }

    public By getProductDataOptionalProudctsEuroProtectionCheckBox() {
        return productDataOptionalProudctsEuroProtectionCheckBox;
    }

    public By getProductDataLegalDefenseInsuranceCheckBox() {
        return productDataLegalDefenseInsuranceCheckBox;
    }

    public By getProductDataCurtesyCarDropDown() {
        return productDataCurtesyCarDropDown;
    }

    public By getProductDataPreviousInsuranceDataButton() {
        return productDataPreviousInsuranceDataButton;
    }

    public By getProductDataNextSelectPriceOptionButton() {
        return productDataNextSelectPriceOptionButton;
    }

    public By getSelectPriceOptionSilverRadioButton() {
        return selectPriceOptionSilverRadioButton;
    }

    public By getSelectPriceOptionGoldRadioButton() {
        return selectPriceOptionGoldRadioButton;
    }

    public By getSelectPriceOptionPlatinumRadioButton() {
        return selectPriceOptionPlatinumRadioButton;
    }

    public By getSelectPriceOptionUltimateRadioButton() {
        return selectPriceOptionUltimateRadioButton;
    }

    public By getSelectPriceOptionViewQuoteLink() {
        return selectPriceOptionViewQuoteLink;
    }

    public By getSelectPriceOptionDownloadQuoteLink() {
        return selectPriceOptionDownloadQuoteLink;
    }

    public By getSelectPriceOpitonPreviouButton() {
        return selectPriceOpitonPreviouButton;
    }

    public By getSelectPriceOptionNextButton() {
        return selectPriceOptionNextButton;
    }

    public By getSendQuoteEmailTextField() {
        return sendQuoteEmailTextField;
    }

    public By getSendQuotePhoneTextField() {
        return sendQuotePhoneTextField;
    }

    public By getSendQuoteUsernameTextField() {
        return sendQuoteUsernameTextField;
    }

    public By getSendQuotePasswordTextField() {
        return sendQuotePasswordTextField;
    }

    public By getSendQuoteConfirmPasswordTextField() {
        return sendQuoteConfirmPasswordTextField;
    }

    public By getSendQuoteCommentTextArea() {
        return sendQuoteCommentTextArea;
    }

    public By getSendQuotePreviousSelectPriceOptionButton() {
        return sendQuotePreviousSelectPriceOptionButton;
    }

    public By getSendQuoteSendQuoteButton() {
        return sendQuoteSendQuoteButton;
    }

    public By getSendingEmailNotification() {
        return sendingEmailNotification;
    }

    public By getOkButton() {
        return okButton;
    }

    public By getAutomobileLink() {
        return automobileLink;
    }

    public By getMakeLabel() {
        return makeLabel;
    }

    public By getMakeComBoBox() {
        return makeComBoBox;
    }

    public By getEnginePerformanceKW() {
        return enginePerformanceKW;
    }

    public By getDateOfManufacturing() {
        return dateOfManufacturing;
    }

    public By getSelectNumberOfSeats() {
        return selectNumberOfSeats;
    }

    public By getFuelType() {
        return fuelType;
    }

    public By getListPrice() {
        return listPrice;
    }

    public By getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public By getAnualMilege() {
        return AnualMilege;
    }
}
