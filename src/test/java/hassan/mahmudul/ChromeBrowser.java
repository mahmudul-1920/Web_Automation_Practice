package hassan.mahmudul;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChromeBrowser {
    WebDriver driver;

    //    start a browser
    @BeforeSuite
    public void StartBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //    Close a browser
    @AfterSuite
    public void closeBrowser(){
        driver.close();
    }


    //    get browserUrl
    @Test
    public void openURL(){

        driver.get("https://www.rokomari.com/book");
    }
}
