package driverinitialization;

public class FireFoxDriverInitiation extends DriverInitializationManager implements Runnable{
    @Override
    public void run() {
        getDriver();
    }
}
