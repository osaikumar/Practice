package com.vtiger.generic.lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileData {

	public String fetchDataFromProperty(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("./src/test/resources/VtigerCommonData.properties");
		Properties pobj = new Properties();
		pobj.load(file);
		String value = pobj.getProperty(key);
		return value;
	}
	public String fetchDataFromExcel(String Sheetname,int rownum,int cellnum) throws IOException
	{
		FileInputStream file = new FileInputStream("./src/test/resources/Table.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(Sheetname);
		Row rw = sh.getRow(rownum);
		Cell ce = rw.getCell(cellnum);
		String value = ce.getStringCellValue();
		return value;
	}
	public void addDataInExcel(String sheetname,int rownum,int cellnum,String newdata) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("./src/test/resources/Table.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetname);
		Row rw = sh.getRow(rownum);
		Cell cl = rw.getCell(cellnum);
		cl.setCellValue(newdata);
		FileOutputStream out = new FileOutputStream("./src/test/resources/Table.xlsx");
		book.write(out);
		out.flush();
		System.out.println("new data added.");
	}

}
