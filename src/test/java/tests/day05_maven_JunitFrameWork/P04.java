package tests.day05_maven_JunitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {
    @Test
    public void amazonTesti() throws InterruptedException {
        // amazon'a gidelim ve url'in amazon icerdigini test edip
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        String actualUrlElementi=driver.getCurrentUrl();
        String expectedUrl="amazon";
        if (actualUrlElementi.contains(expectedUrl))
            System.out.println("Url Test PASSED");
        else
            System.out.println("Url Test FAİLED");
        Thread.sleep(3000);
        driver.close();

    }

    @Test
    public void wiseQuarterTesti() throws InterruptedException {
        // Wise quarter anasayfaya gidip
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://wisequarter.com");

        // Title'in Wise Quarter icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="Wise Quarter";
        if (actualTitle.contains(expectedTitle))
            System.out.println("Title Test PASSED");
        else
            System.out.println("Title Test FAİLED");
        Thread.sleep(3000);
        driver.close();

    }
}
