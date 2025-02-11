package hassan.mahmudul;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scroll {
    WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(3000);

        //Script for top
//               String script_for_scroll_top = "window.scrollTo(0,document.body.scrollHeight)";
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(script_for_scroll_top);
//        Thread.sleep(2000);
//
//        //Script fot bottom
//        String script_for_scroll_bottom = "window.scrollTo(0,0);";
//        js.executeScript(script_for_scroll_bottom);
//        Thread.sleep(2000);

        WebElement bestSeller = driver.findElement(By.xpath("//a[@class='blockbestsellers']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bestSeller).perform();
        Thread.sleep(3000);


    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
