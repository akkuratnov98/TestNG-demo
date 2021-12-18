package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AvitoTest {

    @Test (groups = {"smokeTest"})
    public void avito() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {

            driver.get("https://www.avito.ru");
            WebElement href = (new WebDriverWait(driver, Duration.ofSeconds(3)))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Личные вещи'][1]")));
            href.click();

            WebElement personalBelongings = (new WebDriverWait(driver, Duration.ofSeconds(3)))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[@data-marker='option(5)']")));
            Assert.assertEquals("true", personalBelongings.getAttribute("selected"));

            System.out.println("Тест с вкладками проверкой перехода выолнен");
        } finally {

            Thread.sleep(1000);
            driver.quit();

        }
    }
}
