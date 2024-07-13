package AutomationExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UmeshPractice {
//    WebDriver driver=new ChromeDriver();
//    Actions act=new Actions(driver);
//    public void doNothing(){
//        WebElement element=driver.findElement(By.xpath(""));
//        act.moveToElement(element).perform();
//    }
    public static void main(String args[]){
        Thread googleOpera = new Thread(new GoogleEdge(),"GoogleEdgeThread");
        googleOpera.start();
        Thread googleFirefox = new Thread (new GoogleFireFox(),"GoogleFirefoxThread");
        googleFirefox.start();

        Thread googleChrome = new Thread (new GoogleChrome(),"GoogleChromeThread");
        googleChrome.start();
        //Thread youtubeIE= new Thread(new youtubeIE(),"YoutubeThread");
        //youtubeIE.start();

    }

}
