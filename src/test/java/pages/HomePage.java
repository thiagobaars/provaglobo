package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

	String winPrincipal;
	
	public void acessarURL() throws Throwable {
		driver.get("https://globoplay.globo.com/");
	}
	
	public void clicarEntrar() throws Throwable {
		String xpathToolbar__avatar_container = "//*[@class='toolbar__avatar-container']";
		String xpathBotaoEntrar = "//*[@class='toolbar__user-area__container header__fade-menu-dropdown']//button[@id='login-button-Entrar']";
		
		moveToElement(xpathToolbar__avatar_container);
		clickElement(xpathBotaoEntrar);
	}
	
	public void clicarBuscar() throws Throwable {
		String xpathBusca = "//a[@class='toolbar__search-bar']";
		wait.until(ExpectedConditions.elementToBeClickable(getElement(xpathBusca)));
		clickElement(xpathBusca);		
		
	}
	
	public void clicarBuscarAposLogar() throws Throwable {
		String xpathBusca = "//a[@class='toolbar__search-bar']";
		String xpathSpinnerIcon = "//figure[@class='spinner__icon']";
				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathSpinnerIcon)));
		wait.until(ExpectedConditions.elementToBeClickable(getElement(xpathBusca)));
		clickElement(xpathBusca);		
		
	}
	
	public void clicarFazerLoginComFacebook() {
		String facebookButton = "//button[@class='social-network-button facebook-button']";
		String xpathIframe = "//*[@id='globoid-modal-container']//iframe";
		
		driver.switchTo().frame(getElement(xpathIframe));
		clickElement(facebookButton);
	}
	
}
