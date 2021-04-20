package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VideoPage extends BasePage{
	
	public void esperarPropaganda() throws Throwable {	
		String xpathValidacaoPropagandaAcabou = "//div[@class='dfp-countdown media-control-element dfp-countdown--hidden']";
		longWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValidacaoPropagandaAcabou)));
	}
	
	public void validarExibicaoVideo() throws Throwable {
		String xpathVideo = "//div[@class='media-control-panel__between']";
		String xpathTempoMostrado = "//div[@class='time-indicator media-control-element']//span[1]";
		String xpathTempoTotal = "//div[@class='time-indicator media-control-element']//span[3]";		
		String tempo = getAttribute(xpathTempoMostrado, "innerHTML");
		
		Thread.sleep(10000);	
		
		Assert.assertTrue("Video não está carregado", isElementOnPage(xpathVideo));
		Assert.assertNotEquals("Video não exibido de forma correta", "00:00", getAttribute(xpathTempoTotal, "innerHTML"));
		Assert.assertNotEquals("O video não está tocando", tempo, getAttribute(xpathTempoMostrado, "innerHTML"));
	}
	
	public void assistirVideo() throws Throwable {
		esperarPropaganda();
		Thread.sleep(70000);
	}
		
	public void clicarVoltar() {		
		driver.navigate().back();
	}

}
