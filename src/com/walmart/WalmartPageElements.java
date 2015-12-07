/*
 * This class is used to store all the page elements of Walmart website.
*/
package com.walmart;
 

import org.openqa.selenium.By;

public class WalmartPageElements {
	
		
		public static By homePageElement = (By.xpath("//a[@class='logo js-logo hide-content-max-l']"));
		
		//SignIn page elemnts
		public static By signInOptionElement = (By.linkText("Sign In"));
		
		public static By userNameElement = (By.id("login-username"));
		
		public static By passwordElement = (By.id("login-password"));
		
		public static By signInButtonElement = (By.xpath("//button[@class='btn login-sign-in-btn js-login-sign-in btn-block-max-s btn-block-max-s']"));
		
		//Search page elements
		public static By recentOrderHeadingElement = (By.className("recent-orders-heading"));
		
		public static By searchButtonElement = By.xpath("//button[@class='searchbar-submit js-searchbar-submit']");
		
		public static By searchBoxTextElement = (By.id("search"));
		
		public static By searchItemElement = (By.id("tile-container"));
		
		public static By searchSocksFirstElement = (By.xpath("//div[@id='tile-container']/ul/li[1]//a[@class='js-product-title']"));
		
		public static By searchGridElement = (By.className("slick-track"));
		
		public static By searchToysFirstElement = (By.xpath("//div[@data-zone='zone10']//li[1]//p"));
		
		public static By searchItemFirstElement = (By.xpath("//div[@class='js-tile js-tile-landscape tile-landscape'][1]//a[@class='js-product-title']"));
		
		public static By iphoneColorElement = (By.xpath("//span[@class='js-variant-swatch-container variant-swatch-container'][1]"));
		
		public static By modelInnerFlexStackElement =(By.xpath("//div[@class='Modal-inner FlexStack']"));
		
		public static By addToCartButtonElement = (By.id("WMItemAddToCartBtn"));
		
		//Cart page elements
		public static By viewCartButton = (By.id("PACViewCartBtn"));
		
		public static By checkoutLinkElement = (By.xpath("//a[@href='/checkout/']"));
		
		public static By cartListTitleElement = (By.xpath("//h3[@class='cart-list-title']/span"));
		
		public static By itemInCartElement = (By.xpath("//div[@class='cart-list cart-list-active']//div[@class='cart-item-row'][1]//div[@class='cart-item-name js-product-title']/a[@id='CartItemInfo']/span"));
	}


