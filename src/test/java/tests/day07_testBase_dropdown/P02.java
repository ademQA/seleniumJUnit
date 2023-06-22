package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P02 extends TestBase {

    @Test
    public void test02() {
        // Amazon anasayfaya gidin
        driver.get("https://amazon.com");

// arama kutusunun yanindaki dropdown menude 28 secenek oldugunu test edin
        WebElement dropdownElementi = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdownElementi);
        int actualOptionSayisi = select.getOptions().size();
        int expectedOptionSayisi = 28;
        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);
        System.out.println(actualOptionSayisi);

// dropdown menuden Baby kategorisini secin
        select.selectByVisibleText("Baby");
// Arama kutusuna Nutella yazip aratin
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("nutella" + Keys.ENTER);
// bulunan sonuc sayisinin 10'dan fazla oldugunu test edin
        WebElement actualSonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualElementArr = actualSonucElementi.getText();
        int actualSonucSayisi = Integer.valueOf(actualElementArr.substring(0, actualElementArr.indexOf(" ")));
        System.out.println(actualSonucSayisi);
        Assert.assertTrue(actualSonucSayisi > 5);
// sectigimiz opsiyonu yazdirin
         dropdownElementi = driver.findElement(By.id("searchDropdownBox"));
        select=new Select(dropdownElementi);
        List<WebElement> option = select.getOptions();
        for (WebElement eachOption:option)
        {eachOption.getText();

        }
// sectigimiz opsiyon'un Baby oldugunu test edin
        driver.findElement(By.id("searchDropdownBox"));
       select=new Select(dropdownElementi);
        String expectedSeciliOption = "Baby";
        String actualSeciliOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedSeciliOption,actualSeciliOption);
        bekle(3);
    }
}