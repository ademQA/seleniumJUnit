package tests.Grup_BodyCalismasi;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;
public class Q03 extends TestBase{

        @Test
        public void test01(){
            //2- https://www.google.com/ adresine gidin
            driver.get("https://www.google.com/");
            bekle(3);
            //3- cookies uyarisini kabul ederek kapatin
            //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
            String expectedTitle = "Google";
            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualTitle.contains(expectedTitle));
            //5- Arama cubuguna “Nutella” yazip aratin
            driver.findElement(By.id("APjFqb")).sendKeys("Nutella"+ Keys.ENTER);
            //6- Bulunan sonuc sayisini yazdirin
            String sonucStr = driver.findElement(By.id("result-stats")).getText();
            String[] sonucArr = sonucStr.split(" ");
            int sonucRakam = Integer.parseInt(sonucArr[1].replace(".",""));
            System.out.println(sonucRakam);
            //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
            int expectedResult = 10000000;
            int actualResult = sonucRakam;
            Assert.assertTrue(expectedResult<actualResult);
            //8- Sayfayi kapatin
            driver.close();
        }

    }
