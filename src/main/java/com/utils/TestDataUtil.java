package com.utils;

import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataUtil {
	@DataProvider(name="oldway")
	public static Object[][] loginTestDataOldWay() {

		Object[][] data = new Object[1][4];
		
		data[0][0] = "https://monk-reviewer-finder-test.dev.cf.private.nature.com";
		data[0][1] = "akshay.agrawal@springernature.com";
		data[0][2] = "teststaff123";
		data[0][3] = "Reviewer Finder";
		
		return data;

}
	
	@DataProvider(name = "loginTest")
    public static Object[][] loginTestData() throws Exception {
        Object[][] data = getExcelData(
                System.getProperty("user.dir") + "//src//test//resources//TestData.xlsx", "loginTest");
        return data;
    }
	
	

	@DataProvider(name = "searchTest")
    public static Object[][] searchTestData() throws Exception {
        Object[][] data = getExcelData(
                System.getProperty("user.dir") + "//src//test//resources//TestData.xlsx", "searchTest");
        return data;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
		String[][] arrayExcelData = null;
		try {

			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(0);

			int rowCount = sheet.getLastRowNum() + 1;
			int columnCount = row.getLastCellNum();

			arrayExcelData = new String[rowCount - 1][columnCount];
			System.out.println("Total_TestDataSets: " + arrayExcelData.length);
			for (int i = 1; i < rowCount; i++) {

				for (int j = 0; j < columnCount; j++) {
					arrayExcelData[i - 1][j] = sheet.getRow(i).getCell(j).toString();
					System.out.println(sheet.getRow(i).getCell(j).toString());

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayExcelData;

	}
	
	
	
	
	
	
	
	
	
	
	
	
}