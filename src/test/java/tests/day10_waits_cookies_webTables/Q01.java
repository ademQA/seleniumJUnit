package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Q01 extends TestBase {
    @Test
    public void test01() {
        //Explicit Wait
        //1. Bir class olusturun : EnableTest
        //2. Bir metod olusturun : isEnabled()
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement textboxElementi = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type=\"text\"]")).isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        WebElement enableElementi = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableElementi.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(textboxElementi));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]")).isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textboxElementi.isEnabled());


    }
}
