package hassan.mahmudul;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionExample {
    WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void hardAssertion() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        String expected_title = "Selenium Practice - Student Registration For";
        String actual_title = driver.getTitle();
        Assert.assertEquals(expected_title,actual_title);
        System.out.println("CurrentUrl: " +driver.getCurrentUrl());
    }
    @Test
    public void softAssertion() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        String expected_title = "Selenium Practice - Student Registration For";
        String actual_title = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expected_title,actual_title);
        System.out.println("CurrentUrl: " +driver.getCurrentUrl());
        softAssert.assertAll();
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
