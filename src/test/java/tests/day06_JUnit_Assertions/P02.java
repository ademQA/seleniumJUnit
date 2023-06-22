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

public class P02 {
    //2) https://www.bestbuy.com/ Adresine gidin
    //   farkli test method’lari olusturarak asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

   static WebDriver driver;
   @BeforeClass
   public static void setup(){
    driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void teardown(){
       driver.close();
    }
    @Test
    public void test01(){
      // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
       String actualUrl=driver.getCurrentUrl();
       String expectedUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    public void test02(){
       // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle= driver.getTitle();
        String unExpectedTitle="Rest";
        Assert.assertFalse(actualTitle.contains(unExpectedTitle));
    }
    @Test
    public void test03(){
       // ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo=driver.findElement(By.xpath("//img[@alt='Best Buy Logo'][1]"));
   Assert.assertTrue(logo.isDisplayed());
   }
  @Test
   public void test04(){
       //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
      WebElement linkElement= driver.findElement(By.xpath("//button[@lang='fr']"));
      Assert.assertTrue(linkElement.isDisplayed());
   }

}
