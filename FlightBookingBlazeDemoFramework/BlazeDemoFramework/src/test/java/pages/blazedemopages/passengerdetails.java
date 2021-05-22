package blazedemopages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class passengerdetails extends BasePage {

	WebDriver driver = null;

	//locator for identifying the confirmation message
	By confirmation_message = By.xpath("//h2[contains(text(),'Your flight from TLV to SFO has been reserved.')]");	
	//locator for verifying airline name selected on reservation page
	By airline_name_chosen = By.xpath("//p[contains(text(),'Airline: United')]");
	//locator for verifying flight number selected on reservation page
	By flight_number_chosen = By.xpath("//p[contains(text(),'Flight Number: UA954')]");
	//locator for verifying the price
	By price_of_flight = By.xpath("//p[contains(text(),'Price: 400')]");
	//locator for verifying the Arbitrary Fees and Taxes
	By Arbitrary_Fees_and_Taxes = By.xpath("//p[contains(text(),'Arbitrary Fees and Taxes: 514.76')]");
	//Locator for passenger first and last name
	By passenger_firstandlast_name = By.id("inputName");
	//Locator for passenger address
	By passenger_address = By.id("address");
	//Locator for passenger City
	By passenger_city = By.id("city");
	//Locator for passenger State
	By passenger_state = By.id("state");
	//Locator for passenger ZipCode
	By passenger_zipcode = By.id("zipCode");
	//Locator for passenger Card Type
	By cardtype = By.name("cardType");
	//Locator for passenger Credit Card Number
	By credit_cardnumber = By.id("creditCardNumber");
	//Locator for passenger Credit Card Month
	By credit_cardmonth = By.id("creditCardMonth");
	//Locator for passenger Credit Card Month
	By credit_cardyear = By.id("creditCardYear");
	//Locator for name on Credit Card 
	By name_on_creditcard = By.id("nameOnCard");
	//Locator for remember me check box
	By remember_me_check_box = By.id("rememberMe");
	//Locator for remember me check box
	By purchase_button = By.xpath("//input[@class='btn btn-primary']");

	public passengerdetails(WebDriver driver) {
		this.driver = driver;
	}
	// method to verify the confirmation message
	public void verifyconfirmationmessage(String text) {
		String confirmationmessage = driver.findElement(confirmation_message).getText();
		System.out.println("Confirmation message is: "+confirmationmessage);
		String Expectedconfirmationmessage = "Your flight from TLV to SFO has been reserved.";
		Assert.assertEquals(confirmationmessage,Expectedconfirmationmessage);
	}
	// method to verify the airline name
	public void verifyairlinename() {
		String airlinenamechosen = driver.findElement(airline_name_chosen).getText();
		System.out.println("The airline chosen is:" + airlinenamechosen);
	}
	// method to verify the flight number
	public void verifflightnumber() {
		String flightnumberchosen = driver.findElement(flight_number_chosen).getText();
		System.out.println("The flight numbr chosen is:" + flightnumberchosen);
	}
	// method to verify the price 
	public void verifyprovidedprice() {
		String priceprovided = driver.findElement(price_of_flight).getText();
		System.out.println("The price provided is:" + priceprovided);
	}
	// method to verify the Arbitrary Fees and Taxes 
	public void verifyarbitraryfeestaxes() {
		String arbitraryfeeandtaxes = driver.findElement(Arbitrary_Fees_and_Taxes).getText();
		System.out.println("The Arbitrary Fees and Taxes is:" + arbitraryfeeandtaxes);
	}

	// method to enter passenger first and last name
	public void enterpassengerfirstandlastname(String text) {
		WebElement passengerfirstlastname = driver.findElement(passenger_firstandlast_name);
		passengerfirstlastname.sendKeys(text);
	}

	// method to enter passenger address
	public void enterpassengeraddress(String text1) {
		WebElement passengeraddress = driver.findElement(passenger_address);
		passengeraddress.sendKeys(text1);
	}

	// method to enter passenger city
	public void enterpassengercity(String text2) {
		WebElement passengercity = driver.findElement(passenger_city);
		passengercity.clear();
		passengercity.sendKeys(text2);
	}
	// method to enter passenger state
	public void enterpassengerstate(String text3) {
		WebElement passengerstate = driver.findElement(passenger_state);
		passengerstate.clear();
		passengerstate.sendKeys(text3);
	}
	// method to enter passenger zip code
	public void enterpassengerzipcode(String text4) {
		WebElement passengerzipcode  = driver.findElement(passenger_zipcode );
		passengerzipcode.clear();
		passengerzipcode.sendKeys(text4);
	}

	// method to select passenger credit card type from drop down i.e. Visa, American Express, Diners Club
	public void selectcardtype() {
		driver.findElement(cardtype).click();
		Select cardformat = new Select(driver.findElement(cardtype));
		cardformat.selectByValue("amex");
	}

	// method to enter passenger 16 digit credit card number
	public void entercreditcardnumber(String text5) {
		WebElement passengercreditcardnumber   = driver.findElement(credit_cardnumber);
		passengercreditcardnumber.clear();
		passengercreditcardnumber.sendKeys(text5);
	}
	// method to enter passenger credit card month
	public void entercreditcardmonth(String text6) {
		WebElement passengercreditcardmonth   = driver.findElement(credit_cardmonth);
		passengercreditcardmonth.clear();
		passengercreditcardmonth.sendKeys(text6);
	}
	// method to enter passenger credit card year
	public void entercreditcardyear(String text7) {
		WebElement passengercreditcardyear   = driver.findElement(credit_cardyear);
		passengercreditcardyear.clear();
		passengercreditcardyear.sendKeys(text7);
	}
	// method to enter Name on Credit card
	public void enternameoncreditcard(String text8) {
		WebElement nameoncreditcard   = driver.findElement(name_on_creditcard);
		nameoncreditcard.clear();
		nameoncreditcard.sendKeys(text8);
	}
	// method to tick the "remember me" check box
	public void tickremembermecheckbox() {
		WebElement rememberme   = driver.findElement(remember_me_check_box);
		rememberme.click();
	}
	// method to click on purchase button
	public void clickpurchasebutton() {
		WebElement clickpurchase = driver.findElement(purchase_button);
		clickpurchase.click();
	}

}





