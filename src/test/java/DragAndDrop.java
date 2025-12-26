import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {

    WebDriver driver;

    /**
     * @param args DragAndDrop - A convenience method that performs click-and-hold at the location of the source element,
     *             moves to the location of the target element, then releases the mouse.
     *             <p>
     *             'build()' method is used to compile all the list of actions into a single step and ready to be performed.
     *             <p>
     *             We need to use perform() to execute the action.
     */

    @Test
    void exampleToDragAndDrop() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));
        Actions act = new Actions(driver);
        act.dragAndDrop(from, to).build().perform();
    }

    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
