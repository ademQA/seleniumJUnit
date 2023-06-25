package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P05 extends TestBase {
    @Test
    public void test01() {
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //  Username     : admin
        //  password      : admin
        ////4- Basarili sekilde sayfaya girildigini dogrulayin
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertTrue(driver.findElement(By.tagName("p")).isDisplayed());
    }
}