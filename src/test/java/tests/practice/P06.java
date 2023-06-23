package tests.practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

public class P06 extends TestBase {
    @Test
    public void test01() {
        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");
        //2 ) Nurse  3 farkli relative locator ile locate edin
        WebElement dr = driver.findElement(By.id("dr_thumb"));
        WebElement pl = driver.findElement(By.id("Policeman"));
        WebElement sl = driver.findElement(By.id("Seller"));

        WebElement nurse1=driver.findElement(RelativeLocator.with(By.tagName("img")).below(dr));
        WebElement nurse2=driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(pl));
        WebElement nurse3=driver.findElement(RelativeLocator.with(By.tagName("img")).above(sl));

        //3 ) Relative locator’larin dogru calistigini test edin
        Assert.assertTrue(nurse1.getAttribute("id").equals("nurs_thumb"));
        Assert.assertTrue(nurse2.getAttribute("id").equals("nurs_thumb"));
        Assert.assertTrue(nurse3.getAttribute("id").equals("nurs_thumb"));




    }
}
