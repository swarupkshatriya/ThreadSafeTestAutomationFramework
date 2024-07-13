package commonLibrarymethods;

import com.aventstack.extentreports.MediaEntityBuilder;
import driverinitialization.ThreadLocalDriver;
import extentreport.ExtentTestManager;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testRunnerFile.ExtentReportGenerationClass;
import testdatareader.TestDataReader;
import userdefinedExceptions.DataIsNotVisible;
import userdefinedExceptions.FrameIsNotAvailable;
import userdefinedExceptions.ObjIsNotAvailable;

import java.time.Duration;
import java.util.List;

public class CommonResuableMethods extends ExtentReportGenerationClass{

    TestDataReader tdr=new TestDataReader();


    public synchronized boolean isVisible(WebDriver driver,By element) throws ObjIsNotAvailable {
        try {
            WebDriverWait waitEle=new WebDriverWait(ThreadLocalDriver.getInstance().getDriver(), Duration.ofSeconds(180));
            waitEle.pollingEvery(Duration.ofSeconds(5));
            waitEle.ignoring(StaleElementReferenceException.class);
            waitEle.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
            return true;
        } catch (TimeoutException e) {
            return  false;
        }catch(Exception av){
            throw new ObjIsNotAvailable(element+" Object is not available in Page");
        }

    }
    public  synchronized boolean isVisibleRemote(RemoteWebDriver driver,By element) throws ObjIsNotAvailable {
        try {
            WebDriverWait waitEle=new WebDriverWait(driver,Duration.ofSeconds(180));
            waitEle.pollingEvery(Duration.ofSeconds(3));
            waitEle.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (TimeoutException e) {
            return  false;
        }catch(Exception av){
            throw new ObjIsNotAvailable(element+" Object is not available in Page");
        }

    }

    public synchronized boolean isVisibleOnPage(WebDriver driver,By element){

        try {
           return isVisible(driver,element);

        } catch (ObjIsNotAvailable e) {
            ExtentTestManager.getInstance(test).getTest().fail(e.getMessage());
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+getScreenshot(driver)).build());
            Assert.fail(element+" Object is not visible");
            return false;
        }
    }
    public synchronized boolean isVisibleOnPageRemote(RemoteWebDriver driver,By element){

        try {
            return isVisibleRemote(driver,element);

        } catch (ObjIsNotAvailable e) {
            ExtentTestManager.getInstance(test).getTest().fail(e.getMessage());
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+getScreenshotRemote(driver)).build());
            Assert.fail(element+" Object is not visible");
            return false;
        }
    }

    public synchronized  void type(WebDriver driver,By element,String elementname,String data) {

            if(isVisibleOnPage(driver,element)){
                ThreadLocalDriver.getInstance().getDriver().findElement(element).sendKeys(data);
                ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been entered with value <B>"+data+"</B>");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail(elementname+" is not visible and not able to entered value <B>"+data+"</B>");
                ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+getScreenshot(driver)).build());
                Assert.fail(elementname+" is not available");
            }
    }

    public synchronized void typeRemote(RemoteWebDriver driver,By element,String elementname,String data) {

        if(isVisibleOnPageRemote(driver,element)){
            driver.findElement(element).sendKeys(data);
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been entered with value <B>"+data+"</B>");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail(elementname+" is not visible and not able to entered value <B>"+data+"</B>");
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+getScreenshotRemote(driver)).build());
            Assert.fail(elementname+" is not available");
        }
    }
    public  void clickElement(WebDriver driver,By element,String elementname){

            if (isVisibleOnPage(driver,element)){
                WebDriverWait wait=new WebDriverWait(ThreadLocalDriver.getInstance().getDriver(),Duration.ofSeconds(30));
                wait.pollingEvery(Duration.ofSeconds(5));
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                ThreadLocalDriver.getInstance().getDriver().findElement(element).click();
                ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been clicked");
            }else{
                ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not clicked</B>");
                ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver)).build());
                Assert.fail(elementname+" is not available");
            }

    }
    public synchronized void clickElementRemote(RemoteWebDriver driver, By element, String elementname){

        if(isVisibleOnPageRemote(driver,element)){
            driver.findElement(element).click();
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been clicked");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not clicked</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotRemote(driver)).build());
            Assert.fail(elementname+" is not available");
        }

    }
    public synchronized void selectByText(WebDriver driver,By element,String elementname,String data) throws DataIsNotVisible {

        if(isVisibleOnPage(driver,element)){
            Select selectBytext=new Select(ThreadLocalDriver.getInstance().getDriver().findElement(element));
            try {
                selectBytext.selectByVisibleText(data);
            } catch (Exception e) {
                throw new DataIsNotVisible("Data which you entered is not available in application");
            }
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been Selected <B>"+data+"</B>");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not selected</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver)).build());

            Assert.fail(elementname+" is not available");
        }

    }
    public synchronized void selectByTextRemote(RemoteWebDriver driver,By element,String elementname,String data) throws DataIsNotVisible {

        if(isVisibleOnPageRemote(driver,element)){
            Select selectBytext=new Select(driver.findElement(element));
            try {
                selectBytext.selectByVisibleText(data);
            } catch (Exception e) {
                throw new DataIsNotVisible("Data Entered is not Visible");
            }
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been Selected <B>"+data+"</B>");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not selected</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotRemote(driver)).build());
            Assert.fail(elementname+" is not available");
        }

    }

    public synchronized void selectByvalue(WebDriver driver,By element,String elementname,String data){

        if(isVisibleOnPage(driver,element)){
            Select selectByvalue=new Select(driver.findElement(element));
            selectByvalue.selectByValue(data);
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been Selected <B>"+data+"</B>");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not selected</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver)).build());
            Assert.fail(elementname+" is not available");
        }

    }

    public synchronized void selectByvalueRemote(RemoteWebDriver driver,By element,String elementname,String data){

        if(isVisibleOnPageRemote(driver,element)){
            Select selectBytext=new Select(driver.findElement(element));
            selectBytext.selectByValue(data);
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been Selected <B>"+data+"</B>");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not selected</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotRemote(driver)).build());
            Assert.fail(elementname+" is not available");
        }

    }


    public synchronized void selectByindex(WebDriver driver,By element,String elementname,int data){

        if(isVisibleOnPage(driver,element)){
            Select selectBytext=new Select(driver.findElement(element));
            selectBytext.selectByIndex(data);
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been Selected <B>"+data+"</B>");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not selected</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver)).build());
            Assert.fail(elementname+" is not available");
        }

    }
    public synchronized void selectByindexRemote(RemoteWebDriver driver,By element,String elementname,int data){

        if(isVisibleOnPageRemote(driver,element)){
            Select selectBytext=new Select(driver.findElement(element));
            selectBytext.selectByIndex(data);
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been Selected <B>"+data+"</B>");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not selected</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotRemote(driver)).build());
            Assert.fail(elementname+" is not available");
        }

    }

    public List<WebElement> getAllOptionFromSelectClass(WebDriver driver,By element,String elementname){

        if(isVisibleOnPage(driver,element)){
            Select objSelectClass=new Select(driver.findElement(element));
            List<WebElement> list1 =objSelectClass.getOptions();
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been Return");
            return list1;
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not selected</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver)).build());
            Assert.fail(elementname+" is not available");
            return null;
        }

    }
    public synchronized List<WebElement> getAllOptionFromSelectClassRemote(RemoteWebDriver driver,By element,String elementname){

        if(isVisibleOnPageRemote(driver,element)){
            Select objSelectClass=new Select(driver.findElement(element));
            List<WebElement> list1 =objSelectClass.getOptions();
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been Return");
            return list1;
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not selected</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotRemote(driver)).build());
            Assert.fail(elementname+" is not available");
            return null;
        }

    }

    public synchronized void selectCheckBox(WebDriver driver,By element,String elementname){

        if(isVisibleOnPage(driver,element)){
            ThreadLocalDriver.getInstance().getDriver().findElement(element).click();
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been clicked ");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not clicked</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver)).build());
            Assert.fail(elementname+" is not available");
        }
    }

    public synchronized void selectCheckBoxRemote(RemoteWebDriver driver,By element,String elementname){

        if(isVisibleOnPageRemote(driver,element)){
            driver.findElement(element).click();
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been clicked ");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail("<B>"+elementname+" is not visible and not clicked</B>");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotRemote(driver)).build());
            Assert.fail(elementname+" is not available");
        }
    }
    public synchronized void javascriptExecutorMethod(WebDriver driver,By element,String elementname){

        if(isVisibleOnPage(driver,element)){
            JavascriptExecutor js=(JavascriptExecutor)driver;
            WebElement element1=ThreadLocalDriver.getInstance().getDriver().findElement(element);
            js.executeScript("arguments[0].scrollIntoView();",element1);
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been scroll and is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail(elementname+" is not scroll and not visible");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver)).build());
            Assert.fail(elementname+" is not available");
        }
    }

    public synchronized void javascriptExecutorMethodRemote(RemoteWebDriver driver,By element,String elementname){

        if(isVisibleOnPageRemote(driver,element)){
            JavascriptExecutor js=(JavascriptExecutor)driver;
            WebElement element1=driver.findElement(element);
            js.executeScript("arguments[0].scrollIntoView();",element1);
            ExtentTestManager.getInstance(test).getTest().pass(elementname+" has been scroll and is visible");
        }else{
            ExtentTestManager.getInstance(test).getTest().fail(elementname+" is not scroll and not visible");
            ExtentTestManager.getInstance(test).getTest().info("screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotRemote(driver)).build());
            Assert.fail(elementname+" is not available");
        }
    }
    public synchronized void switchF(WebDriver driver,String idOrname) throws FrameIsNotAvailable {

        try {
            driver.switchTo().frame(idOrname);
            ExtentTestManager.getInstance(test).getTest().pass("<B> frame "+idOrname+" has been Switched </B>");
        } catch (Exception e) {
            throw new FrameIsNotAvailable("Frame is not available");
        }
    }

    public synchronized void switchFRemote(RemoteWebDriver driver,String idOrname) throws FrameIsNotAvailable {

        try {
            driver.switchTo().frame(idOrname);
            ExtentTestManager.getInstance(test).getTest().pass("<B> frame "+idOrname+" has been Switched </B>");
        } catch (Exception e) {
            throw new FrameIsNotAvailable("Frame is not available");
        }
    }


    public synchronized void switchToFrameID(WebDriver driver,String idorName){

        try {
            switchF(driver,idorName);
        } catch (FrameIsNotAvailable e) {
            ExtentTestManager.getInstance(test).getTest().fail(e.getMessage());
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+getScreenshot(driver)).build());
            Assert.fail(idorName+" Frame is not Available");
        }

    }

    public synchronized void switchToFrameIDRemote(RemoteWebDriver driver,String idorName){

        try {
            switchFRemote(driver,idorName);
        } catch (FrameIsNotAvailable e) {
            ExtentTestManager.getInstance(test).getTest().fail(e.getMessage());
            ExtentTestManager.getInstance(test).getTest().info("Screen Shot", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+getScreenshotRemote(driver)).build());
            Assert.fail(idorName+" Frame is not Available");
        }

    }



    public static String getScreenshot(WebDriver driver) {
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return screenshotBase64;
    }

    public static String getScreenshotRemote(RemoteWebDriver driver) {
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return screenshotBase64;
    }
}
