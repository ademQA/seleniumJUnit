package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class Q03 extends TestBase {

    @Test
    public void test01() {
        //Window Handle Homework
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkWHD = driver.getWindowHandle();

        //2."Login Portal" a kadar asagi inin
        WebElement loginElement = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));

        //3."Login Portal" a tiklayin
        loginElement.click();

        //Actions actions=new Actions(driver);
        //actions.moveToElement(loginElement).click();

        //4.Diger window'a gecin

        String ikinciWHD = "";
        Set<String> wHDegerleri = driver.getWindowHandles();
        for (String eachWHD : wHDegerleri) {
            if (!eachWHD.equals(ilkWHD))
                ikinciWHD = eachWHD;
        }
        driver.switchTo().window(ikinciWHD);

        //5."username" ve "password" kutularina deger yazdirin
        bekle(3);
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sdv");

        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        bekle(2);
        String popuptext = driver.switchTo().alert().getText();
        Assert.assertEquals("validation failed",popuptext);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkWHD);

        //10.Ilk sayfaya donuldugunu test edin

        Assert.assertEquals(ilkWHD,driver.getWindowHandle());
    }

}
