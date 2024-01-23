package letcodepractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertScenarios {
    @Test
    public void AlertScenarios() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/alert");

        driver.findElement(By.cssSelector("#accept")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("#confirm")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        String textOnConfirmationAlert = alert.getText();
        System.out.println(textOnConfirmationAlert);
        Thread.sleep(2000);
        alert.dismiss();
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("#prompt")).click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.sendKeys("Trupti");
        Thread.sleep(2000);
        alert.accept();
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("#modern")).click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        WebElement lightBoxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='modal-content'] div[class='card-content']")));
        String textOnLightBox = lightBoxElement.getText();
        System.out.println(textOnLightBox);
        driver.findElement(By.cssSelector("button[aria-label='close']")).click();

        driver.quit();
    }
}
