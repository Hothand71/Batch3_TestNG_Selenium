package com.krafttechnologie.tests.day20_DDF;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {
    @Test
    public void readExcelFile() {
        /** how to read excel file
         * create an object from excel untils
         * it accepts two arguments
         * Argument 1:location of the file (path9)
         * Argument 2:sheet that we want to open(sheetName)
         */

        ExcelUtil testData=new ExcelUtil("src/test/resources/KT_DDFTest.xlsx","Test Data");
        // how many rows in the sheet
        System.out.println(testData.rowCount());
        //how many columns in the sheet
        System.out.println(testData.columnCount());
        //get all column names
        System.out.println(testData.getColumnsNames());
        //get all data in list of string
        List<Map<String, String>> dataList = testData.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }
        //How can I get third row
        System.out.println("dataList.get(2) = " + dataList.get(2));
        //get bulent's job
        System.out.println("dataList.get(6).get(\"Job\") = " + dataList.get(6).get("Job"));
        //get name=> busss
        System.out.println("dataList.get(7).get(\"Username\") = " + dataList.get(7).get("Username"));

        //get array
       // String[][] dataArray = testData.getDataArray();
      //  System.out.println(Arrays.deepToString(dataArray));

    }
}
