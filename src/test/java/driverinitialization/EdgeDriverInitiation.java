package driverinitialization;

public class EdgeDriverInitiation extends DriverInitializationManager implements Runnable{
    @Override
    public void run() {
        getDriver();
    }
}
