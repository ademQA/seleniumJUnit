package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class P03 extends TestBase {
    @Test
    public void test01() {
        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(2);
        //3.Web table tum body’sini yazdirin
        WebElement tableElementi=driver.findElement(By.xpath("//tbody"));
        System.out.println(tableElementi.getText());

        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement>satirlarList=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(satirlarList.size()==9);

        //5.Tum satirlari yazdirin
        int i=1;
        for (WebElement eachTumSatirlar:satirlarList
             ) {
            System.out.println(i+".satır :"+eachTumSatirlar.getText());
            i++;

        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin

        List<WebElement>sutunList=driver.findElements(By.xpath("//tbody/tr[1]/td"));
        Assert.assertTrue(sutunList.size()==13);
        //7. 5.sutunu yazdirin
       List <WebElement> besinciSutunElementi=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        int j=1;
        for (WebElement eachSutun:besinciSutunElementi
        ) {
            System.out.println(j+".satır :"+eachSutun.getText());
            j++;

        }
bekle(3);
        System.out.println("-------------------------");
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(ReusableMethods.hucredekiYaziyiGetir(3, 5,driver));
    }
}