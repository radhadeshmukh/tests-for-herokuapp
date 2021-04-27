package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Superclass
{
  public WebDriver driver;
  public Superclass(){
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }
}