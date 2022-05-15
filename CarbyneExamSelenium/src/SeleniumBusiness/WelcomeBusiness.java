package SeleniumBusiness;

import org.openqa.selenium.WebDriver;
import SeleniumPageObjects.WelcomePage;

public class WelcomeBusiness {

	private WebDriver m_driver;
	private WelcomePage m_welcomePage;

	public WelcomeBusiness(WebDriver i_driver) {
		m_driver = i_driver;
		m_welcomePage = new WelcomePage(m_driver);
	}
	
	public WelcomeBusiness AddItemToCart(String i_itemName, boolean i_discount) {		
		m_welcomePage
			.HoverOverItem(i_itemName, i_discount);		
		m_welcomePage
			.ClickOnAddToCartButton(i_itemName, i_discount);	
		
		return this;
	}
	
	public WelcomeBusiness ClickOnCartViewButton() {
		m_welcomePage
		.ClickOnCartViewButton();
		return this;
	}
	
}
