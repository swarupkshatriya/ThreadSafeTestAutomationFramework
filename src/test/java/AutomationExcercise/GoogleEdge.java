package AutomationExcercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleEdge extends UmeshPractice implements Runnable {

    @Override
    public void run() {
        try {
            WebDriver driver = new EdgeDriver();
            driver.get("https://www.google.com");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
