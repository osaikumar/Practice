package vtigerframework;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listner.class)
public class ExtentReport {

	@Test
	public void test1()
	{
		System.out.println("test1");
	}
	
	public void test2()
	{
		Assert.fail();
	}
}
