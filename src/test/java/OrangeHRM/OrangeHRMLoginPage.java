package OrangeHRM;

import org.openqa.selenium.By;

public class OrangeHRMLoginPage {
    public By userNameTextField= By.xpath("//input[@name='username']");
    public By userPasswordTextField=By.xpath("//input[@name='password']");
    public By loginButton=By.xpath("//button[text()=' Login ']");

    public By getUserNameTextField() {
        return userNameTextField;
    }

    public By getUserPasswordTextField() {
        return userPasswordTextField;
    }

    public By getLoginButton() {
        return loginButton;
    }
}
