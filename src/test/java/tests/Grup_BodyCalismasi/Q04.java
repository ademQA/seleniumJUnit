package tests.Grup_BodyCalismasi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClass;
public class Q04 extends TestBaseBeforeClass{
    // https://www.amazon.com/ adresine gidin.
    //- Test 1
    // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    // oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void test01(){
        // https://www.amazon.com/ adresine gidin.
        driver.navigate().to("https://www.amazon.com/");
        //- Test 1
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
        // oldugunu test edin
        WebElement dropDownElement = driver.findElement(By.id("searchDropdownBox"));
        Select select =  new Select(dropDownElement);
        int expectedOptionSayisi =28;
        int actualOptionSayisi = select.getOptions().size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
    }
    @Test
    public void test02(){
        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        WebElement dropDownElement = driver.findElement(By.id("searchDropdownBox"));
        Select select =  new Select(dropDownElement);
        select.selectByVisibleText("Books");
        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucElement = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(sonucElement.getText());
        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik = "Java";
        String actualSonuc = sonucElement.getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));
    }

}
