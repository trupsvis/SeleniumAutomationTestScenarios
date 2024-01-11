package letcodepractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class DifferentButtonScenarios {
    @Test
    public void ButtonScenarioTests() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/buttons");

        WebElement goHomeButton = driver.findElement(By.cssSelector("#home"));
        goHomeButton.click();
        driver.navigate().back();

        WebElement findXYCoordinates = driver.findElement(By.cssSelector("#position"));
        Point point =  findXYCoordinates.getLocation();
        System.out.println("X coordinates =>" +point.getX());
        System.out.println("Y coordinates =>" +point.getY());

        Rectangle rect = findXYCoordinates.getRect();
        System.out.println("X coordinates using diff method=>" +rect.getX());
        System.out.println("Y coordinates using diff method=>" +rect.getY());


        WebElement findColorOfButton = driver.findElement(By.cssSelector("#color"));
        String buttonColor = findColorOfButton.getCssValue("background-color");
        System.out.println("Button Color =>"+ buttonColor);

        WebElement findSizeOfButton  = driver.findElement(By.cssSelector("#property"));
        Dimension dimensionsOfButton  = findSizeOfButton.getSize();
        System.out.println("Height of button => "+dimensionsOfButton.height);
        System.out.println("Width of button  => "+dimensionsOfButton.width);

        WebElement stateOfButton = driver.findElement(By.cssSelector("#isDisabled"));
        Boolean buttonStatus = stateOfButton.isEnabled();
        System.out.println(buttonStatus);

        Actions actions = new Actions(driver);
        WebElement holdButton = driver.findElement(By.cssSelector("button[id='isDisabled'] div h2"));
        actions.clickAndHold(holdButton).perform();

        Thread.sleep(3000);

        actions.release().perform();

        driver.quit();

    }
}
