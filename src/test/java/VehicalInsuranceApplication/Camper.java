package VehicalInsuranceApplication;

import org.openqa.selenium.By;

public class Camper extends Truck{
    public By camperLink= By.xpath("(//a[@id='nav_camper'])[1]");
    public By rightHadDriverYesRadioButton=By.xpath("//label[text()='Yes']");
    public By rightHandDriverNoRadioButton=By.xpath("//label[text()='No']");

    public By getCamperLink() {
        return camperLink;
    }

    public By getRightHadDriverYesRadioButton() {
        return rightHadDriverYesRadioButton;
    }

    public By getRightHandDriverNoRadioButton() {
        return rightHandDriverNoRadioButton;
    }
}
