import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    String driverPath = "src/main/resources/chromedriver10305060134";
    String mainPage = "https://next.privat24.ua/?lang=en";
    String buttonLoginxPath = "//button[@data-qa-node='login']";
    String authFramexPath = "//iframe[@src='https://login-widget.privat24.ua/']";
    String buttonContinuexPath = "//button[@type = 'submit' and contains (text(), 'Continue')]";
    String errorMessage = "//div[contains(text(), 'Incorrect value was entered')]";

    @Test
    public void privatB() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().to(mainPage);
        WebElement buttonLogin = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(buttonLoginxPath)));
        buttonLogin.click();

        WebElement authFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(authFramexPath)));
        driver.switchTo().frame(authFrame);

        WebElement buttonContinue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonContinuexPath)));
        buttonContinue.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(errorMessage)));

    }
}


