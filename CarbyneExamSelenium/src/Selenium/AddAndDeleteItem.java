package Selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SeleniumBusiness.CartViewBusiness;
import SeleniumBusiness.PopupCartBusiness;
import SeleniumBusiness.WelcomeBusiness;

class AddAndDeleteItem extends TestBase{

	WelcomeBusiness m_welcomeBusiness;
	PopupCartBusiness m_popupCartBusiness;
	CartViewBusiness m_cartViewBusiness;
	
	@BeforeEach
    void BeforeTest() {	
		super.BeforeTest();
		m_welcomeBusiness = new WelcomeBusiness(m_driver);
		m_popupCartBusiness = new PopupCartBusiness(m_driver);
		m_cartViewBusiness = new CartViewBusiness(m_driver);
    }
    
	@Test
	void _AddAndDeleteItem() {
		m_welcomeBusiness
		.AddItemToCart("Blouse", false);
		
		m_popupCartBusiness
		.ClickContinueToShopButton();
		
		m_welcomeBusiness
		.AddItemToCart("Printed Summer Dress", true);
		
		m_popupCartBusiness
		.ClickContinueToShopButton();
		
		m_welcomeBusiness
		.ClickOnCartViewButton();
		
		m_cartViewBusiness
		.DeleteRowByItemName("Blouse");

		m_cartViewBusiness
		.DeleteRowByItemName("Printed Summer Dress");
	}	
	

}
