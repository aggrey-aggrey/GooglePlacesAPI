package data;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private static Logger log = LogManager.getLogger(ExcelReader.class.getName());

	public String[][] getExcelData(String excelLocation, String sheetName) {

		try {

			log.info("Creating excel object:-" + excelLocation);

			String dataSets[][] = null;

			FileInputStream file = new FileInputStream(new File(excelLocation));

			// Create Workbook instance holding reference to .xlsx file

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook

			XSSFSheet sheet = workbook.getSheet(sheetName);

			// count number of active tows

			int totalRow = sheet.getLastRowNum() + 1;

			// count number of active columns in row

			int totalColumn = sheet.getRow(0).getLastCellNum();

			// Create array of rows and column

			dataSets = new String[totalRow - 1][totalColumn];

			// Iterate through each rows one by one

			Iterator<Row> rowIterator = sheet.iterator();

			int i = 0;

			int t = 0;

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				if (i++ != 0) {

					int k = t;

					t++;

					// For each row, iterate through all the columns

					Iterator<Cell> cellIterator = row.cellIterator();

					int j = 0;

					while (cellIterator.hasNext()) {

						Cell cell = cellIterator.next();

						// Check the cell type and format accordingly

						switch (cell.getCellTypeEnum()) {

						case NUMERIC:

							System.out.print(k + ",");

							System.out.print(j + ",");

							dataSets[k][j++] = cell.getStringCellValue();

							System.out.println(cell.getNumericCellValue());

							break;

						case STRING:

							System.out.print(k + ",");

							System.out.print(j + ",");

							dataSets[k][j++] = cell.getStringCellValue();

							System.out.println(cell.getStringCellValue());

							break;

						case BOOLEAN:

							System.out.print(k + ",");

							System.out.print(j + ",");

							dataSets[k][j++] = cell.getStringCellValue();

							System.out.println(cell.getStringCellValue());

							break;

						case FORMULA:

							System.out.print(k + ",");

							System.out.print(j + ",");

							dataSets[k][j++] = cell.getStringCellValue();

							System.out.println(cell.getStringCellValue());

							break;
						default:
							break;

						}

					}

					System.out.println("");

				}

			}

			file.close();

			return dataSets;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * public static void main(String[] args) {
	 * 
	 * String excellocation =
	 * "/Users/bsingh5/git/seleniumHybridFramework/hybridFramework/src/main/java/com/hybridFramework/data/TestData.xlsx";
	 * 
	 * String sheetName = "LoginTestData";
	 * 
	 * ExcelReader excel = new ExcelReader();
	 * 
	 * excel.getExcelData(excellocation, sheetName);
	 * 
	 * }
	 **/

}
