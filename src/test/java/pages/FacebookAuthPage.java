package pages;

public class FacebookAuthPage extends BasePage{
	
	HomePage hp = new HomePage();
	
	public void preencherUsuarioESenha() throws InterruptedException {
		switchNextWindow();
		
		String xpathLogin = "//*[@id='email']";
		String xpathSenha = "//*[@id='pass']";

		setText(xpathLogin, "thiagobaars@hotmail.com");
		setText(xpathSenha, "f!8FDJ");
	}
	
	public void clicarEntrarFacebook() {
		String xpathBotaoEntrar = "//*[@value='Entrar']";
		String xpathBotaoConfirmar = "//button[@name='__CONFIRM__']";
		
		clickElement(xpathBotaoEntrar);		
		try {
			clickElement(xpathBotaoConfirmar);
		}catch(Exception e) {
			
		}
		
		switchMainWindow();
	}
}
