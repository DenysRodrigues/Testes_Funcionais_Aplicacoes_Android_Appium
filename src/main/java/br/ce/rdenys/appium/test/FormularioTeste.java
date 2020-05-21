package br.ce.rdenys.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.rdenys.appium.core.BaseTeste;
import br.ce.rdenys.appium.core.DriverFactory;
import br.ce.rdenys.appium.page.FormularioPage;
import br.ce.rdenys.appium.page.MenuPage;
import io.appium.java_client.functions.ExpectedCondition;

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
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		
		page.escreverNome("Denys Rodrigues");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
//		page.clicarCheck();
		
//		page.clicarSwitch();

//		page.selecionarCombo("PS4");

		page.clicarSalvarDemorado();
//		esperar(5000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Denys Rodrigues']")));

		Assert.assertEquals("Nome: Denys Rodrigues", page.obterNomeCadastrado());
		
//		Assert.assertEquals("Console: ps4", page.obterConsoleCadastrado());
		
//		Assert.assertTrue(page.obterSwitchCadstrado().endsWith("Off"));

//		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));		
	}
}
