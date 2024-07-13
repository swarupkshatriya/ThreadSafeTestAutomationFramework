package AutomationExcercise;

import org.openqa.selenium.By;

public class AccountCreatePage {
    public By accountCreatedLabel= By.xpath("//b[text()='Account Created!']");
    public By continueBtn=By.xpath("//a[text()='Continue']");
    public By downloadpagedismisslink=By.xpath("//div[@id='dismiss-button']");

    public By getDownloadpagedismisslink() {
        return downloadpagedismisslink;
    }
    public By getAccountCreatedLabel() {
        return accountCreatedLabel;
    }

    public By getContinueBtn() {
        return continueBtn;
    }
}
