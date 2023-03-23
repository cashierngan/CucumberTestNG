package TestCase;

import ngan.xd.helpers.ExcelHelpers;
import ngan.xd.helpers.PropertiesHelpers;
import ngan.xd.utils.Log;
import org.testng.annotations.Test;

public class test {

    @Test
    public void testProperties(){
        PropertiesHelpers.loadAllFiles();
        System.out.println(PropertiesHelpers.getValue("url"));
    }

    @Test
    public void testReadExcel(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Login");
        System.out.println(excelHelpers.getCellData("EMAIL", 1));
        System.out.println(excelHelpers.getCellData("PASSWORD", 1));
    }

    @Test
    public void testLog4j2(){
        Log.info("test ok");
    }
}
