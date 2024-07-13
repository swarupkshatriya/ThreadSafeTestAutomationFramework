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
