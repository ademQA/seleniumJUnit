package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class P01 extends TestBase {

    @Test
    public  void test01(){
        //Amazon sitesinin url'nin amazon içerdiğini test edin
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
    }
}
