package tests.day11_exelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class P02 {
    @Test
    public void test01() throws IOException {
        String dinamikDosyaYolu = "/Users/MACBOOKAIR/Desktop/team116_JUnit/src/test/java/tests/day11_exelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dinamikDosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");


        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1));  //Başkent (İngilizce)

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String ikiciHucre = sayfa1.getRow(0).getCell(1).getStringCellValue();
        System.out.println(ikiciHucre);
        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String dortuncuHucre = sayfa1.getRow(1).getCell(3).toString();
        Assert.assertEquals(dortuncuHucre,"Kabil");
        // - Satir sayisini bulalim
        int satirSayisi=sayfa1.getLastRowNum();
        System.out.println(satirSayisi);
        // - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows());

        // Sayfa2 icin son satir numarasi ve fiziki olarak kullanilan satir sayisini yazdirin
        Sheet sayfa2= workbook.getSheet("Sayfa2");
        System.out.println(sayfa2.getPhysicalNumberOfRows());
        System.out.println(sayfa2.getLastRowNum());
        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String>ulkeIsimleri=new HashMap<>();
        for (int i = 0; i < sayfa1.getLastRowNum(); i++) {
            ulkeIsimleri.put(sayfa1.getRow(i).getCell(0).toString(),sayfa1.getRow(i).getCell(1).toString());
        }
        System.out.println(ulkeIsimleri);

        // Listede Benin isminde bir ulke bulundugunu test edin
        Assert.assertTrue(ulkeIsimleri.containsKey("Benin"));
        Assert.assertTrue(ulkeIsimleri.containsKey("Turkey"));
        // Listede Ankara isminde bir baskent bulundugunu test edin
        Assert.assertTrue(ulkeIsimleri.containsValue("Ankara"));
    }
}
