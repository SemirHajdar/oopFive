import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homepage {

    public static String baseUrl = "https://www.placelab.com/";
    public WebDriver driver;
    private String browser;

    public Homepage() {
    }

    @BeforeTest
    public void openBrowser() {
        this.browser = "Chrome";
        if (this.browser.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        }
        this.driver.navigate().to(baseUrl);
    }

    @Test
    public void verifyHomepageTitle() {
        String expectedText = "GIVE YOUR DATA A BOOST";
        String actualText = "";
        By by = new By.ByXPath("//div[@class='text-container']/h1");
        actualText = this.driver.findElement(by).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterTest
    public void closeBrowser() {
        this.driver.quit();
    }
}