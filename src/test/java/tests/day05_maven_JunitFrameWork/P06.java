package tests.day05_maven_JunitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    WebDriver driver;

    @Test
    public void amazonTesti() throws InterruptedException {
        // amazon'a gidelim ve url'in amazon icerdigini test edip
        setup();
        driver.get("https://amazon.com");
        String actualUrlElementi = driver.getCurrentUrl();
        String expectedUrl = "Ramazon";
        if (actualUrlElementi.contains(expectedUrl))
            System.out.println("Url Test PASSED");
        else {
            System.out.println("Url Test FAİLED");
            throw new RuntimeException();
        }
        Thread.sleep(3000);
        driver.close();

    }

    @Test
    public void wiseQuarterTesti() throws InterruptedException {
        // Wise quarter anasayfaya gidip
        setup();
        driver.get("https://wisequarter.com");

        // Title'in Wise Quarter icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Wise Quarter";
        if (actualTitle.contains(expectedTitle))
            System.out.println("Title Test PASSED");
        else {
            System.out.println("Title Test FAİLED");
            throw new RuntimeException();
        }
        Thread.sleep(3000);
        driver.close();

    }

    @Test
    public void youtubeTesti() {
        setup();
        // youtube anasayfaya gidin
        setup();
        driver.get("https://www.youtube.com");
        // title'in YouTube oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Youtube Testi PASSED");
        }else{
            System.out.println("Youtube Testi FAILED");
            throw new RuntimeException();
        }
        driver.close();

    }

    public void setup() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
