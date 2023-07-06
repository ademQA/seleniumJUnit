package tests.day12_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03 extends TestBase {
    @Test
    public void test01() {
        // wisequarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");
        // jsExecutor kullanarak contact linkini tiklayin

        WebElement contactElement = driver.findElement(By.xpath("//a[@class='ekit-menu-nav-link']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", contactElement);
        bekle(2);
        // anasayfaya geri donun
        driver.navigate().back();


        // asagida bulunan “Go To Career Page” butonuna kadar asagi inin ve bu butona click yapin

        WebElement gotoElementi = driver.findElement(By.xpath("//*[@class='fas fa-paper-plane']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", gotoElementi);
        bekle(5);
        Actions actions=new Actions(driver);
        actions.moveToElement(gotoElementi).click().perform();

        //alert ekleyin
        jse.executeScript("alert('yasasinnnn');");
        bekle(3);
    }
}
