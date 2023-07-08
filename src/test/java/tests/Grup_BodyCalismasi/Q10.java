package tests.Grup_BodyCalismasi;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Q10 {
    @Test
    public  void ReadWrite() throws IOException {
        //sinifListesi adında yeni excel dosyası olusturun
        String dosyaYolu="/Users/MACBOOKAIR/Desktop/team116_JUnit/src/test/java/tests/Grup_BodyCalismasi/sinifListesi.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sayfa= workbook.getSheet("Sayfa1");
        //satır sayısı ve fiziki kullanılan satır sayısını bulun ve yazdırın
        System.out.println(sayfa.getPhysicalNumberOfRows());
        System.out.println(sayfa.getLastRowNum()+1);
        //3.satır 2.hucreyi degiskene atayıp yazdırın
        System.out.println(sayfa.getRow(2).getCell(1).toString());
        //4.satırdaki ogrencinin ulkesinin "Türkiye" oldugunu test edin
        Assert.assertEquals(sayfa.getRow(3).getCell(3).toString(),"Türkiye");

        //Sayfada "İngiltere" ülkesinin oldugunu test edin
        boolean flag=true;
        for (int i = 1; i < sayfa.getLastRowNum(); i++) {
            if (sayfa.getRow(i).getCell(3).toString().equals("İngiltere"))
                flag=false;
        }
        Assert.assertTrue(flag);
        // ogrenci adlarını ve sehirlerini map olarak kaydedin
        Map<String,String>ogrenciMap=new HashMap<>();
        for (int i = 1; i <sayfa.getLastRowNum() ; i++) {
            ogrenciMap.put(sayfa.getRow(i).getCell(0).toString(),sayfa.getRow(i).getCell(2).toString());

        }
        // sehirler arasında olarak "Gaziantep" oldugunu test edin
        for (int i = 0; i < ogrenciMap.size(); i++) {
            Assert.assertTrue(ogrenciMap.containsValue("Gaziantep"));

        }
        // 4.hucreye yeni cell olusturun ve "Yas" yazdırın
        sayfa.getRow(0).createCell(4);
        sayfa.getRow(0).getCell(4).setCellValue("yas");
        //3.satırdaki ogrencinin yasını 17 olarak girin
        sayfa.getRow(2).createCell(4).setCellValue(17);
        //3.satırdaki ogrencinin yasının 17 oldugunu test edin
        System.out.println(sayfa.getRow(2).getCell(4).toString());
       double yas=Double.valueOf(sayfa.getRow(2).getCell(4).toString());
       Assert.assertTrue(yas==17);
        //yapılan degisikleri dosyaya isleyin ve dosyayı kapatın
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();

    }
}
