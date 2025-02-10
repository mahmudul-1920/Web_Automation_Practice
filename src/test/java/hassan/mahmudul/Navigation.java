package hassan.mahmudul;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Navigation {
    WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void navigate() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
        login.click();
        Thread.sleep(3000);

        //Back
        driver.navigate().back();
        Thread.sleep(3000);

        //Forward
        driver.navigate().forward();
        Thread.sleep(3000);

        //Refresh
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
