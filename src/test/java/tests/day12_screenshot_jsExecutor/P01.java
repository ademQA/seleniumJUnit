package tests.day12_screenshot_jsExecutor;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class P01 extends TestBase {
    @Test
    public void test01() {
        // wisequarter ana sayfaya gidin
        driver.get("https://wisequarter.com");

        // url'in wise icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("wise"));

        // tum sayfa screenshot alin
        ReusableMethods.tumSayfaFotoCek(driver);


    }
}