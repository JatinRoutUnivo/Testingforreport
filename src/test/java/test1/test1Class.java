package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class test1Class {
	
	WebDriver driver;
	HomePage Hpom;
	
	@BeforeMethod
	public void LaunchBrowser() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("disable-gpu");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.navigate().to("https://amityonline.com/");
		Thread.sleep(1000);
		Hpom=new HomePage(driver);

	}
	
	@Test (priority = 1)
	public void AmityLogo() {
		Hpom.HomePageAmityLogo();

	}


	@Test(priority = 2)
	public void ProgramButton(){
		Hpom.ProgramHeaderbutton();

	}

	@Test(priority = 3)
	public void CareerServices() throws InterruptedException{
		Hpom.CareerServicesHeaderButton();

	}


	@Test(priority = 4)
	public void AdvantagesButton(){
		Hpom.AdvantagesHeaderButton();

	}

	@Test(priority = 5)
	public void SearchButton(){
		Hpom.SearchHeaderButton();

	}
	
	@AfterMethod

	public void CloseBrowser() {
		driver.quit();
	}

}
