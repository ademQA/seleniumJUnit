package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P02 extends TestBase {
    @Test
    public void test01(){
        // amazon ana sayfaya gidin
        driver.get("https://amazon.com");
// url'in amazon icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
// Yeni bir tab olarak wise quarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://wisequarter.com");
// title'in Wise icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Wise"));

// yeni bir window acarak youtube sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://youtube.com");
// url'in youtube icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));

// acilan tum sayfalari kapatin
        driver.quit();

    }
}
