package com.streambox.appiumtest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

// import junit.framework.Test;
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

public class AppTest
    extends TestCase
{
	private AppiumDriver wd;

    public AppTest( String testName )
    {
        super( testName );
    }

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
		//		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "7.1");
		capabilities.setCapability("deviceName", "iPhone");
		capabilities.setCapability("app", "/Users/demo/Downloads/streambox-app.3.0.14/meproiphone.app");
		capabilities.setCapability("udid","eba88a92c6a33123b42450da634b243244ae282b");
        wd = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

	@Test
    public void testApp()
    {
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Boolean weAreLoggedOutNow = wd.findElements(By.name("Login")).size() > 0;
		if(!weAreLoggedOutNow) {
			wd.findElement(By.name("Settings Button   Neutral")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIAStaticText[1]")).click();
			try { Thread.sleep(1000); } catch(InterruptedException e) { }
		}else{
			wd.findElement(By.name("Title")).clear();
			wd.findElement(By.name("Title")).sendKeys("m");
			wd.findElement(By.name("Location")).sendKeys("d");
			wd.findElement(By.name("Login")).click();
			Boolean alertOccured = wd.findElements(By.name("OK")).size() > 0;
			if(alertOccured) {
				wd.switchTo().alert().accept();
			}
		}
    }

	@Test
    public void testApp2()
    {
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Boolean weAreLoggedOutNow = wd.findElements(By.name("Login")).size() > 0;
		if(!weAreLoggedOutNow) {
			wd.findElement(By.name("Settings Button   Neutral")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIAStaticText[1]")).click();
			try { Thread.sleep(1000); } catch(InterruptedException e) { }
		}else{
			wd.findElement(By.name("Title")).clear();
			wd.findElement(By.name("Title")).sendKeys("test");
			wd.findElement(By.name("Location")).sendKeys("d");
			wd.findElement(By.name("Login")).click();
			Boolean alertOccured = wd.findElements(By.name("OK")).size() > 0;
			if(alertOccured) {
				wd.switchTo().alert().accept();
			}
		}
    }

    @After
    public void tearDown() throws Exception {
        wd.quit();
    }
}
