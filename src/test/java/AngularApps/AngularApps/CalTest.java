package AngularApps.AngularApps;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalTest {
	
	Calc calc;
	
	@BeforeTest
	public void setup() {
		calc = new Calc();
		 
	}
	
	@Test(priority = 1)
	public void sumTest() 
	{
		String res= calc.sum("2", "3");
		Assert.assertEquals(res, "5");
	}
}
