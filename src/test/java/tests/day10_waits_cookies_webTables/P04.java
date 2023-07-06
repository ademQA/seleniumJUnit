package tests.day10_waits_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P04 extends TestBase {
    @Test
    public void test01() {
        //Web Tables
        //Bir Class olusturun D19_WebtablesHomework
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementList = driver.findElements(By.xpath("//div[@role='columnheader']"));
        int i = 1;
        for (WebElement eachBasliklar : baslikElementList
        ) {
            System.out.println(i + ".sütün " + eachBasliklar.getText());
            i++;
        }
        //3. 3.sutunun basligini yazdirin
        // System.out.println(driver.findElement(By.xpath("(//div[@role='columnheader'])[3]")).getText());
        System.out.println(baslikElementList.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDataElementList = driver.findElements(By.xpath("//div[@role='gridcell']"));
        int j = 1;
        for (WebElement eachdegerler : tumDataElementList
        ) {
            if (!eachdegerler.getText().isEmpty()){
            System.out.println(j + ".data " + eachdegerler.getText());
            j++;}
        }

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println(j);
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisiElementiList=driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println(satirSayisiElementiList.size());
        //7. Tablodaki sutun sayisini yazdirin

        List<WebElement>sutunElementList=driver.findElements(By.xpath("//div[@role='columnheader']"));
        System.out.println(sutunElementList.size());

        //8. Tablodaki 3.kolonu yazdirin
        System.out.println(sutunElementList.get(2).getText());

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    }
}