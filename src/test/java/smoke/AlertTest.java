package smoke;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertTest {


    @Test (groups = {"smokeTest", "regress"})
    public void alertTest(String db) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            driver.get("http://127.0.0.1:5500/Alert.html");
            Thread.sleep(3000);

            WebElement element = driver.findElement(By.id("a"));
            WebElement element2 = driver.findElement(By.id("b"));
            WebElement element3 = driver.findElement(By.id("c"));

            element.click();

            Alert alert =  wait.until(alertIsPresent());
            alert.accept();

            element2.click();
            Alert prompt = wait.until(alertIsPresent());
            prompt.sendKeys("Super");
            prompt.accept();

            Alert alert2 = wait.until(alertIsPresent());
            Thread.sleep(2000);
            alert2.accept();

            element3.click();
            Alert alert3 = wait.until(alertIsPresent());
            alert3.dismiss();

            System.out.println("Проверка Alert завершена");
            //js.executeScript("document.querySelector('#a').setAttribute('style', 'opacity:1')");

        } finally {

            Thread.sleep(1000);
            driver.quit();
        }
    }
}
