package Program;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver InitlializeDriver1() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream("src\\main\\java\\Program\\data.properties");
		prop.load(fis);
	    System.setProperty(prop.getProperty("chromeDriver"), "driver/chromedriver_win32/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","driver/FireFox/geckodriver.exe");
	    
	    WebDriver driver= new ChromeDriver();
	    //WebDriver driver= new FirefoxDriver();
			return driver;	
	 
	}
	
}
