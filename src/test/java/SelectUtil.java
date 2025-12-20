import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectUtil {

    WebDriver driver;

    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");
    }

    @Test
    void exampleToSelectByVisibleTextTest(){
        Select select = new Select(driver.findElement(By.id("cars")));
        select.selectByVisibleText("Audi");
        System.out.println("Selected Option: " + select.getFirstSelectedOption().getText());
    }

    @Test
    void exampleToSelectByValueTest(){
        Select select = new Select(driver.findElement(By.id("cars")));
        select.selectByValue("saab");
        System.out.println("Selected Option: " + select.getFirstSelectedOption().getText());
    }

    @Test
    void exampleToSelectByIndexTest(){
        Select select = new Select(driver.findElement(By.id("cars")));
        select.selectByIndex(2);
        System.out.println("Selected Option: " + select.getFirstSelectedOption().getText());
    }

    @Test
    void exampleToGetAllOptionsTest(){
        Select select = new Select(driver.findElement(By.id("cars")));
        for(var option : select.getOptions()){
            System.out.println("Options " + option.getText());
        }
    }

    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
