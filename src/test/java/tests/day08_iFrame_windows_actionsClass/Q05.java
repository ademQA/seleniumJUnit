package tests.day08_iFrame_windows_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q05 extends TestBase {
    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        WebElement hesapOlusturElementi = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hesapOlusturElementi).click().perform();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']")).sendKeys("adem" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("tekinel" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("ademtekinel@yahoo.com" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("12345678" + Keys.ENTER);
        bekle(3);
        // 4- Kaydol tusuna basalim
        driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _6o _6v']")).click();
    }
}