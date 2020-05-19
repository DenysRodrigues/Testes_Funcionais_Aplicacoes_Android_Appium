package br.ce.rdenys.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;



import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTesteCelular {

	@Test
	public void deveSomarDoisVlores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
//		  MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
//		    el1.click();
//		  MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
//		    el2.click();
//		  MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
//		    el3.click();
//  	      MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
//		    el4.click();
//		 System.out.println(el4.getText());
		MobileElement el1 = (MobileElement)driver.findElementByAccessibilityId("2");
	    el1.click();
	    MobileElement el2 = (MobileElement)driver.findElementByAccessibilityId("Mais");
	    el2.click();
	    MobileElement el3 = (MobileElement)driver.findElementByAccessibilityId("2");
	    el3.click();
	    MobileElement el4 = (MobileElement)driver.findElementById("com.sec.android.app.popupcalculator:id/txtCalc_RealTimeResult");
	    el4.click();		
		 Assert.assertEquals("4", el4.getText());
		  driver.quit();
	}
}





