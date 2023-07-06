package tests.day12_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class P02 extends TestBase {
    @Test
    public void test01() {
        // google'a gidelim
driver.get("https://google.com");
        // cikiyorsa cookies reddedin

        // nutella aratalim
        driver.findElement(By.id("APjFqb")).sendKeys("Nutella"+ Keys.ENTER);

        // arama sonuc sayisinin screenshot'ini alalim
        WebElement aramaSonucuElementi= driver.findElement(By.id("result-stats"));
        ReusableMethods.webElementFotoCek(driver,aramaSonucuElementi);
    }
}