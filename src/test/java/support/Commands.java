package support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import runner.RunBase;

public class Commands extends RunBase {

	//	Digitar
	
	//Method to type values ​​into field
    public static void setValueField(By element, String s_value) {
    	System.out.println("##################################");
        
    	try {
            System.out.println("Vai preencher o campo: " + element);
            
            waitElementBeVisible(element, 10);
            getDriver().findElement(element).sendKeys(s_value);
            
            System.out.println("Preencheu o campo: " + element);
        } catch (Exception error){
            System.out.println("********** Aconteceu um erro ao tentar preencher o campo: " + element);
            System.out.println(error);
        }
        
        System.out.println("##################################");
    }
	
	// Aguardar os elementos
	
	//Wait for the element to be clickable
	public static void waitElementBeClickable(By element, Integer i_duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i_duration));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
	//Wait for the element to be visible
    public static void waitElementBeVisible(By element, Integer i_duration) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i_duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
	
	
    // Clicar
    
    //Method for clicking a element
    public static void clickElement(By element) {
    	 System.out.println("##################################");
         
    	 try {
             System.out.println("Vai clicar no elemento: " + element);
             
             waitElementBeClickable(element, 10);
             getDriver().findElement(element).click();
             
             System.out.println("Clicou no elemento: " + element);
         } catch (Exception error){
             System.out.println("********** Aconteceu um erro ao tentar clicar no elemento: " + element);
             System.out.println(error);
         }
    	 
         System.out.println("##################################");
    }
	
    //Pegar a mensagem
    
  //Method to get a value of a message
    public static String getMessage(By element) {
    	 String s_actualMessage = "";
         
    	 System.out.println("##################################");
         System.out.println("Vai pegar o texto da mensagem");
         
         waitElementBeVisible(element, 10);
         s_actualMessage = getDriver().findElement(element).getText();

         System.out.println("Pegou o texto da mensagem");
         System.out.println("##################################");
         
         return s_actualMessage;
    }
    
	//	Validar
    
    //Method to validate a value
    public static void checkValue(String s_returnMessage, String s_expectedValue, String s_actualValue) {
    	assertEquals(s_expectedValue,  s_actualValue, s_returnMessage);
    }
	
}
