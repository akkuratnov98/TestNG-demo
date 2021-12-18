package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PaginationTest {

    @Test (groups = {"smokeTest"})
    public void paginationTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String text = "";

        try{

            driver.get("https://pagination.js.org/");

            Thread.sleep(2000);

            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
            List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));
            text = elements.get(5).getText();
            System.out.println(text);

            pages.get(2).click();
            wait.until(ExpectedConditions.stalenessOf(elements.get(5))); //Ждем когда старая информация пропадет
            elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li")); // Загружаем новую таблицу
            text = elements.get(5).getText();
            System.out.println(text);

            System.out.println("Тест Пагинации выполнен");

        } finally {

            Thread.sleep(1000);
            driver.quit();

        }
    }
}
