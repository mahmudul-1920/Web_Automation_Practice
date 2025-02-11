package hassan.mahmudul;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectValueFromDropDown {

    WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @Test
//    public void dropDownMenu() throws InterruptedException {
//        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
//        Thread.sleep(3000);
//        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
//        Select select = new Select(state);
//
//        //Select By Index
//        select.selectByIndex(3);
//        Thread.sleep(2000);
//
//        //Select By Value
//        select.selectByValue("Rajasthan");
//        Thread.sleep(2000);
//
//        //Select By Visible Text
//        select.selectByVisibleText("NCR");
//        Thread.sleep(2000);
//    }

    @Test
    public void dropDownMenu2() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement city = driver.findElement(By.xpath("//select[@id='city']"));
        Select select = new Select(city);

        select.selectByIndex(2);
        Thread.sleep(2000);

        select.selectByValue("Agra");
        Thread.sleep(2000);

    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
