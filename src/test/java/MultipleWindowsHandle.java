import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindowsHandle {

    @Test
    void multipleWindowsHandle() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        for (String childWindow : driver.getWindowHandles()) {
            if (!parentWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println("Child window title: " + driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Parent window title: " + driver.getTitle());
        driver.quit();
    }
}
