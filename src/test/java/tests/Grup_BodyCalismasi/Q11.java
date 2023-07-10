package tests.Grup_BodyCalismasi;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q11 extends TestBase {
    //hesap butonunu locate et ve tıkla
    //yeni hesap oluştur butonuna tıkla
    //faker class ını kullanarak formu doldur
    //kaydet butonuna tıkla
    @Test
    public void test01(){
        //"https://www.ikea.com.tr" adresine git
        driver.get("https://www.ikea.com.tr");
        WebElement hesapElementi = driver.findElement(By.xpath("//a [@href=\"/uyelik/uye-girisi\"]"));
        hesapElementi.click();
        WebElement uyeOl = driver.findElement(By.xpath("//a[@class=\"btn btn-gray btn-block sign-btn\"]"));
        uyeOl.click();
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String isim = faker.name().firstName();
        String soyisim = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String telNum = faker.phoneNumber().cellPhone();
        String pasworld = faker.internet().password(10,20);
        WebElement isimKutuElementi = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName"));
        actions.click(isimKutuElementi)
                .sendKeys(isim)
                .sendKeys(Keys.TAB)
                .sendKeys(soyisim)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(telNum)
                .sendKeys(Keys.TAB)
                .sendKeys(pasworld)
                .sendKeys(Keys.TAB)
                .sendKeys(pasworld)
                .perform();
        System.out.println(pasworld);
        WebElement checkbox1 = driver.findElement(By.xpath("(//div[@class=\"form-group\"])[7]"));
        checkbox1.click();
        WebElement kaydeyButonElementi = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmitRegister"));
        kaydeyButonElementi.click();
    }
}
