package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Hooks;

public abstract class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait longWait;
	FluentWait<WebDriver> fluentWait;

	public BasePage() {
		this.driver = Hooks.getDriver();
		this.wait = new WebDriverWait(driver, 10);
		this.longWait = new WebDriverWait(driver, 60);
		this.fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
												  .pollingEvery(Duration.ofMillis(500))
												  .ignoring(StaleElementReferenceException.class)
												  .ignoring(ElementNotVisibleException.class)
												  .ignoring(NoSuchElementException.class);
	}
	
	public void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        this.wait.until(pageLoadCondition);
    }

	
	public void setImplicitWait(int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
		
	public List<WebElement> getElements(final String xpath){
		return fluentWait.until(new ExpectedCondition<List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver){
				//setImplicitWait(30);
				return driver.findElements(By.xpath(xpath));
			}
		});
	}
	
	public WebElement getElement(final String xpath) {
		setImplicitWait(30);
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public void moveToElement(String xpath) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(xpath)).build().perform();
	}
	
	public boolean isElementOnPage(String xpath) {
		setImplicitWait(1);
		Boolean flag = !getElements(xpath).isEmpty();
		setImplicitWait(30);
		return flag;
	}
	
	public void clickElement(String xpath) {
		getElement(xpath).click();
	}
	
	public void clearElement(String xpath) {
		getElement(xpath).clear();
	}
	
	public void setText(String xpath, String value) {
		clearElement(xpath);
		getElement(xpath).sendKeys(value);
	}
	
	public String getText(String xpath) {
		return getElement(xpath).getText();
	}
	
	public String getAttribute(String xpath, String attribute) {
		return getElement(xpath).getAttribute(attribute);
	}
	
	public void switchNextWindow() {		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set <String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		String mainWindowId = it.next();
		String childWindowId = it.next();
		//System.out.println(set);
		driver.switchTo().window(childWindowId);

	}
	
	public void switchMainWindow() {
		Set <String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		String mainWindowId = it.next();
		driver.switchTo().window(mainWindowId);
	}
		
}
