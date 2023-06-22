package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    static WebDriver driver;

  @BeforeClass
    public static void setup(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https:amazon.com");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    // Amazon anasayfaya gidin
    // 3 farkli test method'u olusturup, verilen testleri yapin
    // 1- url'in amazon icerdigini test edin
    // 2- Nutella arattirin ve sonuclarin nutella icerdigini test edin
    // 3- ilk urune click yapip, urun isminin Nutella icerdigini test edin
    @Test
    public void test01(){
        // 1- url'in amazon icerdigini test edin
      String actualUrl=driver.getCurrentUrl();
      String expectedUrl="amazon";
      if (actualUrl.contains(expectedUrl))
      {System.out.println("Url Test PASSED");}
      else {
          System.out.println("Url Test FAİLED");
          throw new RuntimeException();
      }
    }
    @Test
    public void test02(){
        // 2- Nutella arattirin ve sonuclarin nutella icerdigini test edin
WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
  aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
  WebElement sonucKutusu= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
  String actualSonuc=sonucKutusu.getText();
  String expectedSonuc="nutella";
  if (actualSonuc.contains(expectedSonuc)){
      System.out.println("Nutella Test PASSED");
  }else {
      System.out.println("Nutella Test FAİLED");
      throw new RuntimeException();
  }
  }
  @Test
  public void test03(){
      // 3- ilk urune click yapip, urun isminin Nutella icerdigini test edin
      driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]")).click();
WebElement ilkUrun= driver.findElement(By.xpath("//span[@id='productTitle']"));
String actualUrun=ilkUrun.getText();
String expectedUrun="Nutella";
if (actualUrun.contains(expectedUrun)){
    System.out.println("İlk urun Test PASSED");
}else{
    System.out.println("İlk urun Test FAİLED");
throw new RuntimeException();}
  }
}
