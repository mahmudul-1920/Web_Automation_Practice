package hassan.mahmudul;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHover {
    WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void mouseHover() throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(3000);
        WebElement woman = driver.findElement(By.xpath("//a[@title='Women']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(woman).perform();
        Thread.sleep(3000);

//        WebElement casual_dress = driver.findElement(By.xpath("(//a[@title='Casual Dresses'][normalize-space()='Casual Dresses'])[1]"));
//        casual_dress.click();
//        Thread.sleep(3000);

        WebElement summer_dress = driver.findElement(By.xpath("(//a[@title='Summer Dresses'][normalize-space()='Summer Dresses'])[1]"));
        summer_dress.click();
        Thread.sleep(3000);

    }
    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }


}
