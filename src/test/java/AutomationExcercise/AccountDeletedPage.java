package AutomationExcercise;

import org.openqa.selenium.By;

public class AccountDeletedPage {

    public By accountDeletedLabel= By.xpath("//b[text()='Account Deleted!']");
    public By continueBtn=By.xpath("//a[text()='Continue']");


    public By getAccountDeletedLabel() {
        return accountDeletedLabel;
    }

    public By getContinueBtn() {
        return continueBtn;
    }

    public AccountDeletedPage() {
    }
}
