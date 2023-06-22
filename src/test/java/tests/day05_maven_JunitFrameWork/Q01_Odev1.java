package tests.day05_maven_JunitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01_Odev1 {
    WebDriver driver;

    public void setup() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void amazonTesti() {
        //Class Work Amazon Search Test
        setup();
        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //2- arama kutusunu locate edelim
        WebElement aramaButonuElementi = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //3- “Samsung headphones” ile arama yapalim
        aramaButonuElementi.sendKeys("Samsung headphones");
        driver.findElement(By.id("nav-search-submit-button")).click();
        //4- Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucuElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String aramaSonucu = aramaSonucuElementi.getText();
        System.out.println(aramaSonucu);
        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        //6- Sayfadaki tum basliklari yazdiralim

        WebElement baslikElementi = driver.findElement(By.xpath("//table[@class='a-normal a-spacing-micro']"));
        String tumBaslik = baslikElementi.getText();
        System.out.println(tumBaslik);

    }

}
