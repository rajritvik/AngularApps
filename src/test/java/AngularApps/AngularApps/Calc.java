package AngularApps.AngularApps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calc {

		NgWebDriver ngWebDriver;
		WebDriver driver;
		JavascriptExecutor js;
		
		ByAngularModel first=ByAngular.model("first");
		ByAngularModel operator=ByAngular.model("operator");
		ByAngularModel second=ByAngular.model("second");
		ByAngularButtonText go=ByAngular.buttonText("Go!");
		
		By result= By.tagName("h2");
		
		public Calc()
		{
			System.setProperty("webdriver.chrome.silentOutput", "true");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			js = (JavascriptExecutor)driver;
			ngWebDriver= new NgWebDriver(js);
			driver.get("https://juliemr.github.io/protractor-demo/");
			ngWebDriver.waitForAngularRequestsToFinish();
		}
		
		public String sum(String v1, String v2)
		{
			driver.findElement(first).clear();
			driver.findElement(first).sendKeys(v1);
			
			driver.findElement(second).clear(); 
			driver.findElement(second).sendKeys(v2);
			
			driver.findElement(operator).sendKeys("+");
			driver.findElement(go).click();
			
			ngWebDriver.waitForAngularRequestsToFinish();
			
			System.out.println(driver.findElement(result).getText());
			
			return driver.findElement(result).getText();
		}

}
