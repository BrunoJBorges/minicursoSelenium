package pages;

import static support.Commands.clickElement;
import static support.Commands.getMessage;
import static support.Commands.setValueField;

import org.openqa.selenium.By;

import runner.RunBase;

public class LoginPage extends RunBase{
	
	//Elements
	private By accessButton  = By.id("login-button");
	private By emailField 	 = By.cssSelector("*[data-test=\"username\"]");
	private By passwordField = By.cssSelector("*[data-test=\"password\"]");
	private By loginMessage  = By.cssSelector("*[data-test=\"error\"]");
	
	/************ METHODS ************/
	
	//Grouper to perform the login
	public void performLogin(String s_email, String s_password){
		setEmail(s_email);
		setPassword(s_password);
		clickEnter();
	}
	
	//Method to set the email
	public void setEmail(String s_email) {
		setValueField(emailField, s_email);
	}
	
	//Method to set the password
	public void setPassword(String s_password) {
		setValueField(passwordField, s_password);
	}
	
	//Method to click on enter button
	public void clickEnter() {
		clickElement(accessButton); 
	}
	
	/************** GET'S **************/
	
	//Stores the return of any message that may be displayed when trying to login
	public String getMessageLogin() {
		String s_returnValue;
	
		s_returnValue = getMessage(loginMessage); //Stores the message
		
		return s_returnValue;
	}
	
}