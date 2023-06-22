package tests.Grup_BodyCalismasi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q01 extends TestBase {
    @Test
    public void test01() {
        //1. Yeni bir package olusturalim : day01
        //2. Yeni bir class olusturalim : C03_GetMethods
        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //4. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="Amazon";
        //System.out.println(actualTitle);
        //Assert.assertTrue(actualTitle.contains(expectedTitle));
        Assert.assertTrue(actualTitle.contains("Amazon"));
        //6. Sayfa adresini(url) yazdirin
        driver.getCurrentUrl();
        //7. Sayfa url’inin “amazon” icerdigini test edin.
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        System.out.println(driver.getCurrentUrl());
        //8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin 10. Sayfayi kapatin.
        String htmlKodlari=driver.getPageSource();
        System.out.println(htmlKodlari);
        Assert.assertTrue(htmlKodlari.contains("alisveris"));
    }
}