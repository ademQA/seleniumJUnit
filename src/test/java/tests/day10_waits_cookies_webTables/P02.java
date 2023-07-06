package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02 extends TestBase {
    @Test
    public void test01() {
        //1- Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //2- tum cookie’leri listeleyin
      Set<Cookie>cookiesSeti= driver.manage().getCookies();
      int i=1;
        for (Cookie eachCookies:cookiesSeti
             ) {
            System.out.println(i+ ".cookies: "+eachCookies);
            i++;

        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cokiesSayisi=cookiesSeti.size();
        System.out.println(cokiesSayisi);
        Assert.assertTrue(cokiesSayisi>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String name=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(name,"USD");

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertEquals("cikolatali",driver.manage().getCookieNamed("en sevdigim cookie").getValue());


        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        boolean flag=true;
        for (Cookie eachCookies:cookiesSeti
        ) {
           if (eachCookies.getName().equals("skin"))
           {
               flag=false;
           }
        }
        Assert.assertFalse(flag);
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSeti=driver.manage().getCookies();
        Assert.assertTrue(cookiesSeti.size()==0);

    }
}