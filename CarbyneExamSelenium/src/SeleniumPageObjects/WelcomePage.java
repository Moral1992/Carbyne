package SeleniumPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WelcomePage extends PageBase {


	private By m_displayedItemListBy = new By.ByXPath("//ul[@id='homefeatured']");
	private By m_addToCartButtonBy = new By.ByXPath(".//span[text()='Add to cart']");
	private By m_gotoCartButtonBy = new By.ByXPath("//a[@title='View my shopping cart']");
	private By m_checkOutButton = new By.ById("button_order_cart");

	private By GetItemByData(String i_itemName, boolean i_discount) {
		String xpath = String.format(".//li[contains(@class,'ajax_block_product') and .//a[@title='%s']", i_itemName);
		if (i_discount) xpath = xpath + " and .//span[@class='discount']";
		xpath = xpath + "]//div[@class='product-container']";
		return By.xpath(xpath);		
	}
	
	public WelcomePage(WebDriver i_driver)  {
		super(i_driver);
	}
	
	public WebElement FindDisplayedItemArea() {
		WebElement displayedItemArea = m_driver.findElement(m_displayedItemListBy);
		return displayedItemArea;
	}
	
	
	public WebElement FindItemElement(String i_itemName, Boolean i_discount) {
		By itemBy = GetItemByData(i_itemName, i_discount);
		WebElement displayedItemArea = FindDisplayedItemArea();
		WebElement item = displayedItemArea.findElement(itemBy);
		
		return item;
	}
	
	public WelcomePage HoverOverItem(String i_itemName, Boolean i_discount) {
		WebElement item = FindItemElement(i_itemName, i_discount);		
		Actions action = new Actions(m_driver);
		action.moveToElement(item).perform();
		return this;
	}
	
	public void ClickOnAddToCartButton(String i_itemName, Boolean i_discount) {
		WebElement item = FindItemElement(i_itemName, i_discount);
		WaitUntilDislayed(5, m_addToCartButtonBy, item);		
		WebElement addToCart = item.findElement(m_addToCartButtonBy);		
		addToCart.click();
	}
	
	public WelcomePage ClickOnCartViewButton() {
		WebElement cartView = m_driver.findElement(m_gotoCartButtonBy);
		cartView.click();
		return this;
	}
	
	public WelcomePage WaitForCheckOutButtonToDisplay() {
		WaitUntilDislayed(5, m_checkOutButton);
		return this;
	}
	
	public WelcomePage ClickOnCheckOutButton() {
		m_driver.findElement(m_checkOutButton).click();
		return this;
	}
}
