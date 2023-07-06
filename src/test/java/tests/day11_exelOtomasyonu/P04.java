package tests.day11_exelOtomasyonu;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class P04 extends TestBase {
    @Test
    public void test01() throws IOException {
        //1- amazon anasayfaya gidin
        driver.get("https://amazon.com");
        // Nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        // Sonuclarin Nutella icerdigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText().contains("Nutella"));
        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfaSS = new File("target/ekranResmi/tumEkranResmi.png");
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya, tumSayfaSS);


    }
}
