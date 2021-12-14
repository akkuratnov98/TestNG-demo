package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MoveTest {

    @Test (groups = {"smokeTest"})
    public void moveTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{

            driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");

            Thread.sleep(2000);

            WebElement drug = driver.findElement(By.id("draggable"));
            WebElement drop = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);

            //actions.moveToElement(drug).clickAndHold().moveToElement(drop).release().build().perform();
            actions.dragAndDrop(drug, drop).build().perform();

            System.out.println("Тест с перемещением выполнен успешно");

        } finally {
            Thread.sleep(1000);
            driver.quit();
        }

//        Actions actions = new Actions();
//
//        actions
//                .moveToElement()
//                .keyDown()
//                .keyUp()
//                .clickAndHold()
//                .release()
//                .build()
//                .perform();

    }
}
