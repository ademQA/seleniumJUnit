package tests.day11_exelOtomasyonu;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03 {
    @Test
    public void test01() throws IOException {
        String dinamikDosyaYolu = "/Users/MACBOOKAIR/Desktop/team116_JUnit/src/test/java/tests/day11_exelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dinamikDosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        //4) 4.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(5);
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(5).setCellValue("emeklilik");
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).getCell(5).setCellValue(65);
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(11).getCell(5).setCellValue(55);
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(15).getCell(5).setCellValue(40);
        //9) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dinamikDosyaYolu);
        workbook.write(fos);
        workbook.close();
        fos.close();
        fis.close();

        //10)Dosyayi kapatalim
    }
}