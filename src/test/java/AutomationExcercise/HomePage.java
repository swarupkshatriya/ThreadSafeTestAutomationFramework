package AutomationExcercise;
import org.openqa.selenium.By;
public class HomePage {
    public By testCaseButton= By.xpath("(//button[text()='Test Cases'])[1]");
    public By homeLink=By.xpath("//a[text()=' Home']");
    public By products=By.xpath("//a[text()=' Products']");
    public By cart=By.xpath("//a[text()=' Cart']");
    public By signUp_Login=By.xpath("//a[text()=' Signup / Login']");
   // public By signup_login=By.xpath("//a[@href='/login']");
    public By testCases=By.xpath("//a[text()=' Test Cases']");
    public By apiTesting=By.xpath("//a[text()=' API Testing']");
    public By vedioTutorials=By.xpath("//a[text()=' Video Tutorials']");
    public By contactUS=By.xpath("//a[text()=' Contact us']");
    public By deleteAccount=By.xpath("//a[text()=' Delete Account']");
    public By logout=By.xpath("//a[text()=' Logout']");
    public By loggedInAs=By.xpath("//a[text()=' Logged in as ']");
    public By loggedInAsUsername=By.xpath("//a[text()=' Logged in as ']//following::b[1]");



    public  By getLoggedInAsUsername() {
        return loggedInAsUsername;
    }
    public  By getTestCaseButton() {
        return testCaseButton;
    }

    public void setTestCaseButton(By testCaseButton) {
        this.testCaseButton = testCaseButton;
    }

    public  By getHomeLink() {
        return homeLink;
    }

    public void setHomeLink(By homeLink) {
        this.homeLink = homeLink;
    }

    public  By getProducts() {
        return products;
    }

    public void setProducts(By products) {
        this.products = products;
    }

    public  By getCart() {
        return cart;
    }

    public void setCart(By cart) {
        this.cart = cart;
    }

    public  By getSignUp_Login() {
        return signUp_Login;
    }

    public void setSignUp_Login(By signUp_Login) {
        this.signUp_Login = signUp_Login;
    }

    public  By getTestCases() {
        return testCases;
    }

    public void setTestCases(By testCases) {
        this.testCases = testCases;
    }

    public  By getApiTesting() {
        return apiTesting;
    }

    public void setApiTesting(By apiTesting) {
        this.apiTesting = apiTesting;
    }

    public  By getVedioTutorials() {
        return vedioTutorials;
    }

    public void setVedioTutorials(By vedioTutorials) {
        this.vedioTutorials = vedioTutorials;
    }

    public  By getContactUS() {
        return contactUS;
    }

    public void setContactUS(By contactUS) {
        this.contactUS = contactUS;
    }

    public  By getDeleteAccount() {
        return deleteAccount;
    }

    public void setDeleteAccount(By deleteAccount) {
        this.deleteAccount = deleteAccount;
    }

    public  By getLogout() {
        return logout;
    }

    public void setLogout(By logout) {
        this.logout = logout;
    }

    public  By getLoggedInAs() {
        return loggedInAs;
    }

    public void setLoggedInAs(By loggedInAs) {
        this.loggedInAs = loggedInAs;
    }
}
