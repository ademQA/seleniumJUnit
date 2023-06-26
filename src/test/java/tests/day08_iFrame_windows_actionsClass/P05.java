package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05 extends TestBase {
    @Test
    public void test01() {
//2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
//3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
//4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

//5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
//6- Elemental Selenium linkine tiklayalim
driver.findElement(By.xpath("//img[@alt='Elemental Selenium Logo']")).click();
//7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

        Assert.assertEquals(driver.findElement(By.tagName("Make sure your code lands")).getText(),"Make sure your code lands");
    }
}
