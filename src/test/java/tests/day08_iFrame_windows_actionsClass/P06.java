package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P06 extends TestBase {
    @Test
    public void test01(){
//1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
//2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions actions=new Actions(driver);
        WebElement dragElement= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropElement= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragElement,dropElement).perform();
//3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.tagName("p")).getText());
    }
}
