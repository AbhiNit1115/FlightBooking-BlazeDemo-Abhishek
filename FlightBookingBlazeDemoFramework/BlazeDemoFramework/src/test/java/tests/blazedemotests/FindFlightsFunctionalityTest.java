package blazedemotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import baseclass.flightbookingbaseclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import blazedemopages.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(blazedemotests.listners.class)
public class FindFlightsFunctionalityTest extends BaseTest{

	static WebDriver driver = null;
	ExtentSparkReporter htmlReporter;
	static ExtentReports extent;

	
	@Test(priority = 1)
	public static void findflightstest() {	

		// Test script for verifying the functionality of the home page i.e. user is
		// able to select origin and arrival city and can click on find flights button 

		//creating object of home page class
		homepage findflights = new homepage(driver);		
		//get home page driver title
		String homepageTitle = driver.getTitle();
		String ExpectedhomepageTitle = "BlazeDemo";
		System.out.println("Home Page Title is: " + homepageTitle );
		//verifying that the page title is correct to make sure that correct page is loaded
		Assert.assertEquals(ExpectedhomepageTitle,homepageTitle);
		//select departure city from drop down
		findflights.selectdeparturecity();
		//select destination city from drop down
		findflights.selectdestinationcity();
		//click on Find Flights button
		findflights.clickfindflightsbutton();
		//Navigate back from choose flight details page and verify that home page for destination and departure is displayed successfully.
		driver.navigate().back();
		//Print the title of the choose flight details home page
		System.out.println("After navigating back from Flight reservation screen title is: " + homepageTitle );
		//verifying that the page title is correct to make sure that correct page is loaded
		Assert.assertEquals(ExpectedhomepageTitle,homepageTitle);
		//Again click on Find Flights button
		findflights.clickfindflightsbutton();
	}

	@Test(priority = 2)
	public static void reserveflighttest() {

		//Test script to verify that flight reservation page is displayed and user
		//is able to choose the respective flights

		//creating object of choose flight class
		chooseflight selectflight = new chooseflight(driver);
		//get flight reservation page driver title
		String actualchooseflightTitle = driver.getTitle();
		String ExpectedchooseflightTitle = "BlazeDemo - reserve";
		System.out.println("Reservation Page Title is: " + actualchooseflightTitle );
		//verifying that the page title is correct to make sure that correct page is loaded
		Assert.assertEquals(ExpectedchooseflightTitle,actualchooseflightTitle);
		//verify flight number for the flight user is going to choose and capture it
		selectflight.verifyflightnumber();
		//verify airline name for the flight user is going to choose and capture it
		selectflight.verifyairlinname();
		//verify departure time for the flight user is going to choose and capture it
		selectflight.verifydeparturetime();
		//verify arrival time for the flight user is going to choose and capture it
		selectflight.verifyarrivaltime();
		//verify airline price for the flight user is going to choose and capture it
		selectflight.verifyflightprice();
		//selecting the flight from the flight reservation page
		selectflight.clickchoosethisflightbutton();
		
	}

