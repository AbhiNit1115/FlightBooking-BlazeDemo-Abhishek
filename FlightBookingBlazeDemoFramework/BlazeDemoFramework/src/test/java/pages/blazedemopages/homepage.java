package blazedemopages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class homepage extends BasePage {
	WebDriver driver = null;
	
	//Locator for Departure City
	By departure_city_dropdown_value = By.name("fromPort");
	//Locator for Destination City
	By destination_city_dropdown_value = By.name("toPort");
	//Locator for Find Flights button
	By find_flights_button = By.xpath("//input[@class='btn btn-primary']");
	
	//creating constructor for class home page
	public homepage(WebDriver driver) {
		this.driver = driver;
	}

	// method to select departure city from drop down
	public void selectdeparturecity() {
		driver.findElement(departure_city_dropdown_value).click();
		Select depCity = new Select(driver.findElement(departure_city_dropdown_value));
		depCity.selectByVisibleText("Philadelphia");
	}
	
	//method to select destination city from drop down
	public void selectdestinationcity() {
		driver.findElement(destination_city_dropdown_value).click();
		Select desCity = new Select(driver.findElement(destination_city_dropdown_value));
		desCity.selectByVisibleText("London");
	}

    //method to click on find flights button
	public void clickfindflightsbutton() {
		driver.findElement(find_flights_button).sendKeys(Keys.RETURN);
		}
	}
