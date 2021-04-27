package StepDefination;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import static org.junit.jupiter.api.Assertions.*;
//import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_Positive_Test extends Superclass{

	
	  @Given("^Login to Application$")
	    public void login_to_application() throws Throwable {
		
		// open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
	}


	  @When("^Enter (.+) and (.+)$")
	    public void enter_and(String username, String password) throws Throwable {
	
		
		
		// enter username
		driver.findElement(By.id("username")).sendKeys(username);


		// enter password
		driver.findElement(By.name("password")).sendKeys(password);

	}

	  @Then("^Click on submit$")
	    public void click_on_submit() throws Throwable {
		WebElement submit = driver.findElement(By.className("radius"));
		submit.click();
	}

	   @And("^verify the title (.+)$")
	    public void verify_the_title(String title) throws Throwable {
		String pagetitle = driver.getTitle();
		Assert.assertEquals(pagetitle,title);
	}

	@And("^Verify the(.+)$")
	public void verify_the(String url) throws Throwable {
		String url1= url.trim();
		String actualURL =driver.getCurrentUrl();
		System.out.println("Element displayed is :"+url1);
		System.out.println("Element displayed is :"+url1);
	//	Assert.assertEquals(actualURL,url1,"Actual page url is not the same as expected"); 
		 Assert.assertEquals(url1, actualURL);
		
	}
	
	@And("^Logout Button is Displayed and Enabled with Expectedmessage (.+)$")
	public void logout_button_is_displayed_and_enabled_with_expectedmessage(String expectedmessage) throws Throwable {
		// successfull message is visible'
		WebElement Message = driver.findElement(By.cssSelector("#flash"));

		String actualMessage = Message.getText();

		// Assert.assertEquals(actualMessage, expectedmessge,"String not Matched");
		Assert.assertTrue(actualMessage.contains(expectedmessage));
		
		// logout button is visible with messages
		
				
				if(driver.getPageSource().contains("Logout"))
{
					WebElement Logout = driver.findElement(By.xpath("//i[contains(text(),'Logout')]"));
					Assert.assertTrue(Logout.isDisplayed());
				//Logout is enabled
					Assert.assertTrue(Logout.isEnabled());

				Logout.click();
				WebElement Logoutmessage = driver.findElement(By.id("flash"));
				String expectedlogoutmesggae ="You logged out of the secure area!";
				String actuallogoutMessage = Logoutmessage.getText();

				// Assert.assertEquals(actualMessage, expectedmessge,"String not Matched");
				Assert.assertTrue(actuallogoutMessage.contains(expectedlogoutmesggae));
				
		  }
		  else
		  {
		      Thread.sleep(10);
		  } 
		
		
		// close broowser
		driver.quit();

	}
}
