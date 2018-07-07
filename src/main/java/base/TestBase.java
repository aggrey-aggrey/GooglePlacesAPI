package base;

import data.ExcelReader;

public class TestBase {
	public ExcelReader excelReader;

	public String[][] getData(String excelName, String sheetName) {
		System.out.println(System.getProperty("user.dir"));
		String excelLocation = System.getProperty("user.dir") + "/" + excelName;
		System.out.println(excelLocation);
		excelReader = new ExcelReader();
		return excelReader.getExcelData(excelLocation, sheetName);

	}

}
