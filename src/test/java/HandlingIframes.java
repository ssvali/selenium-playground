import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingIframes {

    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/iframe/");
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

    @Test
    void switchToIFrameUsingNameOrId() {

        // Switch using iframe ID
        driver.switchTo().frame("registeruser");

        // Perform action inside iframe
        driver.findElement(By.id("vfb-5")).sendKeys("FirstName");

        // Switch back to main page
        driver.switchTo().defaultContent();
    }

    @Test
    void switchToIFrameUsingWebElement() {
        // Locate iframe as WebElement
        WebElement iframe = driver.findElement(By.name("registeruser"));

        // Switch to iframe
        driver.switchTo().frame(iframe);

        // Perform action inside iframe
        driver.findElement(By.id("vfb-5")).sendKeys("FirstName");

        // Switch back to main page
        driver.switchTo().defaultContent();
    }

    @Test
    void switchToIFrameUsingIndex() {
        // Switch to iframe using index
        driver.switchTo().frame(2);

        // Perform action inside iframe
        driver.findElement(By.id("vfb-5")).sendKeys("abc@gmail.com");

        // Switch back to main page
        driver.switchTo().defaultContent();
    }
}

