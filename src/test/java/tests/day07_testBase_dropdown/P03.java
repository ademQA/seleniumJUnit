package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P03 extends TestBase {
    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDownElementi = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDownElementi);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //  4.Tüm dropdown değerleri(value) yazdırın
        //    dropdown'daki elementleri bir liste olarak alabiliriz
        List<WebElement> optionElementleriList = select.getOptions();

        for (WebElement each:optionElementleriList) {
            System.out.println(each.getText());
        }

        //  5. Dropdown’un boyutunun 4 olduğunu test edin
        System.out.println(select.getOptions().size());
        Assert.assertEquals(select.getOptions().size(),4);

    }
}