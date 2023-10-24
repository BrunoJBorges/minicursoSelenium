package pages;

import static support.Commands.getMessage;

import org.openqa.selenium.By;

import runner.RunBase;

public class InitialPage extends RunBase{

	private By textProduct = By.cssSelector(".product_label");
	
	public String getTextProduct() {
		String s_returnValue;
		
		s_returnValue = getMessage(textProduct);
		
		return s_returnValue;
	}
	
}
