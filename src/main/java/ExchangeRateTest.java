import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InformPage;
import pages.LoginPage;

import java.time.Duration;

public class ExchangeRateTest {

    //Один и тот же тест, с разными входными данными
    @DataProvider(name = "LoginPass")
    public static Object[][] enterInfo() {
        return new Object[][]{
                {"Ivan", "employer"},
                {"pass", "Admin"}
        };
    }

    @Parameters({"login", "pass"})//Параметры из XML файла
    @Test(groups = {"regress"})
    //@Test (dataProvider = "LoginPass")
    public void exchangeRateTest(String login, String pass) {
        LoginPage loginPage = new LoginPage();
        InformPage informPage = new InformPage();

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Неявное ожидание


        loginPage.loginPage(driver, login, pass);
        System.out.println(informPage.getInform(driver));

    }
}


//Повторный запуск метода
//@Test (retryAnalyzer = Retry.class)
//
//class Retry implements IRetryAnalyzer {
//    private int actualRetry = 0;
//    private static final int MAX_RETRY = 3;
//
//    @Override
//    public boolean retry(ITestResult result) {
//        if (actualRetry < MAX_RETRY) {
//            actualRetry++;
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//}