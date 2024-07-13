package AutomationExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
    public static void main (String args[])throws MalformedURLException,InterruptedException {
        Capabilities cap=new FirefoxOptions();
        WebDriver driver=new RemoteWebDriver( new URL("http://localhost:4445/wd/hub"),cap);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Hello Grid");
        Thread.sleep(5000);
    }
}
