package tests.practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P08 extends TestBase {
    @Test
    public void test01(){

        //BeforeClass ile driver'i oluşturun ve class icinde static yapin
        //Maximize edin ve 10 sn bekletin
        //http://www.qooqle.com adresine gidin
        driver.get("http://www.google.com");
        //1-arama kutusuna "12 Angry Men" yaz ip, cikan sonuc şayisini yazdinin
        WebElement aramaKutusuElementi=driver.findElement(By.id("APjFqb"));
        aramaKutusuElementi.sendKeys("12 Angry Men"+ Keys.ENTER);
        //2-arama kutusuna "Vizontele" yaz ip, cikan sonuc şayisini yazdirin
        WebElement sonucSayisiElementi= driver.findElement(By.id("result-stats"));
        String sonucSayisi=sonucSayisiElementi.getText();
        System.out.println(sonucSayisi);
        System.out.println("-------------------------");
        //3-arama kutusuna "Saving Private Ryan" yaz4p, cikan sonuc şayisini yazdirin
        aramaKutusuElementi=driver.findElement(By.id("APjFqb"));
        aramaKutusuElementi.sendKeys("Saving Private Ryan"+ Keys.ENTER);
        sonucSayisiElementi= driver.findElement(By.id("result-stats"));
        sonucSayisi=sonucSayisiElementi.getText();
        System.out.println(sonucSayisi);
        //AfterClass ile kapatin.
    }
}
