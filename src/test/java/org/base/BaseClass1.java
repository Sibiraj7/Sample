package org.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
WebDriver driver;

public void getDriver() {
WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();
}

public void enterAppInUrl(String url) {
	driver.get("https://adactinhotelapp.com/");
}
public void maximizeWindow() {
	driver.manage().window().maximize();
}
public void elementSendKey(WebElement element , String data) {
	element.sendKeys(data);
}
public void elementSendKeysJS(WebElement element ,String data ) {
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0],setAttribute('value','data'",element);

}
public void elementClick(WebElement element) {
	element.click();
}

public String getAppInTitle() {
String title = driver.getTitle();
return title;
}
public WebElement UserName(String attributeValue) {
	WebElement element =driver.findElement(By.id("username"));
	return element;
}
public WebElement Password(String attributeValue) {
	WebElement element =driver.findElement(By.id("password"));
	return element;
}
public WebElement Location(String attributeValue) {
	WebElement element =driver.findElement(By.id("Location"));
	return element;
}
public WebElement Hotel(String attributeValue) {
	WebElement element =driver.findElement(By.id("Hotel"));
	return element;
}
public WebElement login(String attributeValue) {
	WebElement element =driver.findElement(By.id("login"));
	return element;











}}
