package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Q02 extends TestBase {
    @Test
    public void test01() {
        //Iframe Homework
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        // 2. “Our Products” butonuna basin

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeElement);
        WebElement ourElementi = driver.findElement(By.xpath("//a[text()='Our Products']"));
        ourElementi.click();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[@class='sub-heading']")).click();

        //4. Popup mesajini yazdirin

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='modal-title']")));


        WebElement popupElementi = driver.findElement(By.xpath("//h4[@class='modal-title']"));
        bekle(5);
        System.out.println(popupElementi.getText());

        //5. “close” butonuna basin

        driver.findElement(By.xpath("//button[text()='Close']")).click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();


        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualurl= driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedUrl,actualurl);
    }
}