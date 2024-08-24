package VehicalInsuranceApplication;

import org.openqa.selenium.By;

public class Truck extends AutomobileClass{

    public By truckLink= By.xpath("(//a[@id='nav_truck'])[1]");
    public By payLoad=By.xpath("//input[@id='payload']");
    public By totalWeight=By.xpath("//input[@id='totalweight']");

    public By getTruckLink() {
        return truckLink;
    }

    public By getPayLoad() {
        return payLoad;
    }

    public By getTotalWeight() {
        return totalWeight;
    }
}
