package com.walmart;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WalmartCustomerTransactionFlow {

private static Scanner scan;

public static void main(String[] args) throws InterruptedException{
	
	
   System.setProperty("webdriver.chrome.driver","F://selenium/chromedriver.exe");
   
   // Create a new instance of the Chrome driver
   WebDriver driver = new ChromeDriver();

   // Wait For Page To Load
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

   // Navigate to URL
   driver.get("https://www.walmart.com");

   // Maximize the window
   driver.manage().window().maximize();

   // Verify you have landed in Right page of Walmart
   driver.findElement(WalmartPageElements.homePageElement).isDisplayed();
   Assert.assertTrue(driver.findElement(WalmartPageElements.homePageElement).isDisplayed(),"Walmart home page hasn't appeared");

   // Click on My Account to Display Sign-In page
   driver.findElement(WalmartPageElements.signInOptionElement).click();

   // Wait for the visibility of Login user name Element
   WebDriverWait wait = new WebDriverWait(driver, 5);
   WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(WalmartPageElements.userNameElement));

   // Enter UserName and Password given as XXXXXXXXX which can be replaced with the email id and password
   username.sendKeys("test123@live.com");
   driver.findElement(WalmartPageElements.passwordElement).sendKeys("test123");

   // Click on 'Sign In' button
   driver.findElement(WalmartPageElements.signInButtonElement).click();

   // Verify you have successfully logged into Walmart Application
   wait.until(ExpectedConditions.visibilityOfElementLocated(WalmartPageElements.recentOrderHeadingElement));
   System.out.println("1. Successfully logged onto the application.");
   
   // Reading the keyword that user desired to search for
   System.out.println("Enter the search keyword and press enter");
   scan = new Scanner(System.in);
   String item = scan.nextLine();
   search(driver,item);
   
   String searchItemTitle = null;
   
   // Identify an item from the result set that you can add to cart
   switch(item.toLowerCase()){
   		case "toys":
   		   wait.until(ExpectedConditions.visibilityOfElementLocated(WalmartPageElements.searchGridElement));
   		   searchItemTitle = driver.findElement(WalmartPageElements.searchToysFirstElement).getText();
   		   driver.findElement(WalmartPageElements.searchToysFirstElement).click();
   		   break;
   		   
   		case "socks":
   		   wait.until(ExpectedConditions.visibilityOfElementLocated(WalmartPageElements.searchItemElement));
   		   searchItemTitle = driver.findElement(WalmartPageElements.searchSocksFirstElement).getText();
   		   driver.findElement(WalmartPageElements.searchSocksFirstElement).click();
   		   break;
   		   
   		default:
   		   wait.until(ExpectedConditions.visibilityOfElementLocated(WalmartPageElements.searchItemElement));
   		   searchItemTitle = driver.findElement(WalmartPageElements.searchItemFirstElement).getText();
   		   driver.findElement(WalmartPageElements.searchItemFirstElement).click();
   		
   		   //Identifying the color of phone
   		   if(item.contains("iphone")){
   			   driver.findElement(WalmartPageElements.iphoneColorElement).click();
   			   Thread.sleep(2000);
   		   }
   		   
   }
 
   System.out.println("3. Name of the item identified is "+searchItemTitle);
   
 
   
   // Add the item to cart
   driver.findElement(WalmartPageElements.addToCartButtonElement).click();
   System.out.println("4. Item added to cart.");
   wait.until(ExpectedConditions.visibilityOfElementLocated(WalmartPageElements.modelInnerFlexStackElement));
  
   // Go to Cart to check the item selected is same and only selected item is present
   driver.findElement(WalmartPageElements.viewCartButton).click();
   wait.until(ExpectedConditions.invisibilityOfElementLocated(WalmartPageElements.modelInnerFlexStackElement));

   // Validate that item added is the only item in the cart
   wait.until(ExpectedConditions.visibilityOfElementLocated(WalmartPageElements.checkoutLinkElement));
   String noOfItemsInCart = driver.findElement(WalmartPageElements.cartListTitleElement).getText().split(" ")[0];
   Assert.assertEquals(Integer.parseInt(noOfItemsInCart), 1,"There should be only one item added to the cart");

   // Validate that item added is present
   String productInCart = driver.findElement(WalmartPageElements.itemInCartElement).getText();
   Assert.assertEquals(searchItemTitle, productInCart, "Product in cart is not same as Selected Product");
   System.out.println("5. Item added is present in cart and is the only item in the cart.");
   System.out.println("Test Passed for Walmart Cutomer Transaction Flow");
   // Close the browser.
   driver.close();

}

	// This method is used to search the item which is given as input
   private static void search(WebDriver driver, String item) {
	   driver.findElement(WalmartPageElements.searchBoxTextElement).sendKeys(item);
	   driver.findElement(WalmartPageElements.searchButtonElement).click();
	   System.out.println("2. Searching for the items related to "+ item+".");
	
   }
}

