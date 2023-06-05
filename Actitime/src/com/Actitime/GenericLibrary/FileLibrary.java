package com.Actitime.GenericLibrary;
//we should always create non static methods as it executes fast as compare to static ()
//31/5
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author pranali
 *
 */
public class FileLibrary {
	/**
	 * this method is a generic method which is used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readdatafrompropertyFile(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./Testdata/commondata.property");
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}
/**
 * this method is a generic method which is used to read data from excel sheet
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readdatafromExcel(String sheetname, int row , int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./Testdata/testdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return value;
}
}
