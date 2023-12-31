package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    //  2) https://www.youtube.com adresine gidin
    //  3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
   static WebDriver driver;

   @BeforeClass
    public static void setup(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void teardown(){
      driver.close();
    }
@Test
    public void titleTest(){
       // ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    String titleElement=driver.getTitle();
    String expectedTitle="YouTube";
    Assert.assertEquals(expectedTitle,titleElement);
}
@Test
    public void imageTest(){
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    WebElement youtubeResimElement= driver.findElement(By.xpath("//yt-icon[@id='logo-icon'][1]"));
    Assert.assertTrue(youtubeResimElement.isDisplayed());
}
@Test
    public void searchBoxTest(){
    //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    WebElement aramaButonuElementi= driver.findElement(By.xpath("//div[@id='search-container']"));
    Assert.assertTrue(aramaButonuElementi.isEnabled());
}
@Test
    public void titleYoutubeTest(){
    //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    String wrongTitleElement=driver.getTitle();
    String unexpectedTitle="youtube";
    Assert.assertFalse(wrongTitleElement.equals(unexpectedTitle));
}



}
