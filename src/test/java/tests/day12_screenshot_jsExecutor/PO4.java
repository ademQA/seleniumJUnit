package tests.day12_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class PO4 extends TestBase {
    @Test
    public void test01() {


        //Test Senaryosu

        //1. Tarayıcıyı açın.
        //2. https://www.hepsiburada.com adresine gidin.
        driver.get("https://www.hepsiburada.com");

        bekle(3);
        //3. Çerez tercih kısmında çerezleri kabul edin.
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElement(By.xpath("//div[@class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']")).click();
        bekle(3);
        //4. Arama kutusuna "iphone 14" yazın ve arayın.
        WebElement aramaKutusu = driver.findElement(By.xpath("//div[@class='theme-PWhtyMC28ov8fuPKvrog']"));
        bekle(3);
        driver.switchTo().activeElement().sendKeys("phone 14");
        driver.findElement(By.xpath("//div[@class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']")).click();



        //5. Sonuçların görüntülendiğini kontrol edin.

        //6. Sol taraftaki "Ürün Çeşidi" filtresinden "iPhone 14 Plus" seçin.

        //7. Çıkan ürünlerden 2. ürünün fiyatını alın.

        //8. İkinci ürüne tıklayın.

        //9. Açılan sayfada, önceki sayfada alınan ürün fiyatıyla karşılaştırma yaparak ürünün doğruluğunu kontrol edin.
        // Kuruşlar önemli değildir.

        //10. Ek hizmet için ekleme yapılsın.

        //11. "Sepete Ekle" düğmesine tıklayın.

        //12. Açılan Popup da "Ürün sepetinizde" ibaresinin göründüğünü kontrol edin.

        //13. "Sepete Git" düğmesine tıklayın.

        //14. Sepet ekranında olduğu kontrol edilsin.

        //15. Miktar kısmından miktarı 1 artırın.

        //16. “*Ürünlerin seçtiğin satıcılardan tedarik edilemiyor.”* ibaresi kontrol edilsin.

        //17. "Sil" düğmesine tıklayın.

        //18. "*Sepetin şu an boş*." ibaresinin göründüğünü kontrol edin.

    }
}


