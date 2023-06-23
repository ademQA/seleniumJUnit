package tests.practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class P05 extends TestBase {
    @Test
    public void test01() {
//   1-Driver oluşturalim
//    2-Java class'imiza chnomedriver. exetyi tanitalim
//    3-Driver'in tum ekranı kaplamasini sagu ayalim
//    4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
//     Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.
//    5-Navigate to http://www.babayigit.net/murat/testpage.html
        driver.get("http://www.babayigit.net/murat/testpage.html");
//    6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
//        alanlarına gerekli bilgileri yazsın
        driver.findElement(By.id("ad")).sendKeys("Adem"+ Keys.ENTER);
        bekle(3);
        driver.findElement(By.id("soyad")).sendKeys("Tekinel");
        driver.findElement(By.id("yas")).sendKeys("45");
        driver.findElement(By.id("meslek")).sendKeys("QA");
        driver.findElement(By.id("mezun_okul")).sendKeys("KOÜ");
        driver.findElement(By.id("dogum_yeri")).sendKeys("Bartın");
        driver.findElement(By.id("cocuk_sayisi")).sendKeys("3");

//    7-Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//    8- All information was entered correctly.. yazısının göründüğünü test etsin
String metin=driver.findElement(By.id("uyari")).getText();
        Assert.assertTrue(driver.findElement(By.id("uyari")).isDisplayed());
//    9- Clear butonu ile tüm butonları temizlesin
        driver.findElement(By.xpath("//input[@type='reset']")).click();
//    10- Manuel olarak temizlendiğini görecek kadar beklesin
        bekle(3);
//    11- Sayfayı kapatsın
        driver.close();
//    12-8. maddededeki Test sonucunu yazdırsın
        System.out.println(metin);
    }
}