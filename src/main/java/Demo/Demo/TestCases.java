package Demo.Demo;

import org.openqa.selenium.By;

public class TestCases extends BasicSetup
{

	public static void Add_Product_To_Cart()
	{
		
		Highlight(driver, "//input[@name='user-name']");
		Highlight(driver, "//input[@name='password']");
		Highlight(driver, "//input[@name='login-button']");
		ClearAndType(driver, "//input[@name='user-name']", "Standard_userD");
		ClearAndType(driver, "//input[@name='password']", "secret_sauce");
		Click(driver, "//input[@name='login-button']");		
		VerifyElementIsPresent(driver, "//h3[@data-test='error']");
		wait(1);
		Click(driver, "//h3[@data-test='error']/button");
		ClearAndType(driver, "//input[@name='user-name']", "standard_user");
		//wait(1);
		ClearAndType(driver, "//input[@name='password']", "secret_sauce");
		//wait(1);
		Click(driver, "//input[@name='login-button']");
		wait(1);		
		VerifyElementIsPresent(driver, "//div[@class='inventory_item']");
		VerifyElementIsPresent(driver, "//div[@class='inventory_item_img']");
		VerifyElementIsPresent(driver, "//div[@class='inventory_item_description']");
		VerifyElementIsPresent(driver, "//div[@class='inventory_item_label']");
		VerifyElementIsPresent(driver, "//div[@class='inventory_item_label']//a");
		VerifyElementIsPresent(driver, "//div[@class='inventory_item_desc']");
		VerifyElementIsPresent(driver, "//div[@class='pricebar']/div[@class='inventory_item_price']");
		VerifyElementIsPresent(driver, "//div[@class='pricebar']//button");
		Click(driver, "//div[@class='inventory_item_label']//a");
		wait(1);		
		VerifyElementIsPresent(driver, "//div[@class='inventory_details_img_container']");
		VerifyElementIsPresent(driver, "//div[@class='inventory_details_desc_container']/div[@class='inventory_details_name large_size']");
		VerifyElementIsPresent(driver, "//div[@class='inventory_details_desc_container']/div[@class='inventory_details_desc large_size']");
		VerifyElementIsPresent(driver, "//div[@class='inventory_details_desc_container']/div[@class='inventory_details_price']");
		VerifyElementIsPresent(driver, "//div[@class='inventory_details_desc_container']/button");
		Click(driver, "//div[@class='inventory_details_desc_container']/button");
		wait(1);
		VerifyElementIsPresent(driver, "//div[@class='inventory_details_desc_container']/button");
		VerifyElementIsPresent(driver, "//a[@class='shopping_cart_link']");
		Click(driver, "//a[@class='shopping_cart_link']");
		wait(1);		
		VerifyElementIsPresent(driver, "//div[@class='header_secondary_container']");
		VerifyElementIsPresent(driver, "//div[@class='cart_quantity_label']");
		VerifyElementIsPresent(driver, "//div[@class='cart_desc_label']");
		VerifyElementIsPresent(driver, "//div[@class='cart_quantity']");
		VerifyElementIsPresent(driver, "//div[@class='cart_item_label']/a");
		VerifyElementIsPresent(driver, "//div[@class='cart_item_label']/div[@class='inventory_item_desc']");
		VerifyElementIsPresent(driver, "//div[@class='item_pricebar']/div[@class='inventory_item_price']");
		VerifyElementIsPresent(driver, "//div[@class='item_pricebar']/button");
		Click(driver, "//div[@class='item_pricebar']/button");
		wait(1);
		VerifyElementIsPresent(driver, "//div[@class='bm-burger-button']/button");
		Click(driver, "//div[@class='bm-burger-button']/button");
		wait(1);
		VerifyElementIsPresent(driver, "//a[@id='inventory_sidebar_link']");
		VerifyElementIsPresent(driver, "//a[@id='about_sidebar_link']");
		VerifyElementIsPresent(driver, "//a[@id='logout_sidebar_link']");
		VerifyElementIsPresent(driver, "//a[@id='reset_sidebar_link']");
		Click(driver, "//a[@id='logout_sidebar_link']");
		wait(2);
		
	}
	
}
