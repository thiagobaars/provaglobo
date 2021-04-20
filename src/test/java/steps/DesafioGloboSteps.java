package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.BuscaPage;
import pages.FacebookAuthPage;
import pages.HomePage;
import pages.ProgramaPage;
import pages.VideoPage;

public class DesafioGloboSteps {
	
	HomePage homePage = new HomePage();
	BuscaPage buscaPage = new BuscaPage();
	ProgramaPage programaPage = new ProgramaPage();
	FacebookAuthPage facebookAuthPage = new FacebookAuthPage();
	VideoPage videoPage = new VideoPage();
	
	@Dado("^que eu acesso a URL do Globoplay$")
	public void que_eu_acesso_a_URL_do_Globoplay() throws Throwable {
		homePage.acessarURL();
	}
	
	@And("^faço login$")
	public void faco_login() throws Throwable {
		homePage.clicarEntrar();
		homePage.clicarFazerLoginComFacebook();
		facebookAuthPage.preencherUsuarioESenha();
		facebookAuthPage.clicarEntrarFacebook();
	}

	@Quando("^realizo a busca pelo (.+)$")
	public void realizo_a_busca_pelo_Sinta_se_em_casa(String programa) throws Throwable {
		homePage.clicarBuscar();
		buscaPage.realizarBuscaEClicarNoResultado(programa);
	}
	
	@And("^após logar, realizo a busca pelo (.+)$")
	public void apos_logar_realizo_a_busca_pelo_Sinta_se_em_casa(String programa) throws Throwable {
		homePage.clicarBuscarAposLogar();
		buscaPage.realizarBuscaEClicarNoResultado(programa);
	}

	@And("^clico para Assistir$")
	public void clico_para_Assistir() throws Throwable {
		if(programaPage.oProgramaJaFoiAssistido()) {
			programaPage.clicarContinueAssistir();
		}else {
			programaPage.clicarAssistir();
		}
		
	}

	@Entao("^devo conseguir assistir o programa$")
	public void devo_conseguir_assistir_o_programa() throws Throwable {
		videoPage.esperarPropaganda();
		videoPage.validarExibicaoVideo();
	}
	
	@Quando("assisto alguns segundos do programa")
	public void assisto_alguns_segundos_do_programa() throws Throwable {
		videoPage.esperarPropaganda();
		videoPage.assistirVideo();
	}
	
	@And("clico para voltar para a tela do programa")
	public void clico_para_voltar_para_a_tela_do_programa() {
		videoPage.clicarVoltar();
	}

	@Entao("^o contador do progresso deve ser atualizado com o tempo assistido$")
	public void o_contador_do_progresso_do_programa_deve_ser_atualizado_com_o_tempo_assistido() throws Throwable {
		programaPage.atualizarPagina();
		programaPage.validarProgressoDoVideoAssistido();
	}
}
