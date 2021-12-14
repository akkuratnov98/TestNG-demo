package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;


public class YandexImageTest {

    @Test
    public void yandexImage() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://yandex.ru/images/");

            WebElement input = driver.findElement(By.xpath("//input[@type='file']"));
            input.sendKeys("C:\\Users\\iakkyratnov\\IdeaProjects\\KnowledgeBase\\src\\main\\resources\\Bird.jpg");

            System.out.println("Тест с загрузкой изображения выполнен");

//        //Get download link
//        String downloadLink = driver
//                .findElement(By.cssSelector("main#content a.btn"))
//                .getAttribute("href");
//
//        //Set file to save
//        File fileToSave = new File("/path/to/file.zip");
//
//        //Download file using default org.apache.http client
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(downloadLink);
//        HttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());
//
//        //Save file on disk
//        copyInputStreamToFile(response.getEntity().getContent(), fileToSave);

        } finally {

            Thread.sleep(1000);
            driver.quit();

        }
    }
}
