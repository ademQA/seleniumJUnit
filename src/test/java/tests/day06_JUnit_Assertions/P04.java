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

public class P04 {
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
    public void test01(){
    //  a. Verilen web sayfasına gidin.
//       https://the-internet.herokuapp.com/checkboxes
    driver.get("https://the-internet.herokuapp.com/checkboxes");
//  b. Checkbox1 ve checkbox2 elementlerini locate edin.
    WebElement checkbox1= driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
    WebElement checkbox2= driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
//  c. Checkbox1 seçili değilse onay kutusunu tıklayın
    if (!checkbox1.isSelected())
    { checkbox1.click();}
    if (!checkbox2.isSelected())
    { checkbox2.click();}
    Assert.assertTrue(checkbox1.isSelected());
    Assert.assertTrue(checkbox2.isSelected());

//  d. Checkbox2 seçili değilse onay kutusunu tıklayın
//  e. Checkbox1 ve Checkbox2’nin seçili olduğunu test edin
}


}

