package pages;

public class BuscaPage extends BasePage{

	public void realizarBuscaEClicarNoResultado(String programa) throws Throwable {		
		String xpathInputBusca = "//*[@id='search-bar-input']";
		String xpathImagemPrograma = "//img[@alt='" + programa + "']";		

		setText(xpathInputBusca, programa);
		clickElement(xpathImagemPrograma);
		
	}

}
