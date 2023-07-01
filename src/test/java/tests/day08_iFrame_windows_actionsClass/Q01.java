package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClass;

import java.util.List;

public class Q01 extends TestBaseBeforeClass {
    @Test
    public void test01() {
        //Genel Tekrar Homework
        //Test01 : 1- amazon gidin
        driver.get("https://amazon.com");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownElement);
        List<WebElement> dropDownElementList = select.getOptions();
        for (WebElement eachDropDown : dropDownElementList) {
            System.out.println(eachDropDown.getText());
        }
        // 3- dropdown menude 28 eleman olduğunu doğrulayın
        int elemanSayisi = select.getOptions().size();
        System.out.println(elemanSayisi);
        Assert.assertEquals(elemanSayisi, 28);
    }

    @Test
    public void test02() {
//Test02
        //1- dropdown menuden elektronik bölümü seçin
        WebElement dropDownElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownElement);
        select.selectByIndex(10);
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
        // 3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("iphone"));
        //4- ikinci ürüne relative locater kullanarak tıklayin
        //  WebElement solElement=driver.findElement(By.xpath("//img[@alt='JETech Screen Protector Compatible with iPhone 13 mini 5.4-Inch, Tempered Glass Film, 3-Pack']"));
        //WebElement ikinciUrun=dropDownElement.findElement(RelativeLocator.with(By.className("s-image")).toLeftOf(solElement));
        //ikinciUrun.click();

        driver.findElement(By.xpath("(//img[@class='s-image'])[2]")).click();
        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String title1 = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String fiat1 = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[2]")).getText();
        driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])")).click();
    }

    @Test
    public void test03() {
        //Test03
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://amazon.com");
        // 2-dropdown’dan bebek bölümüne secin
        WebElement dropDownElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownElement);
        List<WebElement> dropDownElementList = select.getOptions();
        select.selectByIndex(3);
        //3-bebek toys aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("toys" + Keys.ENTER);

        //4-sonuç yazsının toys içerdiğini test edin
        String sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("toys"));
        Assert.assertTrue(sonucYazisi.contains("toys"));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//img[@class='s-image'])[3]")).click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String title0 = driver.findElement(By.id("titleSection")).getText();
        String fiat0 = driver.findElement(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();

    }

    @Test
    public void test04() {
//Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.findElement(By.id("nav-cart-count-container")).click();
        String baslik1 = driver.findElement(By.xpath("a-truncate-cut")).getText();
        String fiyat1 = driver.findElement(By.xpath("(//div[@class='sc-badge-price-to-pay'])[1]")).getText();

        String baslik2 = driver.findElement(By.xpath("(//span[@class='a-truncate-full a-offscreen'])[1]")).getText();
        String fiyat2 = driver.findElement(By.xpath("(//div[@class='sc-item-price-block-badge'])[1]")).getText();


        String title0 = driver.findElement(By.id("titleSection")).getText();
        String fiat0 = driver.findElement(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
Assert.assertEquals(title0,baslik1);
    }
}
