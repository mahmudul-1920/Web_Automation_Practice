package hassan.mahmudul;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebCommand {

    WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }

    @Test
    public void fetchCurrentUrl() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement Home = driver.findElement(By.xpath("//a[normalize-space()='']//*[name()='svg']"));
        Home.click();
        Thread.sleep(3000);
        String getUrl = driver.getCurrentUrl();
        System.out.println("CurrentUrl: " +getUrl);
    }
    @Test
    public void fetchTitle() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement Home = driver.findElement(By.xpath("//a[normalize-space()='']//*[name()='svg']"));
        Home.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println("Title: " +title);
    }

    @Test
    public void sendValues() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement firstName = driver.findElement(By.id("name"));
        firstName.sendKeys("Mahmudul Hasan");
        Thread.sleep(3000);
        firstName.clear();
        firstName.sendKeys("Badhon");
        Thread.sleep(2000);
    }
    @Test
    public void attributeName() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement firstName = driver.findElement(By.id("name"));
       String attributeValue = firstName.getAttribute("placeholder");
        System.out.println("attributeName: " +attributeValue);
    }
    @Test
    public void cssValue() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement firstName = driver.findElement(By.id("name"));
        String cssValue = firstName.getCssValue("color");
        System.out.println("attributeName: " +cssValue);
    }
    @Test
    public void getTextValue() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement text = driver.findElement(By.xpath("//h1[normalize-space()='Selenium - Automation Practice Form']"));
        System.out.println("getText: " +text.getText());
    }

}
