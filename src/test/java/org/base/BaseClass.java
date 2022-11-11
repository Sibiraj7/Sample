package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
WebDriver driver;
	
	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	public void enterUrl(String url) {
		driver.get(url);

	}
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void elementSendkeys(WebElement element, String data) {
		element.sendKeys(data);

	}
	public void elementSendkeysJs(WebElement element, String data) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
	}
	public void elementClick(WebElement element) {
		element.click();

	}
	public String getApplicationTitle() {
		String title = driver.getTitle();
		return title;
	}
	public WebElement findLocatorById(String AttributeValue) {
		WebElement element = driver.findElement(By.id(AttributeValue));
		return element;

	}
	public WebElement findLocatorByName(String AttributeValue) {
		WebElement element = driver.findElement(By.name(AttributeValue));
		return element;
	}
	public WebElement findLocatorByclassName(String AttributeValue) {
		WebElement element = driver.findElement(By.className(AttributeValue));
		return element;
	}	
	public WebElement findLocatorByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}	
	public void closeWindow() {
		driver.close();

	}
	public void quitWindow() {
		driver.quit();

	}
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;

	}
	public String getApplicationUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public String elementGetAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
//	public String elementGetAttributeValue(WebElement element,String attributeName) {
//		String attribute = element.getAttribute("attributeName");
//		return attribute;
//	}
	public void selectoptionByText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectoptionByAttributeValue(WebElement element,String attributeName) {
		Select select=new Select(element);
		select.selectByValue(attributeName);
	}
	public void selectoptionByIndexValue(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void moveToElement(WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public String getwindowHandle() {
		String handle = driver.getWindowHandle();
		return handle;

	}
	public void getSimpleAlert() {
		Alert alert=driver.switchTo().alert();
		alert.accept();

	}
	public void getConfirmAlert() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();

	}
	public void promptAlret(String text) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
	}
	public void getBack() {
		driver.navigate().back();

	}
	public void getforward() {
		driver.navigate().forward();

	}
	public void getRefresh() {
		driver.navigate().refresh();
	}
	public void openApplicationNavigation(String url) {
		driver.navigate().to(url);
	}	
	public WebElement getFirstSelectionOption(WebElement element) {
		Select select=new Select(element);
		WebElement option = select.getFirstSelectedOption();
		return option;
	}
	public void getdeSelectByIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.deselectByIndex(index);

	}
	public void deselectByValue(WebElement element, String attributeName) {
		Select select=new Select(element);
		select.deselectByValue(attributeName);

	}

	public void deselectByAll(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();

	}
	public void frame(int index) {
		driver.switchTo().frame(index);

	}
	public void getFrameString(String attributevalue) {

		driver.switchTo().frame(attributevalue);

	}
	public void contextClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick().perform();
	}
	public void pressKey() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	public void releaseKey() throws AWTException {
		Robot robot=new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
public void getdragandDrop(WebElement source,WebElement target) {
	Actions actions=new Actions(driver);
	actions.dragAndDrop(source, target).perform();
}
public void getDoubleclick() {
	Actions actions=new Actions(driver);
	actions.doubleClick().perform();
}
public void writecell(String sheetname,int rownum,int cellnum,String
data) throws IOException {
File file=new File("C:\\Users\\user\\eclipse-workspace\\FrameWork\\Excel\\testp.xlsx");
FileInputStream fileInputStream = new FileInputStream(file);
Workbook book=new XSSFWorkbook(fileInputStream);
Sheet sheet = book.getSheet(sheetname);
Row row = sheet.getRow(rownum);
Cell cell = row.createCell(cellnum);
cell.setCellValue(data);
FileOutputStream out=new FileOutputStream(file);
book.write(out);
}
public void updateData(String sheetname,int rownum,int cellnum,String
oldnum, String newData) throws IOException {
File file=new File("C:\\Users\\user\\eclipse-workspace\\FrameWork\\Excel\\testp.xlsx");
FileInputStream fileInputStream = new FileInputStream(file);
Workbook book=new XSSFWorkbook(fileInputStream);
Sheet sheet = book.getSheet(sheetname);
Row row = sheet.getRow(rownum);
Cell cell = row.getCell(cellnum);
String value = cell.getStringCellValue();
if(value.equals(oldnum)) {
cell.setCellValue(newData);
}
FileOutputStream out=new FileOutputStream(file);
book.write(out);
}

public String readvalueFromExcel(String SheetName,int rownum,int cellnum) throws IOException {
	
	String res=" ";
	File file= new File("C:\\Users\\Welcome\\Downloads\\MavenPractice\\AdactinHotel\\AdactinHotel.xlsx");
	FileInputStream stream=new FileInputStream(file);
	Workbook workbook=new XSSFWorkbook(stream);
	
	Sheet sheet = workbook.getSheet("Sheet1");
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	CellType type = cell.getCellType();
	switch (type) {
	
	case STRING:
		res=cell.getStringCellValue();
		
		break;
	case NUMERIC:
		if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yy");
			res = dateFormat.format(dateCellValue);
			
		}
		else {
			double d = cell.getNumericCellValue();
			long check=Math.round(d);
			if (check==d) {
				res = String.valueOf(check);
			}else {
				res=String.valueOf(d);
			}
				
			}
		break;

	default:
		break;
	}
	return res;
 
}
}


