package StepDefination;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import static org.junit.jupiter.api.Assertions.*;
//import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Alerts extends Superclass {
	
	

    @Given("^open the Application$")
    public void open_the_application() throws Throwable {
    	String url = "https://the-internet.herokuapp.com/javascript_alerts";
		driver.get(url);
    }
	
    @When("^Click on Button (.+)$")
    public void click_on_button(String button) throws Throwable {
    
    	driver.findElement(By.xpath(button)).click();
    }

    @Then("^the Alter Message(.+) Present$")
    public void the_alter_message_present(String AlterMessage) throws Throwable {
    {
    	Alert alert = driver.switchTo().alert(); // switch to alert

		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
		if(AlterMessage.equals("I am a JS prompt"))
		{
		driver.switchTo().alert().sendKeys("Text");
		alert.sendKeys("Welcome");
		Thread.sleep(5000);
		}

		alertMessage.compareTo(AlterMessage);
		
		Thread.sleep(5000);
		
    }
    }
	
    @And("^Accept or Dismiss the Alert (.+)$")
    public void accept_or_dismiss_the_alert(String status) throws Throwable {
    	if(status.equals("accept"))
    	{
    		driver.switchTo().alert().accept();
    	}
    		else
    		{
    			driver.switchTo().alert().dismiss();
    	}
    
    	
    }
		  @And("^verify Atermessageon page (.+)$")
		    public void verify_atermessageon_page(String messageonpage) throws Throwable {
				String result= driver.findElement(By.id("result")).getText();
				Assert.assertTrue(result.contains(messageonpage));
				driver.quit();
		  }
	


    }