	@Test (priority = 3)
	public static void enterpassengerdetailstest() {

		//Test script to verify that passenger details page is displayed and user
		// is able to provide all the details on the page and click Purchase Flight

		//creating object of passenger details class
		passengerdetails providepassengerdetails = new passengerdetails(driver);
		//get passenger details page driver title
		String actualprovidepassengertitle = driver.getTitle();
		String Expectedprovidepassengertitle = "BlazeDemo Purchase";
		System.out.println("Passenger Details page title is: " + actualprovidepassengertitle );
		//verifying that the page title is correct to make sure that correct page is loaded
		Assert.assertEquals(Expectedprovidepassengertitle,actualprovidepassengertitle);
		//Verify the confirmation message on purchase page
		providepassengerdetails.verifyconfirmationmessage("Your flight from TLV to SFO has been reserved.");
		//verify the airline name on the purchase screen
		providepassengerdetails.verifyairlinename();
		//verify the flight number on the purchase screen
		providepassengerdetails.verifflightnumber();
		//verify the price on the purchase screen
		providepassengerdetails.verifyprovidedprice();
		// verify the Arbitrary Fees and Taxes on the purchase screen
		providepassengerdetails.verifyarbitraryfeestaxes();
		//Provide passenger first and last name
		providepassengerdetails.enterpassengerfirstandlastname("Tom Hardy");
		//Provide passenger address
		providepassengerdetails.enterpassengeraddress("432 Bakers St., 5th Main");
		//Provide passenger city
		providepassengerdetails.enterpassengercity("Georgia");
		//Provide passenger state
		providepassengerdetails.enterpassengerstate("Florida");
		//Provide passenger zip code
		providepassengerdetails.enterpassengerzipcode("654469");
		//Select the card type for payment i.e. Amex, Visa, Diners club
		providepassengerdetails.selectcardtype();
		//Provide 16digit credit card number
		providepassengerdetails.entercreditcardnumber("1002652132654125");
		//Provide credit card month
		providepassengerdetails.entercreditcardmonth("Mar");
		//Provide credit card year
		providepassengerdetails.entercreditcardyear("2022");
		//Provide name on the credit card
		providepassengerdetails.enternameoncreditcard("Tom Hardy");
		//Tick the remember me check box
		providepassengerdetails.tickremembermecheckbox();
		//Click on Purchase Flight button after providing all the details and
		//post clicking on Purchase flight button user is navigated to confirmation page
		providepassengerdetails.clickpurchasebutton();		
		//Navigate back to passenger details page and verify that remember me check box is ticked
		driver.navigate().back();
		WebElement remember_me_cheeckbox = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		System.out.println("The checkbox for remember me is - " + remember_me_cheeckbox.isSelected());
		//Again click on Purchase Flight button.
		providepassengerdetails.clickpurchasebutton();
	}
	@Test (priority = 4)
	public static void confirmationdetailstest() {

		//Test script to verify that confirmation page is displayed post user clicks
		//on purchase flight button along with booking id and confirmation status

		//creating object of confirmation for flight booking class
		confirmationforflightbooking getconfirmationdetails = new confirmationforflightbooking(driver);
		//get confirmation for flight booking page driver title
		String actualconfirmationforflightbooking = driver.getTitle();
		String Expectedconfirmationforflightbooking = "BlazeDemo Confirmation";
		System.out.println("Confirmation Page title is: " + actualconfirmationforflightbooking );
		//verifying that the page title is correct to make sure that correct page is loaded
		Assert.assertEquals(Expectedconfirmationforflightbooking,actualconfirmationforflightbooking);
		//verifying the thank you message displayed on the confirmation screen
		getconfirmationdetails.verifythankyoumessage("Thank you for your purchase today!");
		//capturing the confirmation id post flight booking
		getconfirmationdetails.captureidpostbooking();
		//capturing the flight status post flight booking
		getconfirmationdetails.captureflightstatus();
		//capturing the flight amount post flight booking
		getconfirmationdetails.captureflightamount();
		//capturing the credit card number
		getconfirmationdetails.capturecardnumber();
		//capturing the card expiry date
		getconfirmationdetails.capturecardexpirationdate();
		//capturing the auth code
		getconfirmationdetails.captureauthcode();
		//capturing the date of the booked flight
		getconfirmationdetails.capturedate();
		//click click on "Travel the World" link to navigate o flight booking page again
		getconfirmationdetails.clicktraveltheworllink();
		String homepageTitle1 = driver.getTitle();
		String ExpectedhomepageTitle1 = "BlazeDemo";
		System.out.println("The titile of the home page post navigation from confirmation screen is: " + homepageTitle1 );
		//verifying that the page title is correct to make sure that correct page is loaded
		Assert.assertEquals(ExpectedhomepageTitle1,homepageTitle1);
	}

	}
}
