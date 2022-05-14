package SeleniumBusiness;

import org.openqa.selenium.WebDriver;

import SeleniumPageObjects.PopupCartPage;

public class PopupCartBusiness {

	private WebDriver m_driver;
	private PopupCartPage m_popupCartPage;
	
	public PopupCartBusiness(WebDriver i_driver) {
		m_driver = i_driver;
		m_popupCartPage = new PopupCartPage(m_driver);
	}
	
	public void ClickContinueToShopButton() {
		m_popupCartPage
			.WaitUntilPopupCartDisplayed()
			.ClickContinueShopButton()
			.WaitUntilPopupCartNotDisplayed();
	}
}
