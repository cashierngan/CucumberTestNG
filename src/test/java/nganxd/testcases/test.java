package nganxd.testcases;

import nganxd.helpers.ExcelHelpers;
import nganxd.helpers.PropertiesHelper;
import nganxd.utils.Log;
import org.testng.annotations.Test;

public class test {

    @Test
    public void testProperties(){
        PropertiesHelper.loadAllFiles();
        System.out.println(PropertiesHelper.getValue("url"));
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
