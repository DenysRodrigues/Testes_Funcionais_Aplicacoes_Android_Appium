package br.ce.rdenys.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.rdenys.appium.page.BaseTeste;
import br.ce.rdenys.appium.page.FormularioPage;
import br.ce.rdenys.appium.page.MenuPage;

public class FormularioTeste extends BaseTeste{

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Denys");
		
		assertEquals("Denys", page.obterNome());
	}

	@Test
	public void deveInteragircomCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");
		
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	@Test
	public void deveInteragircomCheckBox() throws MalformedURLException {
		Assert.assertFalse(page.isCheckedMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		Assert.assertTrue(page.isCheckedMarcado());
		Assert.assertFalse(page.isSwitchMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Denys Rodrigues");
		
		page.clicarCheck();
		
		page.clicarSwitch();

		page.selecionarCombo("PS4");

		page.clicarSalvar();

		Assert.assertEquals("Nome: Denys Rodrigues", page.obterNomeCadastrado());
		
		Assert.assertEquals("Console: ps4", page.obterConsoleCadastrado());
		
		Assert.assertTrue(page.obterSwitchCadstrado().endsWith("Off"));

		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));		
	}
}
