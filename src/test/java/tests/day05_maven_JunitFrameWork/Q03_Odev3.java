package tests.day05_maven_JunitFrameWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q03_Odev3 extends TestBase {
    @Test
    public void test01(){
    //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
    //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement urunElement=driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]"));
        String urunIsim=urunElement.getText();
        System.out.println(urunIsim);
        urunElement.click();
    //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_badge")).click();
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepettekiUrunIsim=driver.findElement(By.className("inventory_item_name")).getText();
        System.out.println(sepettekiUrunIsim);
        Assert.assertEquals(sepettekiUrunIsim,urunIsim);
    //9. Sayfayi kapatin
}
}