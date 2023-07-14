package tests.practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P09 extends TestBase {
    @Test
    public void test01(){
      driver.get("https://google.com");
      String ilkSayfaWHD=driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Google"));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https:wisequarter.com");
        String ikinciSayfaWHD=driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Wise"));
        driver.switchTo().window(ilkSayfaWHD);
        driver.get("https://amazon.com");
        String ucuncuWHD=driver.getTitle();
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("wisequarter"));
        driver.quit();

    }
}
