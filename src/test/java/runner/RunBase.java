package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunBase {
	
public static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static WebDriver getDriver(String browser) {
		
		if (driver != null) {
			driver.quit();
		}
		
		switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "chrome-ci":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				driver = new ChromeDriver(chromeOptions);
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				throw new IllegalArgumentException("Edge ainda não suportado!");
			default:
				throw new IllegalArgumentException("Navegador não encontrado!");
		}
		
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.saucedemo.com/v1/");
		    driver.manage().window().setSize(new Dimension(1050, 708));
		}
	
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}


}
