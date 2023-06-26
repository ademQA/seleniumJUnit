package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P01 extends TestBase {
    @Test
    public void test01(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isEnabled());
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        // - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);
        WebElement textBoxElementi=driver.findElement(By.id("tinymce"));
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya!");
        //driver.findElement(By.className("mce-content-body ")).sendKeys("Merhaba Dunya!");
        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text() ='Elemental Selenium']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text() ='Elemental Selenium']")));

    }
}
