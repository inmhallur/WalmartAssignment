# WalmartAssignment
To test the Walmart web application transaction flow right from logging into the system for adding an item to the cart and asserting that selected item is present in the cart.

The test has been implemented using "Selenium WebDriver" tool and the programming language used to implement the test case is "JAVA".
My familiarity with JAVA programming language and Selenium WebDriver is the reason behind my technical choices.

Instructions to run the program:

1. Make sure you have to add selenium.jar file in your package.
2. Make sure that Java is installed.
3. Download WallmartAssignment from GITHUB. Following is the url: https://github.com/maharshibhavanam/WalmartAssignment
4. Open command prompt and change the directory to the downloaded WallmartAssignment project directory.
5. Run "javac WalmartCustomerTransactionFlow.java" and hit enter.
6. Run "java WalmartCustomerTransactionFlow" and press enter.
7. While running the program it will ask for item to search for.
8. Enter any one keyword from the list of keywords(iphone, tv, socks, dvd, toys) and press enter.
9. After the program is completed, you will find the message "Test Passed for Walmart Cutomer Transaction Flow".

Precondition: 1. User name and password should be valid. 
              2. There should be no item in the cart.
	      3. Make sure you download "chromedriver.exe" from "www.seleniumhq.com" and set the folder directory in WalmartCustomerTransactionFlow.java file.

Files in the project:
1) WalmartCustomerTransactionFlow.java:
	This class contains the flow of the application starting from initiating the Chrome driver to add item to the cart and verifying it.

2) WalmartPageElements.java:
	This class stores elements of webpages.

Explanation of code:
1) First a new instance of Chrome browser is created.
2) Navigating to the URL "www.wallmart.com"
3) Wait for the page to load completely and maximize the browser.
4) Wait for the username element to load and then enter your email id and password.
5) Clicking on Sign In button validates user details and lands into the Home Page.
6) Enter the keyword that user desired to search for.
7) The search keyword is parameterized into the search method which displays all the related items.
8) Then the first item from the list of displayed items is selected which will land into the selected item web page.
9) Adding the item to cart by clicking on "Add to cart" button.
10) Click on "View Cart" button to see the item in the cart and assert whether the item added is same as the item in cart.
11) Checking that the item added is the only item present in the cart.
12) Finally the driver should be closed.

