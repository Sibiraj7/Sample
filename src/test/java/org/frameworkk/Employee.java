package org.frameworkk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Employee {

	public static void main(String[] args) {//WebPage launch

		WebDriverManager.chromedriver().setup();
//		WebDriverManager.edgedriver().setup();
//		WebDriverManager.firefoxdriver().setup();
//		WebDriverManager.iedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");

	}

}
