package tests.day09_Actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P05 extends TestBase {
    @Test
    public void test01() {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // 3. avatar.png dosyasını indirelim
        WebElement dosyaElementi= driver.findElement(By.xpath("//a[text()='60.pdf']"));
        dosyaElementi.click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dinamikDosyaYolu=System.getProperty("user.home")+"/Downloads/60.pdf";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}