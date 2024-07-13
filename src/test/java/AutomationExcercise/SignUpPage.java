package AutomationExcercise;

import org.openqa.selenium.By;

public class SignUpPage {
    public By enterAccountInformationLabel= By.xpath("//b[text()='Enter Account Information']");
    public By titleMr=By.xpath("//input[@id='id_gender1']");
    public By name=By.xpath("//input[@id='name']");
    public By email=By.xpath("//input[@id='email']");
    public By passWord=By.xpath("//input[@id='password']");
    public By days=By.xpath("//select[@id='days']");
    public By months=By.xpath("//select[@id='months']");
    public By years=By.xpath("//select[@id='years']");
    public By newsLetterCheckBox=By.xpath("//input[@id='newsletter']");
    public By offerCheckBox=By.xpath("//input[@id='optin']");
    public By firstName=By.xpath("//input[@id='first_name']");
    public By lastName=By.xpath("//input[@id='last_name']");
    public By company=By.xpath("//input[@id='company']");
    public By address1=By.xpath("//input[@id='address1']");
    public By address2=By.xpath("//input[@id='address2']");
    public By countrySelect=By.xpath("//select[@id='country']");
    public By state=By.xpath("//input[@id='state']");
    public By city=By.xpath("//input[@id='city']");
    public By zipCode=By.xpath("//input[@id='zipcode']");
    public By mobileNumber=By.xpath("//input[@id='mobile_number']");
    public By createAccountButton=By.xpath("//button[text()='Create Account']");

    public By getEnterAccountInformationLabel() {
        return enterAccountInformationLabel;
    }

    public void setEnterAccountInformationLabel(By enterAccountInformationLabel) {
        this.enterAccountInformationLabel = enterAccountInformationLabel;
    }

    public By getTitleMr() {
        return titleMr;
    }

    public void setTitleMr(By titleMr) {
        this.titleMr = titleMr;
    }

    public By getName() {
        return name;
    }

    public void setName(By name) {
        this.name = name;
    }

    public By getEmail() {
        return email;
    }

    public void setEmail(By email) {
        this.email = email;
    }

    public By getPassWord() {
        return passWord;
    }

    public void setPassWord(By passWord) {
        this.passWord = passWord;
    }

    public By getDays() {
        return days;
    }

    public void setDays(By days) {
        this.days = days;
    }

    public By getMonths() {
        return months;
    }

    public void setMonths(By months) {
        this.months = months;
    }

    public By getYears() {
        return years;
    }

    public void setYears(By years) {
        this.years = years;
    }

    public By getNewsLetterCheckBox() {
        return newsLetterCheckBox;
    }

    public void setNewsLetterCheckBox(By newsLetterCheckBox) {
        this.newsLetterCheckBox = newsLetterCheckBox;
    }

    public By getOfferCheckBox() {
        return offerCheckBox;
    }

    public void setOfferCheckBox(By offerCheckBox) {
        this.offerCheckBox = offerCheckBox;
    }

    public By getFirstName() {
        return firstName;
    }

    public void setFirstName(By firstName) {
        this.firstName = firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public void setLastName(By lastName) {
        this.lastName = lastName;
    }

    public By getCompany() {
        return company;
    }

    public void setCompany(By company) {
        this.company = company;
    }

    public By getAddress1() {
        return address1;
    }

    public void setAddress1(By address1) {
        this.address1 = address1;
    }

    public By getAddress2() {
        return address2;
    }

    public void setAddress2(By address2) {
        this.address2 = address2;
    }

    public By getCountrySelect() {
        return countrySelect;
    }

    public void setCountrySelect(By countrySelect) {
        this.countrySelect = countrySelect;
    }

    public By getState() {
        return state;
    }

    public void setState(By state) {
        this.state = state;
    }

    public By getCity() {
        return city;
    }

    public void setCity(By city) {
        this.city = city;
    }

    public By getZipCode() {
        return zipCode;
    }

    public void setZipCode(By zipCode) {
        this.zipCode = zipCode;
    }

    public By getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(By mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public By getCreateAccountButton() {
        return createAccountButton;
    }

    public void setCreateAccountButton(By createAccountButton) {
        this.createAccountButton = createAccountButton;
    }
}
