package tests.day09_Actions_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03 extends TestBase {
    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimElement= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.click(isimElement).sendKeys("adem").sendKeys(Keys.TAB).sendKeys("tek").
                sendKeys(Keys.TAB).sendKeys("acd@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("acd@gmail.com").sendKeys(Keys.TAB).sendKeys("12345678").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("11").sendKeys(Keys.TAB).sendKeys("mart").sendKeys(Keys.TAB).sendKeys("2000").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).click().perform();

        bekle(3);
        //4- Kaydol tusuna basalim
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        bekle(10);
    }
}