package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	   //Static variables
		public static Properties prop;
		public static WebDriver driver;
	

		//Constructor
		public TestBase() {
			try {
				prop = new Properties();
			FileInputStream ip;
					ip = new FileInputStream(
						System.getProperty("user.dir")
						+ "\\src\\main\\java\\com\\qa\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		public void initializer()
		{
			//Initialise browser		
			String browserName = prop.getProperty("browser");
			if (browserName.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\sreel\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();			
			}
			System.out.println("BrowserName is "+ browserName);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(prop.getProperty("url"));			
		}

}
