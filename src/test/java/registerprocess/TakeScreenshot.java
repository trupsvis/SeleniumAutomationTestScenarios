package registerprocess;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TakeScreenshot {
    @Test
    public void takeScreenshotMethod() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile,new File("Screenshots//firstScreenshot.jpg"));

        driver.quit();
    }
    @Test(dataProvider = "invalidEmailProvider")
    public void registerAccountUsingInvalidEmail(String invalidEmailId) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        WebElement myAcccountDropMenu = driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']"));
        myAcccountDropMenu.click();
        WebElement registerDropDownOption = driver.findElement(By.linkText("Register"));
        registerDropDownOption.click();

        WebElement first_name = driver.findElement(By.cssSelector("#input-firstname"));
        first_name.sendKeys("xxx");
        WebElement last_name = driver.findElement(By.cssSelector("#input-lastname"));
        last_name.sendKeys("yyy");

        WebElement email_Id = driver.findElement(By.cssSelector("#input-email"));
        email_Id.sendKeys(invalidEmailId);

        WebElement telephone_no = driver.findElement(By.cssSelector("#input-telephone"));
        telephone_no.sendKeys("3439893834");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("12345");
        WebElement confirm_password = driver.findElement(By.cssSelector("#input-confirm"));
        confirm_password.sendKeys("12345");
        WebElement check_privacy_notice  = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        check_privacy_notice.click();

        WebElement continue_button = driver.findElement(By.cssSelector("input[value='Continue']"));
        continue_button.click();

        Thread.sleep(4000);

        String timestamp = new Date().toString().replace(" ","_").replace(":","_");
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile,new File("Screenshots//firstScreenshot" + timestamp + ".jpg"));

        driver.quit();
    }

    @DataProvider(name = "invalidEmailProvider")
    public String[] supplyInvalidEmailData(){
        String[] invalidEmailIds = {"xxx","xxx@","xxx@gmail","xxx@gmail."};
        return invalidEmailIds;

    }
}
