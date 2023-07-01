package tests.day05_maven_JunitFrameWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Q02_Odev2 extends TestBase {
    @Test
    public void test01(){
    //1- C01_TekrarTesti isimli bir class olusturun

    //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
    //3- cookies uyarisini kabul ederek kapatin
    //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Google") );
    // 5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.id("APjFqb")).sendKeys("Nutella"+ Keys.ENTER);
    //6- Bulunan sonuc sayisini yazdirin
        String sonucElement=driver.findElement(By.id("result-stats")).getText();
        String[] sonucSayisiArr=sonucElement.split(" ");
        String sonuc=sonucSayisiArr[1];
        sonuc=sonuc.replace(".","");
        int sonucSayisi=Integer.valueOf(sonuc);
        System.out.println(sonucSayisi);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        Assert.assertTrue(sonucSayisi>10000000);

    // 8- Sayfayi kapatin
}
}