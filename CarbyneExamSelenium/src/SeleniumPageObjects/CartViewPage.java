package SeleniumPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartViewPage extends PageBase {
	
	private By m_cartSummary = new By.ById("cart_summary");
	private String m_deleteItemButtonPerItemBy = "//div[@id='order-detail-content']//tr[.//p[@class='product-name']//a[text()='%s']]//td[@data-title='Delete']//a[@class='cart_quantity_delete']";
	private By m_emptyMessage = new By.ByXPath("//p[contains(text(), 'Your shopping cart is empty.')]");

	
	public CartViewPage(WebDriver i_driver) {
		super(i_driver);
	};

	
	public CartViewPage DeleteRowByItemName(String i_itemName) {
		String deleteItemButtonPerItem = String.format(m_deleteItemButtonPerItemBy, i_itemName);
		By deleteItemButtonPerItemBy = By.xpath(deleteItemButtonPerItem);
		m_driver.findElement(deleteItemButtonPerItemBy).click();
		return this;
	}
	
	public CartViewPage WaitForCartSummaryToDisplay() {
		WaitUntilDislayed(5, m_cartSummary);
		return this;
	}
	
	public CartViewPage WaitForEmptyMessage() {
		WaitUntilDislayed(5, m_emptyMessage);
		return this;
	}
	
}
