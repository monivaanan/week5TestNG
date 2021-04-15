package AssignmentWeek5_DataProvider;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	public static String[][] readExcel(String fileName) throws IOException{
		
		/*Set up Excel Path */
		XSSFWorkbook workBook= new XSSFWorkbook("./data/"+fileName+".xlsx");
		/*Set up WorkSheet*/
		XSSFSheet workbookSheet = workBook.getSheet("Sheet1");
		/* Find no. of rows in the workbook sheet*/
		int rowCount = workbookSheet.getLastRowNum();
		/* Find no. of cells  in the workbook sheet*/
		int columnCount = workbookSheet.getRow(1).getLastCellNum();
		/* declare 2D array */
		String[][] data= new String[rowCount][columnCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				String record=workbookSheet.getRow(i).getCell(j).getStringCellValue(); //getNumericVaue();
				data[i-1][j]=record;
			}
		}
		
		/*close the workbook*/
		workBook.close();
		return data;
		
	}
	
	
}
