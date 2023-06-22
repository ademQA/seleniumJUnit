package tests.Grup_BodyCalismasi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utilities.TestBase;

public class Q02 extends TestBase {
    @Test
    public void test02(){
        //1. Yeni bir Class olusturalim.C07_ManageWindowSet
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin

        driver.manage().window().setPosition(new Point(30,50));
        driver.manage().window().setSize(new Dimension(500,400));
        bekle(3);

        // 5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Dimension size=driver.manage().window().getSize();
        Dimension dimension=new Dimension(500,400);
        Assert.assertTrue(dimension.equals(size));

        Point position=driver.manage().window().getPosition();
        Point point=new Point(30,50);
       // Assert.assertTrue(point.equals(position));
        String size2=driver.manage().window().getSize().toString();
        System.out.println("------------------------");
        System.out.println(size2);
        Assert.assertEquals(size2,"(500, 400)");
        //Assert.assertEquals(point,position);

        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getPosition());
        // 6. Sayfayi kapatin
    }
}
