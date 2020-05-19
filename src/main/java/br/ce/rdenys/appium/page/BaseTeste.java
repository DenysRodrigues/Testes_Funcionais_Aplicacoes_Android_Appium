package br.ce.rdenys.appium.page;

import org.junit.After;

import br.ce.rdenys.appium.core.DriverFactory;

public class BaseTeste {

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
}
