package javaStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VegFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veg = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> newlist = veg.stream().filter(vegs->vegs.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(veg.size(), newlist.size());
	}

}
