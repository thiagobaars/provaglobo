package pages;

import org.junit.Assert;

public class ProgramaPage extends BasePage{

	String tempoA;
	String tempoB;
	
	public void clicarAssistir() throws Throwable {
		String xpathBotaoAssista = "//span[text()='Assista']//ancestor::div[@role and not(contains(@class, 'playkit-buttons__button--flex'))]";
		clickElement(xpathBotaoAssista);
	}
	
	public void clicarContinueAssistir() throws Throwable {
		String xpathBotaoContinue = "//span[text()='Continue']//ancestor::div[@role and not(contains(@class, 'playkit-buttons__button--flex'))]";		
		String xpathProgressBar = "//div[@class='playkit-media-cover__progress-bar-remaining']";
		tempoA = getText(xpathProgressBar);
		
		clickElement(xpathBotaoContinue);
	}
	
	public void atualizarPagina() throws Throwable {
		driver.navigate().refresh();
	}
	
	public void validarProgressoDoVideoAssistido() throws Throwable {
		String xpathProgressBar = "//div[@class='playkit-media-cover__progress-bar-remaining']";
		try {
			tempoB = getText(xpathProgressBar);			
			Assert.assertNotEquals("nao atualizou", tempoA, tempoB);
		}catch(Exception e) {
			System.out.println("O video terminou");
		}
	}
	
	public boolean oProgramaJaFoiAssistido() throws Throwable{
		String xpathBotaoContinue = "//span[text()='Continue']//ancestor::div[@role and not(contains(@class, 'playkit-buttons__button--flex'))]";	
		if(isElementOnPage(xpathBotaoContinue)) {
			return true;
		}
		return false;
	}
	
}
