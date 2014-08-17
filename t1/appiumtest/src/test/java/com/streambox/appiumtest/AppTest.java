package com.streambox.appiumtest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
		//		assertTrue( true );
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "7.1");
		capabilities.setCapability("deviceName", "iPhone");
		capabilities.setCapability("app", "/Users/demo/Downloads/streambox-app.3.0.14/meproiphone.app");
		capabilities.setCapability("udid","eba88a92c6a33123b42450da634b243244ae282b");

		AppiumDriver wd = null;
		try {
			wd = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.findElement(By.name("Title")).clear();
		wd.findElement(By.name("Title")).sendKeys("test");
		wd.findElement(By.name("Location")).sendKeys("test");
		wd.findElement(By.name("Login")).click();
		// if alert, then ok the alert
		//		wd.findElement(By.name("OK")).click();
		try { Thread.sleep(5000); } catch(InterruptedException e) { }
		wd.close();

    }
}
