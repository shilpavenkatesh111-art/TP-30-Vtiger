package genericLibraries_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	/**
	 * this method is used to read single data from excel file
	 * @author Srinivas V
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String readDataFromExcelFile(String sheetName, int rowNum, int celNum) throws EncryptedDocumentException, IOException{
		FileInputStream fs = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet(sheetName);
		String value=sh.getRow(rowNum).getCell(celNum).getStringCellValue();
		return value;
	
}
	/**
	 * This method is used to read multiple data from excel file
	 * @author Srinivas V
	 * @param sheetName
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public ArrayList<String> readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		int celCount=sh.getRow(rowCount).getLastCellNum();
		
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<=rowCount;i++)
		{
			for(int j=0;j<celCount;j++) {
				String value=sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
				}
		return list;
	}
	
	/**
	 * this method is used to get row count from excel file
	 * @author Srinivas V
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException 
		{
		FileInputStream  fi=new FileInputStream(IpathConstants.excelpath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		return rowCount;
		}
	
	/**
	 * This method is used to get the cell count from excel file
	 * @author Srinivas V
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getCellCount(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fi=new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int celCount = sh.getRow(0).getLastCellNum();
		return celCount;
		
	}
	

	/**
	 * This method is used to write data into the excel
	 * @author Srinivas V
	 * @param sheetName
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(0);
		Cell cel = row.createCell(0);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IpathConstants.excelpath);
		wb.write(fos);
		wb.close();
		
	}
	
	/**
	 * This method is used to getdatecellvalue from excel file
	 * @author Srinivas V
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Date getDateCellValue(String sheetName,int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		Date celValue = sh.getRow(rowNo).getCell(cellNo).getDateCellValue();
		return celValue;
	}
	
	/**
	 * this method is used to call the 2 dimensional array values
	 * @author Srinivas V
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] DataProviders(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		//int rowCount = sh.getLastRowNum()+1;//we need to store the number of row  in the object so we providing the +1, if it starts from 0 then will get the arrayoutofboundindex exception
		int rowCount = sh.getPhysicalNumberOfRows();//instead of getlastrownum we can use the getphysicalnumberofrows method
		int cellCount=sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCount][cellCount];//empty object
		for(int i=0;i<rowCount;i++) {//when ever we storing the number from 1, then no need to initialize <=
			for(int j=0;j<cellCount;j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();//storing the data in this statement
			}
		}
		return obj;
	}
}
