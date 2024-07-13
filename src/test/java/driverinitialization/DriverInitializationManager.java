package driverinitialization;

import com.aventstack.extentreports.ExtentReports;
import extentreport.ExtentReportsManager;
import org.openqa.selenium.Capabilities;
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

public class DriverInitializationManager {
    private static  DriverInitializationManager instance=null;
    private static  ThreadLocal<WebDriver>  tldriver=new ThreadLocal<>();
    private static ThreadLocal<RemoteWebDriver>tlremote=new ThreadLocal<>();
    private static RemoteWebDriver remoteWebDriver;

    public DriverInitializationManager(){}

    private synchronized void initDriver(String browser,String executionmode) throws MalformedURLException {
        if(executionmode.equalsIgnoreCase("Local")){
            switch (browser){
                case"Chrome": {
                    try {
                        ChromeOptions options=new ChromeOptions();
                        options.addArguments("--start-maximized");
                       // options.addArguments("--headless");
                       // options.addArguments("--incognito");
                       // Thread t1=new Thread(new ChromeDriverInitiate(),"ChromeDriverClaas");
                        tldriver.set(new ChromeDriver(options));
                       // t1.start();
                        break;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Edge":{
                    try {
                        EdgeOptions options=new EdgeOptions();
                        options.addArguments("--start-maximized");
                        //options.addArguments("--headless");
                       // Thread t2=new Thread(new EdgeDriverInitiation(),"EdgeDriverInitiation");
                        //t2.start();
                       // options.addArguments("--inPrivate");

                        tldriver.set(new EdgeDriver(options));
                        break;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "FireFox":{
                    try {
                        FirefoxOptions options=new FirefoxOptions();
                        options.addArguments("--maximized");
                      //  Thread t3=new Thread(new FireFoxDriverInitiation(),"FireFoxInitiation");
                      //  t3.start();
                      //  options.addArguments("--headless");
                     //   options.addArguments("--Private");
                        tldriver.set(new FirefoxDriver(options));
                        break;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else if (executionmode.equalsIgnoreCase("Remote")) {
            switch (browser){
                case"Chrome": {

                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("--incognito");
                    try {
                       remoteWebDriver=new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),options);
                       tlremote.set(remoteWebDriver);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case "Edge":{
                    EdgeOptions options=new EdgeOptions();
                    options.addArguments("--inPrivate");
                    try {
                        remoteWebDriver=new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),options);
                        tlremote.set(remoteWebDriver);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case "FireFox":{
                    FirefoxOptions options=new FirefoxOptions();
                    options.addArguments("--Private");
                    try {
                        remoteWebDriver=new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),options);
                        tlremote.set(remoteWebDriver);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }
        }

    }

    public static DriverInitializationManager getInstance(String browser,String executionmode) throws MalformedURLException {
        if(instance==null){
            synchronized (DriverInitializationManager.class){
                if(instance==null){
                    instance=new DriverInitializationManager();
                }
            }
        }
        if(tldriver.get()==null){
            instance.initDriver(browser,executionmode);

        }
        return instance;

    }
    public  static WebDriver getDriver(){
        return tldriver.get();
    }
    public static RemoteWebDriver getRemoteWebDriver(){
        return tlremote.get();
    }

    public static void remoteAttachment(){
        if(tldriver.get()!=null){
            tldriver.get().quit();
            tldriver.remove();

        }
    }

    public static void remoteRemoteAttachment(){
        if(tlremote.get()!=null){
            tlremote.get().quit();
            tlremote.remove();

        }
    }
}
