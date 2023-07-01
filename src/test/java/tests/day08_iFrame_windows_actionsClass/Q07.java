package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q07 extends TestBase {
    @Test
    public void test01() {
        //Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement listElement= driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(listElement).perform();
        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

     String sonucElement=driver.findElement(By.xpath("//div[@role='heading']")).getText();
     Assert.assertTrue(sonucElement.contains("Your Lists"));
    }
}