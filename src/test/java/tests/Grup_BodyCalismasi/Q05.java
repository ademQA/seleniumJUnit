package tests.Grup_BodyCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class Q05 {
    //1. Yeni bir class olusturun (TekrarTesti)
    //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
    //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
    //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
    //doğru URL'yi yazdırın.
    //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
    //5. Youtube sayfasina geri donun
    //6. Sayfayi yenileyin
    //7. Amazon sayfasina donun
    //8. Sayfayi tamsayfa yapin
    //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
    //Yoksa doğru başlığı(Actual Title) yazdırın.
    //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
    //doğru URL'yi yazdırın
    //11.Sayfayi kapatin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }
    public void bekle(int saniye)  {
        try {
            Thread.sleep(1000*saniye);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public  void test01() {
        driver.get("https://youtube.com");
        String expectedTitle = "youTube";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualtitle);
        if (!expectedTitle.equals(actualtitle)) {
            System.out.println(actualtitle);
        }
        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        //doğru URL'yi yazdırın.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "youtube";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        if (!actualUrl.contains(expectedUrl)) {
            System.out.println("dogru URl: " + actualUrl);
        }
        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        bekle(2);
        //5. Youtube sayfasina geri donun
        driver.navigate().back();
        //6. Sayfayi yenileyin
        driver.navigate().refresh();
        //7. Amazon sayfasina donun
        driver.navigate().forward();
        //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        if (!driver.getTitle().contains("Amazon")){
            System.out.println(driver.getTitle());
        }
        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
        //doğru URL'yi yazdırın
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.com/"));
        if (!driver.getCurrentUrl().equals("https://www.amazon.com/")){
            System.out.println(driver.getCurrentUrl());
        }
    }
    @Test
    public void test03(){
        System.out.println("test3 calıstı");
    }
    @Test
    public void test04(){
        System.out.println("test4 calıstı");
    }
    //11.Sayfayi kapatin
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
