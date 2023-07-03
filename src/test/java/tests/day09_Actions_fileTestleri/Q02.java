package tests.day09_Actions_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q02 extends TestBase {
    @Test
    public void test01() {
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video’yu gorecek kadar asagi inin
        WebElement codeExampleElementi= driver.findElement(By.id("Code_Example"));
        codeExampleElementi.click();

        // 4- videoyu izlemek icin Play tusuna basin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //5- videoyu calistirdiginizi test edin
    }
}