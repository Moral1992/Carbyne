package SeleniumPageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver m_driver;

	public PageBase(WebDriver i_driver) {
		m_driver = i_driver;
	}
	
	protected void MoveMouseToPageTopLeft() {
		By pageTopLeftBy = new By.ByXPath("//*");
		WebElement pageTopLeft = m_driver.findElement(pageTopLeftBy);		
		Actions action = new Actions(m_driver);
		action.moveToElement(pageTopLeft,10,10).perform();
	}
	
	void WaitUntilDislayed(int i_timeToWaitSec, By i_elementToWaitFor, WebElement i_parentElement) {
		WebDriverWait wait = new WebDriverWait(m_driver, Duration.ofSeconds(i_timeToWaitSec));
		wait.until(driver -> i_parentElement.findElement(i_elementToWaitFor).isDisplayed());
	}
	
	void WaitUntilDislayed(int i_timeToWaitSec, By i_elementToWaitFor) {
		WebDriverWait wait = new WebDriverWait(m_driver, Duration.ofSeconds(i_timeToWaitSec));
		wait.until(driver -> m_driver.findElement(i_elementToWaitFor).isDisplayed());
	}
	
	void WaitUntilNotDislayed(int i_timeToWaitSec, By i_elementToWaitFor) {
		WebDriverWait wait = new WebDriverWait(m_driver, Duration.ofSeconds(i_timeToWaitSec));
		wait.until(driver -> !m_driver.findElement(i_elementToWaitFor).isDisplayed());
	}
}
