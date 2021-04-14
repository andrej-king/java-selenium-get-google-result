package andrej.p.com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Main {

    public static void main(String[] args) {
        final int sleepTime = 5000;
        final long seconds = 10;

        System.setProperty("webdriver.chrome.driver", "D://Selenium_jars_and_drivers/drivers/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        try {
            driver.get("https://google.com");
            driver.findElement(By.name("q")).sendKeys("wikipedia" + Keys.ENTER);
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
            System.out.println(firstResult.getAttribute("textContent"));

            Thread.sleep(sleepTime);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.close();
        }
    }
}
