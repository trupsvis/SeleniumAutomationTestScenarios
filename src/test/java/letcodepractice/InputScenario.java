package letcodepractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputScenario {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/edit");
        driver.findElement(By.cssSelector("#fullName")).sendKeys("Trupti");
        driver.findElement(By.cssSelector("#join")).sendKeys("  Tester.");
        driver.findElement(By.cssSelector("#join")).sendKeys(Keys.TAB);
        String getme = driver.findElement(By.cssSelector("#getMe")).getAttribute("value");
        System.out.println(getme);
        driver.findElement(By.cssSelector("#clearMe")).clear();
        boolean enabledStatus = driver.findElement(By.cssSelector("#noEdit")).isEnabled();
        if(enabledStatus){
            System.out.println("Edit field is in enabled state");
        }else{
            System.out.println("Edit field is in disabled state");
        }
        String readonlyState = driver.findElement(By.cssSelector("#dontwrite")).getAttribute("readonly");
        if(readonlyState.equals("true")){
            System.out.println("Confirm text field is in readonly state");
        }else{
            System.out.println("Text field is not in readonly state");
        }

        driver.quit();
    }
}
