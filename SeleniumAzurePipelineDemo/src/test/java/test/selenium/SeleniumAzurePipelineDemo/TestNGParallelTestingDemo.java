package test.selenium.SeleniumAzurePipelineDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGParallelTestingDemo {	
	WebDriver driver = null;
	
	public void initDriver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@Test(priority=2)
	public void test1() throws InterruptedException {
		System.out.println("test1|"+Thread.currentThread().getId());
		initDriver();
		
		driver.get("https://google.com");
		Thread.sleep(3000);
		quit();
	}
	@Test(priority=1)
	public void test2() throws InterruptedException {
		System.out.println("test2|"+Thread.currentThread().getId());
		initDriver();
	
		driver.get("http://seleniumhq.org");
		Thread.sleep(3000);
		quit();

	}
	public void quit() {
		driver.quit();
	}
	
}
