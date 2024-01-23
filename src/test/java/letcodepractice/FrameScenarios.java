package letcodepractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameScenarios {
    @Test
    public void FrameScenario() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/frame");

        WebElement pageTitle = driver.findElement(By.cssSelector(".title"));
        System.out.println(pageTitle.getText());

        driver.switchTo().frame("firstFr");

        WebElement pageSubTitle = driver.findElement(By.cssSelector(".title"));
        String pageSubTitleField = pageSubTitle.getText();
        System.out.println(pageSubTitleField);

        WebElement fstName = driver.findElement(By.name("fname"));
        fstName.sendKeys("trupti");
        WebElement lstName = driver.findElement(By.name("lname"));
        lstName.sendKeys("jirange");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement randomElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title.has-text-info")));
        String elementTxt = randomElement.getText();
        System.out.println(elementTxt);

        driver.switchTo().frame(0);
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("aaa@bbb.com");
        Thread.sleep(3000);
        emailField.clear();

        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        fstName = driver.findElement(By.name("fname"));
        fstName.clear();
        Thread.sleep(2000);
        lstName = driver.findElement(By.name("lname"));
        lstName.clear();
        pageSubTitle = driver.findElement(By.cssSelector(".title"));
        System.out.println(pageSubTitle.getText());

        driver.switchTo().defaultContent();
        pageTitle = driver.findElement(By.cssSelector(".title"));
        System.out.println(pageTitle.getText());

        driver.quit();
    }
}
