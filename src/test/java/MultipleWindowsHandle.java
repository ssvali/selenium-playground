import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

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

    @Test
    public void windowsExampleCode() {

        WebDriver driver = new ChromeDriver();
        // Navigate to Url
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
        //fetch handle of this
        String currHandle=driver.getWindowHandle();
        assertNotNull(currHandle);

        //click on link to open a new window
        driver.findElement(By.linkText("Open new window")).click();
        //fetch handles of all windows, there will be two, [0]- default, [1] - new window
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        //assert on title of new window
        String title=driver.getTitle();
        assertEquals(title, "Simple Page");

        //closing current window
        driver.close();
        //Switch back to the old tab or window
        driver.switchTo().window((String) windowHandles[0]);

        //Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);
        assertEquals(driver.getTitle(), "");

        //Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        assertEquals(driver.getTitle(), "");

        //quitting driver
        driver.quit(); //close all windows

    }
}
