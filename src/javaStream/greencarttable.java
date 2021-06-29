package javaStream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class greencarttable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","H:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all elements in list
		List<WebElement> original = driver.findElements(By.xpath("//tr/td[1]"));
		//take all text into new list
		List<String> newlist = original.stream().map(s->s.getText()).collect(Collectors.toList());
		//sort newlist and copy sorted element into sortedlist
		List<String> sortedlist = newlist.stream().sorted().collect(Collectors.toList());
		//compare two list are equal or not
		Assert.assertTrue(newlist.equals(sortedlist));
		
		List<String> veg;
		do
		{
			List<WebElement> original1 = driver.findElements(By.xpath("//tr/td[1]"));
		veg = original1.stream().filter(s->s.getText().contains("Rice")).map(s->getprice(s)).collect(Collectors.toList());
		veg.stream().forEach(s->System.out.println(s));
		
		if(veg.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}while(veg.size()<1);
	}

	private static String getprice(WebElement s) {
		String pricevalue =s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		// TODO Auto-generated method stub
		return pricevalue;
	}

}
