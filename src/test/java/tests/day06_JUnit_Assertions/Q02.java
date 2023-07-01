package tests.day06_JUnit_Assertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseBeforeClass;

public class Q02 extends TestBaseBeforeClass {
    @Test
    public void test01() {
        //1) Bir class oluşturun: YoutubeAssertions
        //2) https://www.youtube.com adresine gidin
            driver.get("https://www.youtube.com");
        //3) Aşağıdaki adları kullanarak
        // 4 test metodu oluşturun ve gerekli testleri yapin
    }

    @Test
    public void test02() {
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }
    @Test
    public void test03() {
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-logo'][1]")).isDisplayed());

    }
    @Test
    public void test04() {
        // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement aramaKutusuElementi= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(aramaKutusuElementi.isEnabled());
    }
    @Test
    public void test05() {
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertEquals("YouTube",driver.getTitle());
    }
}