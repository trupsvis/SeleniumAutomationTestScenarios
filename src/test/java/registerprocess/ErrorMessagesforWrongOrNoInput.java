package registerprocess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessagesforWrongOrNoInput {
    @Test
    public void registerWithoutProvidingAnyFields(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        WebElement myAcccountDropMenu = driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']"));
        myAcccountDropMenu.click();
        WebElement registerDropDownOption = driver.findElement(By.linkText("Register"));
        //cssSelector("a[href='https://tutorialsninja.com/demo/index.php?route=account/register']"));
        registerDropDownOption.click();

        WebElement register_continue_button = driver.findElement(By.cssSelector(".btn.btn-primary"));
        register_continue_button.click();

        String actualFirstNameWarningMsg = driver.findElement(By.xpath("//input[@id=\"input-firstname\"]/following-sibling::div")).getText();
        String expectedFirstNameWarningMsg = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualFirstNameWarningMsg, expectedFirstNameWarningMsg);

        String actualLastNameWarningMsg = driver.findElement(By.xpath("//input[@id=\"input-lastname\"]/following-sibling::div")).getText();
        String expectedLastNameWarningMsg = "Last Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualLastNameWarningMsg, expectedLastNameWarningMsg);

        String actualEmailIDWarningMsg = driver.findElement(By.xpath("//input[@id=\"input-email\"]/following-sibling::div")).getText();
        String expectedEmailIDWarningMsg = "E-Mail Address does not appear to be valid!";
        Assert.assertEquals(actualEmailIDWarningMsg, expectedEmailIDWarningMsg);

        String actualTelephoneWarningMsg = driver.findElement(By.xpath("//input[@id=\"input-telephone\"]/following-sibling::div")).getText();
        String expectedTelephoneWarningMsg = "Telephone must be between 3 and 32 characters!";
        Assert.assertEquals(actualTelephoneWarningMsg, expectedTelephoneWarningMsg);

        String actualPasswordWarningMsg = driver.findElement(By.xpath("//input[@id=\"input-password\"]/following-sibling::div")).getText();
        String expectedPasswordWarningMsg = "Password must be between 4 and 20 characters!";
        Assert.assertEquals(actualPasswordWarningMsg, expectedPasswordWarningMsg);

        String actualPrivacyWarningMsg = driver.findElement(By.xpath("//div[@id='account-register']/div[1]")).getText();
        String expectedPrivacyWarningMsg = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(actualPrivacyWarningMsg,expectedPrivacyWarningMsg);

        driver.quit();
    }

}
