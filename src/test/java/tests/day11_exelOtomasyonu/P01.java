package tests.day11_exelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P01 {
    @Test
    public void test01() throws IOException {
        String dinamikDosyaYolu="/Users/MACBOOKAIR/Desktop/team116_JUnit/src/test/java/tests/day11_exelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dinamikDosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(2);
        Cell cell= row.getCell(1);
        System.out.println(cell);

    }
}
