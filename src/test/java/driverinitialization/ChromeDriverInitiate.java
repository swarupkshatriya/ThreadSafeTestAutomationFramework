package driverinitialization;

public class ChromeDriverInitiate extends DriverInitializationManager implements Runnable{
    @Override
    public void run() {
        getDriver();
    }
}
