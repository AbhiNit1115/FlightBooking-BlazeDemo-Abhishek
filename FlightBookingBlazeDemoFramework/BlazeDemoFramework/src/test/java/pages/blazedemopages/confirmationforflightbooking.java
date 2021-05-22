package blazedemopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class confirmationforflightbooking extends BasePage {
	WebDriver driver = null;

	//Locator for the thank you message displayed post flight booking
	By message_displayed = By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]");
	//Locator for capturing the unique Id generated post flight booking
	By id_generated_post_booking = By.xpath("/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]");
	//Locator for capturing status of the booking
	By status_of_booked_flight = By.xpath("//td[contains(text(),'PendingCapture')]");
	//Locator for capturing amount of the booking
	By amount_of_booked_flight = By.xpath("//td[contains(text(),'555 USD')]");
	//Locator for capturing card number used for booking flight
	By card_number = By.xpath("//td[contains(text(),'xxxxxxxxxxxx1111')]");
	//Locator for capturing expiry date of the card number used for booking flight
	By expiry_date = By.xpath("//tr[5]//td[2]");
	//Locator for capturing auth code of the booked flight
	By auth_code = By.xpath("//td[contains(text(),'888888')]");
	//Locator for capturing date of the booked flight
	By date_of_booked_flight = By.xpath("/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[7]/td[2]");
	//Locator for clicking on "Travel the World" link to navigate o flight booking page again
	By travel_the_world_link = By.linkText("Travel The World");

	public confirmationforflightbooking(WebDriver driver) {
		this.driver = driver;
	}

	// method to verify the the thank you message post flight booking message
	public void verifythankyoumessage(String text) {
		String thanksmessage = driver.findElement(message_displayed).getText();
		System.out.println("Confirmation message is: "+thanksmessage);
		String Expectedthanksmessage = "Thank you for your purchase today!";
		Assert.assertEquals(thanksmessage,Expectedthanksmessage);
	}

	// method to enter passenger first and last name
	public void captureidpostbooking() {
		String capturedidvalue=driver.findElement(id_generated_post_booking).getText();
		System.out.println("The captured confirmation id is: "+capturedidvalue);
	}
	// method to capture the flight booking status
	public void captureflightstatus() {
		String bookingstatus = driver.findElement(status_of_booked_flight).getText();
		System.out.println("The booking status is:" + bookingstatus);
	}
	// method to capture the flight booking amount
	public void captureflightamount() {
		String bookingamount = driver.findElement(amount_of_booked_flight).getText();
		System.out.println("The booking amount is:" + bookingamount);
	}
	// method to capture the card number
	public void capturecardnumber() {
		String cardnumber = driver.findElement(card_number).getText();
		System.out.println("The card number is:" + cardnumber);
	}
	// method to capture the card expiration date
	public void capturecardexpirationdate() {
		String cardexpiry = driver.findElement(expiry_date).getText();
		System.out.println("The card expiry date is:" + cardexpiry);
	}
	// method to capture the card expiration date
	public void captureauthcode() {
		String authcode = driver.findElement(auth_code).getText();
		System.out.println("The auth code is:" + authcode);
	}
	// method to capture the card expiration date
	public void capturedate() {
		String dateofbooking = driver.findElement(date_of_booked_flight).getText();
		System.out.println("The date of booked flight is:" + dateofbooking);
	}
	// method to click on "Travel the World" link to navigate o flight booking page again
	public void clicktraveltheworllink() {
		driver.findElement(travel_the_world_link).click();
	}
}
