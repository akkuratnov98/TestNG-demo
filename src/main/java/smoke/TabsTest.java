package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TabsTest {

    @Test
    public void tabs() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {

            driver.get("https://yandex.ru");
            Thread.sleep(2000);

            String yandex = driver.getWindowHandle();

            js.executeScript("window.open()");
            Set<String> currentWindow = driver.getWindowHandles();

            String google = null;

            for (String window : currentWindow) {
                if (!window.equals(yandex)) {
                    google = window;
                    break;
                }
            }

            driver.switchTo().window(google);
            driver.get("https://www.google.ru/");

            driver.switchTo().window(yandex);
            driver.findElement(By.xpath("//input[@class='input__control input__input mini-suggest__input']")).sendKeys("Java Selenium");


            driver.switchTo().window(google);
            driver.close(); //при закрытии нужно вернуться на другю вкладку
            driver.switchTo().window(yandex);

            System.out.println("Тест с вкладками выполнен");

        } finally {

            Thread.sleep(1000);
            driver.quit();

        }
    }
}
