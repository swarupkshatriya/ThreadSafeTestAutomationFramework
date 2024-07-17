package driverinitialization;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ThreadLocalDriver {

    ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
    public static final String USERNAME="swarupkshatriya_gruMHw";
    public static final String AUTOMATE_KEY="XwxmsBfziFcFzvK8yJKY";
    public static final String URL="https://"+USERNAME+":"+AUTOMATE_KEY+"@hub-cloud.browserstack.com/wd/hub";
    public static final String remoteURL="http://localhost:4445/wd/hub";
    private ThreadLocalDriver(){}

    private static ThreadLocalDriver instance= new ThreadLocalDriver();

    public static ThreadLocalDriver getInstance(){
        return instance;
    }

    public  WebDriver getDriver(){
        return driver.get();
    }
    public synchronized void setDriver(String Browser) throws MalformedURLException {
        switch (Browser){
            case "Chrome": {
               // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\DriverFolder\\chromedriver.exe");
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--start-maximized");
                driver.set(new ChromeDriver(option));
                // driver.set(new RemoteWebDriver(new URL(remoteURL),option));
                break;
            }
            case "Edge": {
                System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\DriverFolder\\msedgedriver.exe");
                EdgeOptions option = new EdgeOptions();
//                DesiredCapabilities caps=new DesiredCapabilities();
//                caps.setCapability("browser","Edge");
//                caps.setCapability("browserVersion","latest");
//                caps.setCapability("os","Windows");
//                caps.setCapability("osVersion","10");
               // caps.setCapability("browserstackLocal",true);
               // caps.setCapability("buildName","browserstack-build-1");
               // caps.setCapability("projectName","BrowserStack Sample");


                option.addArguments("--start-maximized");
               // driver.set(new RemoteWebDriver(new URL(remoteURL),option));
                driver.set(new EdgeDriver(option));
                break;
            }
            case "FireFox": {
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\DriverFolder\\geckodriver.exe");
                FirefoxOptions option = new FirefoxOptions();
                option.addArguments("--maximized");
                //  Thread t3=new Thread(new FireFoxDriverInitiation(),"FireFoxInitiation");
                //  t3.start();
                //  options.addArguments("--headless");
                //   options.addArguments("--Private");
               // driver.set(new RemoteWebDriver(new URL(remoteURL),option));
                driver.set(new FirefoxDriver(option));
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
