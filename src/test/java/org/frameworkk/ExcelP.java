package org.frameworkk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelP {

	public static void main(String[] args) throws IOException {
		
		 //1.mention the path of the Excel
		File file = new File("C:\\Users\\user\\eclipse-workspace\\FrameWork\\Excel\\testp.xlsx");
		//2.Read bytes/object from file->FileInputStream
		FileInputStream stream=new FileInputStream(file);
		
		//3.Create the WorkBook->Collection of Sheet
		Workbook workbook = new XSSFWorkbook(stream);
		//4.Get the Sheet name
		Sheet sheet = workbook.getSheet("TestD");
		//5.Get the Rows
		Row row = sheet.getRow(4);
		//6.Get the Cell
		Cell cell = row.getCell(5);
		System.out.println(cell);

	}

}
