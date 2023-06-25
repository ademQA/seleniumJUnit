package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClass;

public class P04 extends TestBaseBeforeClass {
    @Test
    public void test01() {
        //1. Test
        //  -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //  - 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        //  -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String alertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(alertYazisi,"I am a JS Alert");

        //  -  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02() {
        //2.Test
        //  - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //  - 2.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        //  - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Cancel");
    }

    @Test
    public void test03() {
        //3.Test
        //  - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //  - 3.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        //  - Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        //  - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //  - Cikan sonuc yazisinin Abdullah icerdigini test edelim
       Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("Abdullah"));

    }
}