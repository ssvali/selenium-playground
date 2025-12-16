import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertsHandle {

    WebDriver driver;

    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void alertAccept() {
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    void alertDismiss() {
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
    }

    @Test
    void alertPrompt(){
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Selenium Test");
        driver.switchTo().alert().accept();
    }

    @Test
    void alertGetText(){
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text is: " + alertText);
        driver.switchTo().alert().accept();
    }

    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
