package StepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import static org.junit.jupiter.api.Assertions.*;
//import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefination_DynamicLoading extends Superclass
{
	
	@Given("^Launch the url$")
    public void launch_the_url() throws Throwable {
		String url = "https://the-internet.herokuapp.com/dynamic_loading";
		driver.get(url);
    }
	
	 @When("^Verification of Expected1color of (.+) and click$")
	    public void verification_of_expected1color_of_and_click(String Example) throws Throwable {
	
		 WebElement Example1 =driver.findElement(By.partialLinkText(Example));
    String Expected1color = "rgba(43, 166, 203, 1)";
		String Example1color = Example1.getCssValue("color");
		Assert.assertTrue(Example1color.contains(Expected1color));
		
	
		Assert.assertTrue(Example1.isDisplayed());
		Example1.click();
    }
	
	   @Then("^click on start button$")
	    public void click_on_start_button() throws Throwable {
		   WebElement start = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
			start.click();
        
    }
	
	   @And("^verify the message1(.+)$")
	    public void verify_the_message1(String message1) throws Throwable {
    	//Verify the message displayed on Dynamically page element loaded page.
    	WebElement Dynamicalmessage = driver.findElement(By.tagName(message1));
		//WebElement Dynamicalmessage = driver.findElement(By.xpath("//h3[contains(text(),'\"+message1+\"')]"));
    	Assert.assertTrue(Dynamicalmessage.isDisplayed());
    }
	
    
	   @And("^Helloworldmessage present$")
	    public void helloworldmessage_present() throws Throwable {
		  
		   if(driver.getPageSource().contains("Hello World!"))
		   {
			   Thread.sleep(2000);
		   }
			   else
			   {
				   
					Thread.sleep(10000);
		   }
		   WebElement Loadingsymbol =driver.findElement(By.xpath("//div[contains(text(),'Loading... ')]"));
		   WebDriverWait wait = new WebDriverWait(driver, 8000);
			wait.until(ExpectedConditions.invisibilityOf(Loadingsymbol));
			WebElement Hello =driver.findElement(By.xpath("//div[@id=\"finish\"]//h4[contains(text(),'Hello World!')]"));
				wait.until(ExpectedConditions.visibilityOf(Hello));
				Thread.sleep(10000);
			 
			  // Boolean Display = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).isDisplayed();
			   Hello.isDisplayed();
			  Hello.isEnabled();
			  // System.out.println("Element displayed is :"+Enable);
			   
			  Assert.assertEquals(true, Hello.isDisplayed());
			  // System.out.println("Element displayed is :"+Display);
			   driver.quit();
			
    }
}
