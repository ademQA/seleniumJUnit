package tests.Grup_BodyCalismasi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q09 extends TestBase {
    @Test
    public void test01(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys("nutella").keyUp(Keys.SHIFT).sendKeys("nutella").perform();
        actions.sendKeys(Keys.ENTER).perform();
        WebElement target = driver.findElement(By.xpath("(//div[@class=\"a-section aok-relative s-image-square-aspect\"])[39]"));
        //actions.scrollToElement(target).perform();
        target.click();


    }
}
