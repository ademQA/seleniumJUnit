package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ReusableMethods {
    public static String ikinciSayfaWHD(String ilkSayfaWHD, WebDriver driver){

        String ikinciSayfaWHD="";
        Set<String>windowHandleSeti= driver.getWindowHandles();
        for (String each:windowHandleSeti) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=each;
            }
        }

        return ikinciSayfaWHD;

    }
}
