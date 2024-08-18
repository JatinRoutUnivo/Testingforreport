package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage{
	
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='amity-logo']")   //Amity Logo
	WebElement amitylogoElement;

	@FindBy(xpath = "//span[@class='mr-1 uppercase laptop:font-medium headFootSprite serviceMenu pr-5 header_menuText__KlhzO flex gap-1 items-center']") //ProgramButton
	WebElement programButtonElement;

	@FindBy(xpath = "//span[@class='mr-1 uppercase laptop:font-medium header_menuText__KlhzO'][normalize-space()='CAREER SERVICES']") //Career Services
	WebElement careerServicesButttonElement;

	@FindBy(xpath = "//span[@class='mr-1 uppercase laptop:font-medium header_menuText__KlhzO'][normalize-space()='ADVANTAGES']") //Advantages
	WebElement advanragesButtonElement;

	@FindBy(xpath = "//div[@class='header_searchIcon__bLdgL header_searchIconNew__5aGyK headFootSprite']") //SearechButton
	WebElement SearchButtonElement;
	
	public void HomePageAmityLogo() {

		Assert.assertTrue(amitylogoElement.isDisplayed(), "Logo is not displayed");
		if(amitylogoElement.isDisplayed()) {
			System.out.println("Amity Logo displayed");
		}else {
			System.out.println("Amity Logo is not Displayed");
		}

	}

	public void ProgramHeaderbutton(){
		Assert.assertTrue(programButtonElement.isEnabled(), "Program buttton is not enabled");
		if(programButtonElement.isEnabled()) {
			System.out.println("Program button is working");
		}else
			System.out.println("Program button is not working");
	}



	public void CareerServicesHeaderButton() throws InterruptedException{
		WebElement careerServicesButton = driver.findElement(By.xpath("//span[@class='mr-1 uppercase laptop:font-medium header_menuText__KlhzO'][normalize-space()='CAREER SERVICES']"));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", careerServicesButton);
		Set<String> windowhandle1 = driver.getWindowHandles();
		List<String> handle6 = new ArrayList<String>();
		handle6.addAll(windowhandle1);
		Thread.sleep(2000);
		driver.switchTo().window(handle6.get(1));
		String CareerServicesURL = "https://amityonline.com/career-services";
		String ActualURL = driver.getCurrentUrl();
		if(ActualURL.equals(CareerServicesURL)) {
			System.out.println("Career Service Button is working");
		}else {
			System.out.println("Career Service Button is not working");
		}



		driver.close();	
	}


	public void AdvantagesHeaderButton(){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", advanragesButtonElement);
		String ExpadvanrageelementURL = "https://amityonline.com/amity-online-advantage";
		if(driver.getCurrentUrl().equals(ExpadvanrageelementURL)) {
			System.out.println("Advantages button is working");
		}else {
			System.out.println("Advantages button is not working");
		}

	}

	public void SearchHeaderButton(){
		if(SearchButtonElement.isEnabled()) {
			Assert.assertTrue(true);
			System.out.println("Search button is working");
		}else {
			Assert.assertTrue(false);
			System.out.println("Search button is not working");
		}


	}
	

}
