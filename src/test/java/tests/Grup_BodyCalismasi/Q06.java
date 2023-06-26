package tests.Grup_BodyCalismasi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class Q06 extends TestBase {

    @Test
    public void test01(){
        // 1- https://www.amazon.com/ adresine gidin
        driver.get(" https://www.amazon.com/");
        String WHDAmazon = driver.getWindowHandle();
        // 2- Sag ust bolumde bulunan “Account & Lists” menusunun
        //     acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement accountElementi = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(accountElementi).perform();
        // 3- “Create a list” butonuna basin
        WebElement createElementi = driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        createElementi.click();
        // 4-Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String expectedYazi = "Your Lists";
        String actualYazi = driver.findElement(By.id("my-lists-tab")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        // 5- YouTube yi yeni bir tab da açin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        // 6- amazon sayfasina geri dönun
        driver.switchTo().window(WHDAmazon).get(" https://www.amazon.com/");
    }
}
