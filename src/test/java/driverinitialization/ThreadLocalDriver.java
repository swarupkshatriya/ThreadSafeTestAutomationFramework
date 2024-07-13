package driverinitialization;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ThreadLocalDriver {

    ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();


    private ThreadLocalDriver(){}

    private static ThreadLocalDriver instance= new ThreadLocalDriver();

    public static ThreadLocalDriver getInstance(){
        return instance;
    }

    public  WebDriver getDriver(){
        return driver.get();
    }
    public synchronized void setDriver(String Browser){
        switch (Browser){
            case "Chrome": {
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--start-maximized");
                driver.set(new ChromeDriver(option));
                break;
            }
            case "Edge": {
                EdgeOptions option = new EdgeOptions();
                option.addArguments("--start-maximized");
                driver.set(new EdgeDriver(option));
                break;
            }
            case "FireFox": {
                FirefoxOptions options = new FirefoxOptions();
                //options.addArguments("--maximized");
                //  Thread t3=new Thread(new FireFoxDriverInitiation(),"FireFoxInitiation");
                //  t3.start();
                //  options.addArguments("--headless");
                //   options.addArguments("--Private");
                driver.set(new FirefoxDriver(options));
                break;
            }
        }

    }
    public void closeBrowser(){
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }

    }
}
