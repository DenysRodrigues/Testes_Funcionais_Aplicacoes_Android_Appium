package br.ce.rdenys.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTeste {

	@Rule
	public TestName testName = new TestName();
	
	@AfterClass
	public static void finaliaClasse() {
		DriverFactory.killDriver();
	}
	
	@After
	public void tearDown() {
		gerarScreenshot();
		DriverFactory.getDriver().resetApp();
	}
	
	public void gerarScreenshot() {
		try {
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);	
			FileUtils.copyFile(imagem, new File("target/screenshots/" +testName.getMethodName()+".png"));
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);	
		} catch (InterruptedException e) {
			 e.printStackTrace();
		}
		
	}
}
