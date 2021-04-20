package utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	static WebDriver driver;
	
	@Before
	public void initialize() {
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
		
	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
