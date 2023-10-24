package tests;

import static support.Commands.checkValue;
import static support.Constants.USER_EMAIL;
import static support.Constants.USER_PASSWORD;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.InitialPage;
import pages.LoginPage;
import runner.RunBase;


@Epic("Validation of login screen functionalities")
@Feature("Functionality - Login")
public class LoginTest extends RunBase{

	private LoginPage loginPage;
	private InitialPage initialPage;
	
	@BeforeEach
	public void setUp() {
		getDriver("chrome-ci");
		loginPage 	= new LoginPage();
		initialPage = new InitialPage();
	}
	
	@AfterEach
	public void tearDown() {
		killDriver();
	}
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Tag("critical")
	@Story("CT001 - Correct login")
    @Description("Log in with a user registered in the system, informing your correct password")
	public void testCorrectLogin() {
		String s_textProduct;
	    
	    //Login in to the system
		loginPage.performLogin(USER_EMAIL, USER_PASSWORD);
	    
	    //Validates if you logged in the municipality correctly
		s_textProduct = initialPage.getTextProduct();
	    
	    checkValue("Não está logando corretamento no sistema", "Products", s_textProduct);  
	}
	
	@Test
	@Tag("critical")
	@Story("CT002 - Empty email")
    @Description("Try to login by entering the password and leaving the user field empty")
	public void testEmptyEmail() {
		String s_returnMessage;
		
	    //Login in to the system	    
		loginPage.performLogin("", USER_PASSWORD);
	    
	    //Validate the return message
	    s_returnMessage = loginPage.getMessageLogin();
	    	    		
	    checkValue("A mensagem apresentada está incorreta!", "Epic sadface: Username is required", s_returnMessage);
	}
	
	@Test
	@Tag("normal")
	@Story("CT003 - Empty password")
    @Description("Try to login by entering the email and leaving the password field empty")
	public void testEmptyPassword() {
		String s_returnMessage;
		
		//Login in to the system	    
		loginPage.performLogin(USER_EMAIL, "");
	    
	    //Validate the return message
	    s_returnMessage = loginPage.getMessageLogin();
	    	    
	    checkValue("A mensagem apresentada está incorreta!", "Epic sadface: Password is required", s_returnMessage);	
	}
	
}