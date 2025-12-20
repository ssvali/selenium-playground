import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
        	Drop down will have the tag as “Select.”
        	To select a particular value from the list we have to use select class.
        	This method takes the WebElement from which a value has to be selected as an argument.
        	We can select values using any of the following methods in select class
            1. selectByVisibleText()
            2. selectByIndex()
            3. selectByValue()
        	Use these methods multiple times for multi select drop down
        	We can perform more operations than just selecting values using select class.
                	To deselect the selected values we have to use any one of the deselect methods.
        	To get all the content of the drop down use getoptions() method which returns a list of webelements.
                	Use getText() method to retrieve all the content.
                	To get the selected option use getFirstSelectedOption() method.
 */


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
