package AutomationExcercise;

import org.openqa.selenium.By;

public class LoginPage {
    public By newUserSignInLabel= By.xpath("//h2[text()='New User Signup!']");
    public By name=By.xpath("//input[@name='name']");
    public By emailAddress=By.xpath("(//input[@name='email'])[2]");
    public By logintoYourAccount=By.xpath("//h2[text()='Login to your account']");
    public By email=By.xpath("(//input[@name='email'])[1]");
    public By password=By.xpath("(//input[@name='password'])[1]");
    public By signUp=By.xpath("//button[text()='Signup']");
    public By loginButton=By.xpath("(//button[text()='Login'])[1]");
    public By loginIncorrectMessage=By.xpath("//p[text()='Your email or password is incorrect!']");

    public By getLoginIncorrectMessage() {
        return loginIncorrectMessage;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getNewUserSignInLabel() {
        return newUserSignInLabel;
    }

    public void setNewUserSignInLabel(By newUserSignInLabel) {
        this.newUserSignInLabel = newUserSignInLabel;
    }

    public By getName() {
        return name;
    }

    public void setName(By name) {
        this.name = name;
    }

    public By getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(By emailAddress) {
        this.emailAddress = emailAddress;
    }

    public By getLogintoYourAccount() {
        return logintoYourAccount;
    }

    public void setLogintoYourAccount(By logintoYourAccount) {
        this.logintoYourAccount = logintoYourAccount;
    }

    public By getEmail() {
        return email;
    }

    public void setEmail(By email) {
        this.email = email;
    }

    public By getPassword() {
        return password;
    }

    public void setPassword(By password) {
        this.password = password;
    }

    public By getSignUp() {
        return signUp;
    }

    public void setSignUp(By signUp) {
        this.signUp = signUp;
    }
}
