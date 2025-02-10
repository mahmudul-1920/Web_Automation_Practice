package hassan.mahmudul;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class Lacators {
    WebDriver driver;

    @BeforeSuite
    public void StartBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void closeBrowser(){
        driver.close();
    }


    @Test(priority = 0)
    public void openURL() {

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    }

    @Test(priority = 1)
    public void LocatedById() throws InterruptedException {
        WebElement firstName = driver.findElement(By.id("name"));
        firstName.sendKeys("Mahmudul");
        Thread.sleep(5000);
//        firstName.clear();
//        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public void LocatedByName() throws InterruptedException {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("Test@gamil.com");
        Thread.sleep(5000);
//        email.clear();
//        Thread.sleep(5000);
    }
//    @Test(priority = 3)
//    public void LocatedByLinkText() throws InterruptedException {
//        driver.navigate().to("https://www.facebook.com/");
//        WebElement forgetPass = driver.findElement(By.linkText("Forgotten password?"));
//        forgetPass.click();
//        Thread.sleep(3000);
//    }

    @Test(priority = 3)
    public void locatedByPartialLinkText() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        WebElement forget_pass = driver.findElement(By.partialLinkText("Forgotten"));
        forget_pass.click();
        Thread.sleep(3000);
    }
    @Test(priority = 4  )
    public void locatedByTagName(){
        driver.navigate().to("https://www.facebook.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement link : links){
            System.out.println(link.getText());
        }
    }
    @Test(priority = 5)
    public void locateByXPath() throws InterruptedException {
        driver.navigate().to("https://www.ryans.com/customers/login#emailLogin");
        WebElement email = driver.findElement(By.xpath("(//input[@placeholder='Enter Your Email Address'])[1]"));
        email.sendKeys("test@gmail.com");
        Thread.sleep(3000);
    }
}
