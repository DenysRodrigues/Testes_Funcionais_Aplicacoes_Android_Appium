package br.ce.rdenys.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rdenys.appium.core.BaseTeste;
import br.ce.rdenys.appium.page.MenuPage;
import br.ce.rdenys.appium.page.SplashPage;

public class SplashTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		//acessar menu splash
		menu.acessarSplash();
		
		//verificar que o splash esta sendo executado
		page.isTelaSplashVisivel();
		
		//aguardar saida do splash
		page.aguardarSplashSumir();
		
		//verificar que o formulário está aparecendo
		Assert.assertFalse(page.existeElementoPorTexto("Formulário"));
	}
}
