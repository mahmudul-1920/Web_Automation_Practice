package hassan.mahmudul;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CopyPaste {
    WebDriver driver;

    @BeforeClass
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void copy_and_paste() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
        Thread.sleep(3000);
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("JavaTutorial");
        Thread.sleep(3000);

        Actions actions = new Actions(driver);

        //Select
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(2000);


        //Copy
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(2000);

        //Tab
        actions.sendKeys(Keys.TAB);
        actions.build().perform();

        //Paste
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyDown(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(2000);

    }
    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
