package tests.day09_Actions_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q01 extends TestBase {
    @Test
    public void test01() {
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("https://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverElementi = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.click(hoverElementi).perform();


        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        bekle(1);
        //5.5-Tab tuşuyla hover over ... elementinin üzerine gelip tıklayınız.
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).keyDown(Keys.ENTER).perform();
        bekle(3);

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickandHoldElement = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickandHoldElement).perform();

        bekle(3);
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.id("click-box")).getText());

        //8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.id("double-click"))).perform();

    }
}
