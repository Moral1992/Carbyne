package Selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	WebDriver m_driver;

	@BeforeEach
	void BeforeTest() {			
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		m_driver = new ChromeDriver();
		m_driver.manage().window().maximize();
		m_driver.get("http://automationpractice.com/index.php");
    }
	
	@AfterEach
	public void AfterTest(){
		m_driver.quit();
	}
}