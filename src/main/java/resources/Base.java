package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static Properties prop;
	public static WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\devyani\\eclipse-workspace1\\MavenExpedia\\src\\main\\java\\resources\\prop.properties");
		prop = new Properties();
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "F:\\extract browser\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefoxdriver")) 
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Extract files\\WebDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}else if(browserName.equals("InternalExplore")) 
		{
			// i.e
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
		}
	
	public void openUrl() 
	{
		driver.get(prop.getProperty("url"));
	}
}
