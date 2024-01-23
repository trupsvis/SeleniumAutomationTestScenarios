package letcodepractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioTestScenarios {
    @Test
    public void RadioCheckboxTestScenarios(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/radio");

        driver.findElement(By.cssSelector("#yes")).click();

        WebElement yesRadioButton = driver.findElement(By.cssSelector("#one"));
        yesRadioButton.click();
        WebElement noRadioButton = driver.findElement(By.cssSelector("#two"));
        boolean yesStatus = yesRadioButton.isSelected();
        boolean noStatus = noRadioButton.isSelected();
        if(yesStatus){
            if(noStatus)
                System.out.println("No Radio button getting selected");
            else
                System.out.println("No Radio button is getting selected");
        }

        WebElement yButton = driver.findElement(By.cssSelector("#nobug"));
        WebElement nButton = driver.findElement(By.cssSelector("#bug"));
        yButton.click();
        nButton.click();
        if(yButton.isSelected() && nButton.isSelected())
            System.out.println("Both radio buttons are getting selected");

        WebElement fooButton  =  driver.findElement(By.cssSelector("#foo"));
        WebElement barButton  =  driver.findElement(By.cssSelector("#notfoo"));
        if(fooButton.isSelected())
            System.out.println("Foo radio button is selected");
        else if(barButton.isSelected())
            System.out.println("Bar radio button is selected");
        else
            System.out.println("None of the radio button is selected");

        WebElement mayBeRadioButton = driver.findElement(By.cssSelector("#maybe"));
        if(mayBeRadioButton.isEnabled())
            System.out.println("MayBe Radio button is in enabled state");
        else
            System.out.println("MayBe Radio button is in disabled state");

        WebElement rememberMeCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        if(rememberMeCheckBox.isSelected())
            System.out.println("Checkbox is selected");
        else
            System.out.println("Checkbox is not selected");

        WebElement acceptTCCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        acceptTCCheckbox.click();
        System.out.println("TC Checkbox is selected");

        driver.quit();
    }
}
