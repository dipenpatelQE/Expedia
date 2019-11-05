package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {
	
	WebDriver driver;
	
	@FindBy(id="tab-flight-tab-hp")
	WebElement flights;
	
	@FindBy(id = "flight-type-one-way-label-hp-flight")
	WebElement oneway;
	
	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	WebElement roundway;
	
	@FindBy(id ="flight-origin-hp-flight")
	WebElement from;
	
	@FindBy(id = "flight-destination-hp-flight")
	WebElement to;
	
	@FindBy(xpath = "//input[@id='flight-departing-hp-flight']")
	WebElement depertingflight;
	
	@FindBy(css = ".datepicker-cal-month-header")
	WebElement calendermonth;
	
	@FindBy(css = ".datepicker-paging.datepicker-next.btn-paging.btn-secondary.next")
	WebElement calendernavigatemonth;
	
	@FindBy(css = ".datepicker-cal-date")
	List<WebElement> calenderdate;
	
	@FindBy(id = "flight-returning-hp-flight")
	WebElement returnflight;
	
	@FindBy(xpath = "//div[@id='traveler-selector-hp-flight']")
	WebElement traveller;
	
	@FindBy(xpath = "(//*[@id='traveler-selector-hp-flight']//button[@class='uitk-step-input-button uitk-step-input-plus'])[1]")
	WebElement adult;
	
	@FindBy(xpath = "(//*[@id='traveler-selector-hp-flight']//button[@class='uitk-step-input-button uitk-step-input-plus'])[2]")
	WebElement child;
	
	@FindBy(id = "flight-age-select-1-hp-flight")
	WebElement childage;
	
	@FindBy(xpath = "(//*[@id='traveler-selector-hp-flight']//button[@class='uitk-step-input-button uitk-step-input-plus'])[3]")
	WebElement infant;
	
	@FindBy(xpath = "//select[@class='gcw-storeable gcw-toggles-field-by-value gcw-child-age-select gcw-infant-age-1-sa']")
	WebElement infantage;
	
	@FindBy(xpath = "//form[@id='gcw-flights-form-hp-flight']//div[@class='cols-nested ab25184-submit']//button[@type='submit']")
	WebElement search;
	
	@FindBy(xpath = "//span[@class='full-bold no-wrap']")
	List<WebElement> pricelist;
	
	public LandingPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickFlights() 
	{
		return flights;
	}
	
	public WebElement getClickOneway() 
	{
		return oneway;
	}
	
	public WebElement getCLickRoundway() 
	{
		return roundway;
	}
	
	public WebElement getFrom() 
	{
		return from;
	}
	
	public WebElement getTo() 
	{
		return to;
	}
	
	public WebElement getReturnFlight() 
	{
		return returnflight;
	}
	
	public WebElement getCalenderMonth() 
	{
		return calendermonth;
	}
	
	public WebElement getCalenderNavigateMonth() 
	{
		return calendernavigatemonth;
	}
	
	public List<WebElement> getCalenderDate() 
	{
		return calenderdate;
	}
	
	public WebElement getDepertingFlight() 
	{
		return depertingflight;
	}
	
	public WebElement getClickTraveller() 
	{
		return traveller;
	}
	
	public WebElement getClickAdult() 
	{
		return adult;
	}
	
	public WebElement getClickChild() 
	{
		return child;
	}
	
	public WebElement getChildAge() 
	{
		return childage;
		
	}
	
	public WebElement getInfant() 
	{
		return infant;
	}

	public WebElement getInfantAge() 
	{
		return infantage;
	}
	
	public WebElement getSerch() 
	{
		return search;
	}
	
	public List<WebElement> getPriceList() 
	{
		return pricelist;
	}
}
