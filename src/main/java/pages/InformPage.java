package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformPage {

    public String getInform(ChromeDriver driver){

        String euro = driver.findElement(By.id("Euro")).getText();
        String dollar = driver.findElement(By.id("Dollar")).getText();

        return ("Курс Euro" + euro + " \n Курс Dollar" + dollar);
    }
}
