package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.HashSet;
import java.util.Set;

public class P04 extends TestBase {
    @Test
    public void test01(){
//● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH= driver.getWindowHandle();
        System.out.println(ilkSayfaWH);
//● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"Opening a new window");
//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
       Assert.assertEquals("The Internet",driver.getTitle());
//● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        System.out.println(driver.getWindowHandles());
        Set<String>WHDegerleri=driver.getWindowHandles();
        String ikinciSayfaWH="";
        for (String each:WHDegerleri) {
            if (!each.equals(ilkSayfaWH)){
                ikinciSayfaWH=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWH);
        System.out.println(ikinciSayfaWH);
        Assert.assertEquals("New Window",driver.getTitle());

//● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.findElement(By.tagName("h3")).getText());
//● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWH);
        Assert.assertEquals("The Internet",driver.getTitle());
    }
}
