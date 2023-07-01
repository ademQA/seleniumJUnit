package tests.day07_testBase_dropdown;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q02 extends TestBase {
    @Test
    public void test01() {
        //Handle Dropdown
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        //4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password.");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.className("brand")).click();
        driver.findElement(By.id("online-banking")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        //8. “Currency” drop down menusunden Eurozone’u secin
        // 9. “amount” kutusuna bir sayi girin
        //10. “US Dollars” in secilmedigini test edin
        //11. “Selected currency” butonunu secin
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
    }
}