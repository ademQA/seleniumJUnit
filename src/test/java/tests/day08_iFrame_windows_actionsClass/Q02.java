package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q02 extends TestBase {
    //Keyboard Actions Homework
    @Test
    public void test01() {
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        Actions actions = new Actions(driver);
        WebElement videoElement = driver.findElement(By.xpath("(//div[@class='render'])[1]"));
        // 3- video’yu gorecek kadar asagi inin
        actions.scrollToElement(videoElement).perform();

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframeElement = driver.findElement(By.xpath("(//iframe[@width='560'])"));
        iframeElement.click();
        //5- videoyu calistirdiginizi test edin
        Assert.assertTrue(iframeElement.isDisplayed());
    }
}