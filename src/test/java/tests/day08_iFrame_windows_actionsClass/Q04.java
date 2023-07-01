package tests.day08_iFrame_windows_actionsClass;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Q04 extends TestBase {
    @Test
    public void test01() {
        //Faker Kutuphanesi
        //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin
        // fake degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Faker faker = new Faker();


        //3. “firstName” giris kutusuna bir isim yazin
        WebElement isim = driver.findElement(By.xpath("//input[@name='firstname']"));
        isim.sendKeys(faker.name().firstName());

        //4. “surname” giris kutusuna bir soyisim yazin
        WebElement soyisim = driver.findElement(By.xpath("//input[@name='lastname']"));
        soyisim.sendKeys(faker.name().lastName());

        //5. “email” giris kutusuna bir email yazin
        WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
       String emailad=faker.internet().emailAddress();
        email.sendKeys(emailad);

        //6. “email” onay kutusuna emaili tekrar yazin
        WebElement emailTekrar = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        emailTekrar.sendKeys(emailad);


        //7. Bir sifre girin
        WebElement sifre=driver.findElement(By.id("password_step_input"));
        sifre.sendKeys(faker.internet().password(8,16));

        //8. Tarih icin gun secin
        WebElement dropDownElementgun= driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select select=new Select(dropDownElementgun);
        select.selectByValue("11");


        //9. Tarih icin ay secin
        WebElement dropDownElementay= driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select select1=new Select(dropDownElementay);
        select1.selectByValue("8");

        //10. Tarih icin yil secin
        WebElement dropDownElementyil= driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select select2=new Select(dropDownElementyil);
        select2.selectByValue("1978");

        //11. Cinsiyeti secin
        WebElement radioButonElementi=driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
        radioButonElementi.click();

        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement radioButonElementi2=driver.findElement(By.xpath("(//label[@class='_58mt'])[1]"));
        WebElement radioButonElementi3=driver.findElement(By.xpath("(//label[@class='_58mt'])[3]"));

boolean seciliDurum=radioButonElementi.isSelected();
boolean seciliOlmamaDurumu=!(radioButonElementi3.isSelected() ||radioButonElementi2.isSelected());
        Assert.assertTrue(seciliOlmamaDurumu && seciliOlmamaDurumu);
        //13. Sayfayi kapatin
    }
}