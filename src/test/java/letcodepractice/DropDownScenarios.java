package letcodepractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownScenarios {
    @Test
    public void dropDownFunctionalities(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/dropdowns");

        WebElement appleDropDown = driver.findElement(By.cssSelector("#fruits"));
        Select select = new Select(appleDropDown);
        select.selectByVisibleText("Apple");

        WebElement superHeroDropDown = driver.findElement(By.cssSelector("#superheros"));
        select = new Select(superHeroDropDown);
        if(select.isMultiple()){
            select.selectByVisibleText("Batman");
            select.selectByVisibleText("Fantastic Four");
        }

        WebElement progLangDropDown = driver.findElement(By.cssSelector("#lang"));
        select = new Select(progLangDropDown);
        List<WebElement> options = select.getOptions();
        int noOfOptions = options.size();
        int lastOptionsIndex = noOfOptions - 1;
        select.selectByIndex(lastOptionsIndex);

        for(WebElement option : options){
            System.out.println(option.getText());
        }

        WebElement countryDowpDown = driver.findElement(By.cssSelector("#country"));
        select = new Select(countryDowpDown);
        select.selectByValue("India");
        System.out.println(select.getFirstSelectedOption().getText());

        driver.quit();
    }
}
