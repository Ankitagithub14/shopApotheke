package Helper;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DemoPackage.Login;

public class CommonMethod {

	public WebDriver driver;
	// public JavascriptExecutor js = (JavascriptExecutor) driver;
	static Logger logger = Logger.getLogger(CommonMethod.class.getName());

	By registrationButton= By.xpath("//*[@class='u-margin--bottom o-RegistrationBox__button-wrapper']");
	By salutationRadioButton= By.xpath("(//*[@class='l-flex a-list-reset'])/li[1]");
	By firstName= By.xpath("//*[@id='firstName']");
	By lastName= By.xpath("//*[@id='lastName']");
	By eMail= By.xpath("//*[@id='registerForm-eMail']");
	By passwrd= By.xpath("//*[@id='registerForm-password']");
	By dateDropDown= By.xpath("(//*[@class='m-Select__arrow u-transform-center--y'])[2]");
	By birthDropDown= By.xpath("(//*[@class='m-Select__list'])[1]//*[text()=14]");
	By monthDropDown= By.xpath("(//*[@class='m-Select__arrow u-transform-center--y'])[4]");
	By setMonth= By.xpath("(//*[@class='m-Select__list'])[2]//*[text()=06]");
	By yearDropDown= By.xpath("(//*[@class='m-Select__arrow u-transform-center--y'])[6]");
	By setYear= By.xpath("(//*[@class='m-Select__list'])[3]//*[text()=1989]");
	By termsConditionsCheckbox= By.xpath("(//*[@class='l-flex u-margin--bottom o-RegisterForm__checkbox-wrapper'])[2]");
	By submitButton= By.xpath("//*[@id='register-submit-btn']");
	By userName= By.xpath("//*[@id='loginForm-eMail']");
	By paswd= By.xpath("//*[@id='loginForm-password']");
	By loginSubmitButton= By.xpath("//*[@id='login-submit-btn']");

	JavascriptExecutor js = (JavascriptExecutor) driver;


	public CommonMethod(WebDriver driver) {

		this.driver = driver;
	}

	public void registerNewUser() throws InterruptedException {

		logger.info("registering for free/create user account for free");
		driver.findElement(registrationButton).click();
		Thread.sleep(2000);
		WebElement statutaionRadioButton=driver.findElement(salutationRadioButton);//click on radio button
		statutaionRadioButton.click();
		WebElement Name=driver.findElement(firstName);//name
		Name.sendKeys("Ankita");
		WebElement LastName=driver.findElement(lastName);//last name
		LastName.sendKeys("Bhardwaj");
		WebElement emailAddress=driver.findElement(eMail);// email address
		emailAddress.sendKeys("ankitarattan@yahoo.com");
		//js.executeScript("scroll(0,250)");
		WebElement password=driver.findElement(passwrd);//password
		password.sendKeys("Welcome@2022");
		Thread.sleep(2000);
		WebElement datedropdwon=driver.findElement(dateDropDown);
		datedropdwon.click();
		Thread.sleep(2000);
		//js.executeScript("scroll(0,450)");
		Thread.sleep(2000);
		driver.findElement(birthDropDown).click();//set date birth
		Thread.sleep(3000);
		WebElement monthdwon1=driver.findElement(monthDropDown);
		monthdwon1.click();
		Thread.sleep(3000);
		//js.executeScript("scroll(0,450)");
		Thread.sleep(2000);
		driver.findElement(setMonth).click();//set month
		Thread.sleep(3000);
		WebElement yeardropdwon=driver.findElement(yearDropDown);
		yeardropdwon.click();
		Thread.sleep(3000);
		//js.executeScript("scroll(0,450)");
		Thread.sleep(2000);
		driver.findElement(setYear).click();//set date year
		Thread.sleep(3000);
		driver.findElement(termsConditionsCheckbox).click();//second checkbox clicked
		Thread.sleep(2000);
		driver.findElement(submitButton).click();//click to create a user account
		Thread.sleep(4000);
		//logout from the landing page
		WebElement websitePage= driver.findElement(By.xpath("//*[@id='layout']"));
		try {
			Actions action = new Actions(driver);
			action.moveToElement(websitePage);
			action.contextClick().sendKeys(Keys.DOWN).perform();
			Thread.sleep(3000);
		}
		catch(Exception e) {
			System.out.println(e);

		}

	}

	public void validUser() throws InterruptedException {
		WebElement Name=driver.findElement(userName);//name
		Name.sendKeys("ankitarattan@yahoo.com");
		WebElement LastName=driver.findElement(paswd);//last name
		LastName.sendKeys("Welcome@2022");
		Thread.sleep(1000);
		js.executeScript("scroll(0,600)");
		driver.findElement(loginSubmitButton).click();
		//check for landing page validation title
		Assert.assertEquals(driver.findElement(By.xpath("o-HeaderLarge--header__text u-font-weight--bold u-position--relative")).getText(), "My pharmacy");
	}


	public void invalidUser() throws InterruptedException {
		WebElement Name=driver.findElement(userName);//name
		Name.sendKeys("ankitarattan1@yahoo.com");
		WebElement LastName=driver.findElement(paswd);//last name
		LastName.sendKeys("Welcome@2021");
		Thread.sleep(1000);
		js.executeScript("scroll(0,600)");
		driver.findElement(loginSubmitButton).click();
		Thread.sleep(1000);
		//check valid error message
		Assert.assertEquals(driver.findElement(By.xpath("l-flex__primary u-no-margin u-padding--ends m-Notification__message")).getText(), "E-Mail-Adresse und/oder Passwort sind falsch. Bitte überprüfen Sie Ihre Eingaben.");
	}
}	







