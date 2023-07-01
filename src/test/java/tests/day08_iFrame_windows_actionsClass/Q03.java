package tests.day08_iFrame_windows_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q03 extends TestBase {
    @Test
    public void test01() {
        //Keyboard Actions Homework
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement overElement= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions=new Actions(driver);
        //actions.scrollToElement(overElement).perform();
        actions.moveToElement(overElement).perform();
        //3- Link 1" e tiklayin
        WebElement link1= driver.findElement(By.xpath("//a[text()='Link 1']"));
        actions.moveToElement(link1).click().perform();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickElement=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickElement).perform();
        bekle(3);
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickElement.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleElement=driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.moveToElement(doubleElement).doubleClick().perform();
    }
}
