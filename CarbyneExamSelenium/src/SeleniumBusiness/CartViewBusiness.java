package SeleniumBusiness;

import org.openqa.selenium.WebDriver;

import SeleniumPageObjects.CartViewPage;

public class CartViewBusiness {
	
	private WebDriver m_driver;
	private CartViewPage m_cartViewPage;

	public CartViewBusiness(WebDriver i_driver) {
		m_driver = i_driver;
		m_cartViewPage = new CartViewPage(m_driver);
	}
	
	public CartViewBusiness DeleteRowByItemName(String i_itemName) {
		m_cartViewPage
		.WaitForCartSummaryToDisplay()
		.DeleteRowByItemName(i_itemName);
		return this;
	}
	
	public void ValidateCartIsEmpty() {
		m_cartViewPage
		.WaitForEmptyMessage();
	}
 
}
