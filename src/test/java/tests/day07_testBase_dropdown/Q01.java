package tests.day07_testBase_dropdown;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q01 extends TestBase {
    @Test
    public void test01() {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        // 2) sayfadaki iframe sayısını bulunuz.
        int iframeSayisi = driver.findElements(By.tagName("iframe")).size();
        System.out.println(iframeSayisi);
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ifram = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(ifram);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        //  driver.switchTo().frame(iframeler.get(1));
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
    }
}