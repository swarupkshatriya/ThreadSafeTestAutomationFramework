package AutomationExcercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleChrome extends UmeshPractice implements Runnable{
    @Override
    public void run() {
        try {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
