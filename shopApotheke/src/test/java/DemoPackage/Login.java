package DemoPackage;

import java.awt.Window;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import org.junit.Test;
import Helper.CommonMethod;
import Program.base;



public class Login extends base  {
	static Logger logger= Logger.getLogger(Login.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver=InitlializeDriver1();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@Test
	public void login() throws InterruptedException, IOException, URISyntaxException  {
		//created the base class and call the method here
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//given commented line fix catpcha as it open in native desktop and this is not the same for the automation
		//hence rest code is not working
		//URI uri= new URI("https://www.shop-apotheke.com/nx/login/#");
		//java.awt.Desktop.getDesktop().browse(uri);
		//launch the browser
		driver.get("https://www.shop-apotheke.com/nx/login/");
		Thread.sleep(3000);
		//check on the number of frame in given page
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		//Integer noOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		//Integer numberOfFrames = 0;
		//System.out.println("No. of iframes on the page are " + numberOfFrames);
		String Str= "return document.querySelector('#usercentrics-root').shadowRoot.querySelector('#focus-lock-id > div > div > div.sc-bYoBSM.hrDdPG > div > div > div.sc-dlVxhl.bEDIID > div > button.sc-gsDKAQ.dZIwB')";
		WebElement title= (WebElement) js.executeScript(Str);
		title.click();
		Thread.sleep(2000);
		CommonMethod commonmethod= new CommonMethod(driver);
		commonmethod.registerNewUser();
		commonmethod.validUser();
		commonmethod.invalidUser();
}



	@AfterTest
	public void close() {
		driver.quit();
	}

}	


