package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage {

    public void loginPage(ChromeDriver driver, String login, String pass) {

        try {

            WebElement loginInput = driver.findElement(By.id("login"));
            WebElement passInput = driver.findElement(By.id("pass"));
            WebElement enter = driver.findElement(By.id("enter"));

            loginInput.sendKeys(login);
            passInput.sendKeys(pass);
            enter.click();



        } catch (Exception e){

        }

    }
}

