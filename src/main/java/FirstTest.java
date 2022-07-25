import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    @Test
    public void privatB() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver10305060134");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 1);

        driver.navigate().to("https://next.privat24.ua/?lang=en");
        WebElement buttonClick = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[@data-qa-node='login']")));
        buttonClick.click();

        WebElement authFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://login-widget.privat24.ua/']")));
        driver.switchTo().frame(authFrame);

        WebElement buttonContinue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type = 'submit' and contains (text(), 'Continue')]")));
        buttonContinue.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect value was entered')]")));

    }
}


