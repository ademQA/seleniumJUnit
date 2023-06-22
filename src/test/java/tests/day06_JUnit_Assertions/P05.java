package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.close();
    }

   @Test
    public void facebookTest() throws InterruptedException {
        //  a. Verilen web sayfasına gidin.
        //       https://facebook.com
       driver.get("https://facebook.com");
        //  b. Cookies’i kabul edin
      // driver.findElement(By.xpath("//button[text()='Tüm çerezlere izin ver']")).click();
        //  c. Create an account buton’una basin
       driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //  d. Radio button elementlerini locate edin ve size uygun olani secin
      Thread.sleep(3000);
       WebElement radioButonElement1=driver.findElement(By.xpath("//label[text()='Kadın']"));
       WebElement radioButonElement2=driver.findElement(By.xpath("//label[text()='Erkek']"));
       radioButonElement2.click();
       Thread.sleep(3000);
       WebElement radioButonElement3= driver.findElement(By.xpath("//label[text()='Özel']"));
        //  e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
       Assert.assertTrue(radioButonElement2.isSelected());
       Assert.assertFalse(radioButonElement1.isSelected());
       Assert.assertFalse(radioButonElement3.isSelected());
       Thread.sleep(3000);
    }
}
