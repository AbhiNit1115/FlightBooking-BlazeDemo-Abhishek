package blazedemopages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class chooseflight extends BasePage {
	WebDriver driver = null;

	//Locator for choosing the respective flight
	By choose_flight_button = By.xpath("//tr[3]//td[1]//input[1]");
	//Locator for verifying the flight#
	By verify_flight_number = By.xpath("//td[contains(text(),'9696')]");
	//Locator for verifying the flight name
	By verify_airline_name = By.xpath("//td[contains(text(),'Aer Lingus')]");
	//Locator for verifying the departure time
	By verify_departure_time = By.xpath("//td[contains(text(),'5:27 AM')]");
	//Locator for verifying the arrival time
	By verify_arrival_time = By.xpath("//td[contains(text(),'8:22 PM')]");
	//Locator for verifying the arrival time
	By verify_flight_price = By.xpath("//td[contains(text(),'$200.98')]");


	public chooseflight(WebDriver driver) {
		this.driver = driver;
	}	
	//method to click and choose the respective flights
	public void clickchoosethisflightbutton() {
		driver.findElement(choose_flight_button).sendKeys(Keys.RETURN);
	}
	//method to verify the flight number for the chosen fight
	public void verifyflightnumber() {
		String flightnumber = driver.findElement(verify_flight_number).getText();
		System.out.println("Flight Number is: "+flightnumber);
	}
	//method to verify the Airline name for the chosen fight
	public void verifyairlinname() {
		String airlinename = driver.findElement(verify_airline_name).getText();
		System.out.println("Airline Name is: "+airlinename);
	}
	//method to verify the departure time for the chosen fight
	public void verifydeparturetime() {
		String deptime = driver.findElement(verify_departure_time).getText();
		System.out.println("Departure time is: "+deptime);
	}
	//method to verify the arrival time for the chosen fight
	public void verifyarrivaltime() {
		String arrtime = driver.findElement(verify_arrival_time).getText();
		System.out.println("Arrival time is: "+arrtime);
	}
	//method to verify the price for the chosen fight
	public void verifyflightprice() {
		String airlieprice = driver.findElement(verify_flight_price).getText();
		System.out.println("Airline price is: "+airlieprice);
	}

}
