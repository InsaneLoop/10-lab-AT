
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQATest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Замінити на шлях до chromedriver
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testInteractions() {
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameField = driver.findElement(By.id("userName"));
        WebElement emailField = driver.findElement(By.id("userEmail"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        fullNameField.sendKeys("John Doe");
        emailField.sendKeys("johndoe@example.com");
        submitButton.click();

        Assert.assertTrue(fullNameField.isDisplayed(), "Full Name field is not visible");
        Assert.assertTrue(emailField.isDisplayed(), "Email field is not visible");
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is not visible");

        WebElement nameOutput = driver.findElement(By.id("name"));
        WebElement emailOutput = driver.findElement(By.id("email"));

        Assert.assertTrue(nameOutput.getText().contains("John Doe"), "Name output is incorrect");
        Assert.assertTrue(emailOutput.getText().contains("johndoe@example.com"), "Email output is incorrect");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
//