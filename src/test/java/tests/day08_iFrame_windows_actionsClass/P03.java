package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P03 extends TestBase {
    @Test
    public void test01(){
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        String amazonWH= driver.getWindowHandle();
        // yeni bir tab olarak wise quarter'a gidelim
        driver.switchTo().newWindow(WindowType.TAB).get("https://wisequarter.com");
        String wisequarterWH= driver.getWindowHandle();
        // yeni bir sayfa olarak youtube'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://youtube.com");
        String youtubeWH= driver.getWindowHandle();
        // amazon'un acik oldugu sayfaya donun ve url'in amazon icerdigini test edin
        driver.switchTo().window(amazonWH);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        // wise quarter'in acik oldugu sayfaya gidin ve title'in Wise icerdigini test edin
        driver.switchTo().window(wisequarterWH);
        Assert.assertTrue(driver.getTitle().contains("Wise"));
        // youtube'un acik oldugu sayfaya gidin ve url'in youtube icerdigini test edin
        driver.switchTo().window(youtubeWH);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));
    }
}
