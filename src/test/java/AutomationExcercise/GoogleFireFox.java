package AutomationExcercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleFireFox extends UmeshPractice implements Runnable{
    @Override
    public void run() {
        try {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.google.com");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
