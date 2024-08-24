package VehicalInsuranceApplication;

import org.openqa.selenium.By;

public class MotorCycle extends  AutomobileClass {

    public By motorCycleLink= By.xpath("(//a[@id='nav_motorcycle'])[1]");
    public By model=By.xpath("//select[@id='model']");
    public By cylinderCapacity=By.xpath("//input[@id='cylindercapacity']");
    private By numberOfSeatsMotorCycle=By.xpath("//select[@id='numberofseatsmotorcycle']");

    public By getNumberOfSeatsMotorCycle() {
        return numberOfSeatsMotorCycle;
    }

    public By getMotorCycleLink() {
        return motorCycleLink;
    }

    public By getModel() {
        return model;
    }

    public By getCylinderCapacity() {
        return cylinderCapacity;
    }
}
