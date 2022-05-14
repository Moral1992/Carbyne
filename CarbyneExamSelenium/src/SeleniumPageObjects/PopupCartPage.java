package SeleniumPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupCartPage extends PageBase{

	By m_popupCartBy = new By.ByXPath("//div[@id='layer_cart']");
	By m_continueShopButtonBy = new By.ByXPath(".//span[@title='Continue shopping']");
	By m_preccedToCheckoutButtonBy = new By.ByXPath(".//span[@title='Proceed to checkout']");

	
	public PopupCartPage(WebDriver i_driver) {
		super(i_driver);
	};
	
	public PopupCartPage WaitUntilPopupCartDisplayed() {		
		WaitUntilDislayed(5, m_popupCartBy);
		return this;
	}
	
	public PopupCartPage WaitUntilPopupCartNotDisplayed() {		
		WaitUntilNotDislayed(5, m_popupCartBy);
		return this;
	}
	
	public PopupCartPage ClickContinueShopButton() {		
		WebElement cartPopUp = m_driver.findElement(m_popupCartBy);
		WaitUntilDislayed(5, m_continueShopButtonBy, cartPopUp);
		WebElement cartPopUpContinueButton = cartPopUp.findElement(m_continueShopButtonBy);
		cartPopUpContinueButton.click();
		return this;
	}
}
