package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LandingPage;
import resources.Base;

public class LandingTest extends Base {

	public LandingPage lp;

	@BeforeTest
	public void bfTest() throws IOException {
		initializeDriver();
		openUrl();
	}

	@Test
	public void validateButton() {
		lp = new LandingPage(driver);
		lp.getClickFlights().click();
		lp.getClickOneway().click();
		lp.getCLickRoundway().click();
	}

	@Test(dependsOnMethods = "validateButton")
	public void validateFrom() throws InterruptedException {
		lp.getFrom().sendKeys("TORONTO");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String from = "return document.getElementById(\"flight-origin-hp-flight\").value;";
		String fromText = (String) js.executeScript(from);
		while (!fromText.equalsIgnoreCase("TORONTO")) {
			lp.getFrom().sendKeys(Keys.ARROW_DOWN);
			fromText = (String) js.executeScript(from);
			System.out.println(fromText);
		}
		lp.getFrom().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = "validateFrom")
	public void validateTo() throws InterruptedException {
		lp.getTo().sendKeys("Ahmedabad");
		Thread.sleep(3000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		String to = "return document.getElementById(\"flight-destination-hp-flight\").value;";
		String toText = (String) js1.executeScript(to);
		while (!toText.equalsIgnoreCase("Ahmedabad")) {
			lp.getTo().sendKeys(Keys.ARROW_DOWN);
			toText = (String) js1.executeScript(to);
			System.out.println(toText);
		}
		lp.getTo().sendKeys(Keys.ENTER);
	}

	@Test(dependsOnMethods = "validateTo")
	public void validateDepartindDate() throws InterruptedException {
		lp.getDepertingFlight().click();
		Thread.sleep(3000);

		while (!lp.getCalenderMonth().getText().equalsIgnoreCase("Nov 2019")) {
			lp.getCalenderNavigateMonth().click();
		}

		int departCount = lp.getCalenderDate().size();
		Thread.sleep(3000);
		for (int i = 0; i < departCount; i++) {

			String date = lp.getCalenderDate().get(i).getText();

			if (date.contains("21")) {
				lp.getCalenderDate().get(i).click();
				break;
			}
		}

	}

	@Test(dependsOnMethods = "validateDepartindDate")
	public void validateReturnDate() throws InterruptedException {
		lp.getReturnFlight().click();
		Thread.sleep(3000);

		while (!lp.getCalenderMonth().getText().equalsIgnoreCase("Dec 2019")) {
			lp.getCalenderNavigateMonth().click();
		}

		int count = lp.getCalenderDate().size();
		Thread.sleep(3000);
		for (int i = 0; i < count; i++) {
			String date = lp.getCalenderDate().get(i).getText();

			if (date.contains("23")) {
				lp.getCalenderDate().get(i).click();
				break;
			}
		}
	}

	@Test(dependsOnMethods = "validateReturnDate")
	public void validateTravelInfo() throws InterruptedException {
		lp.getClickTraveller().click();

		WebElement Adult = lp.getClickAdult();
		for (int k = 0; k < 2; k++) {
			Adult.click();
		}

		WebElement Children = lp.getClickChild();
		for (int j = 0; j < 1; j++) {
			Children.click();
		}

		Select childAge = new Select(lp.getChildAge());
		Thread.sleep(2000);
		childAge.selectByIndex(9);

		WebElement infant = lp.getInfant();
		for (int l = 0; l < 1; l++) {
			infant.click();
		}

		lp.getInfantAge().click();
		Select infantAge = new Select(lp.getInfantAge());
		Thread.sleep(2000);
		infantAge.selectByIndex(1);

	}

	@Test(dependsOnMethods = "validateTravelInfo")
	public void validateSerch() throws InterruptedException {
		lp.getSerch().click();
		Thread.sleep(5000);
	}

	@Test(dependsOnMethods = "validateSerch")
	public void validatePriceList() {
		int listSize = lp.getPriceList().size();
		System.out.println(listSize);

		for (int x = 0; x < listSize; x++) {
			String price = lp.getPriceList().get(x).getText();
			System.out.println(price);

		}

	}

	@AfterTest
	public void afTest() {
		driver.close();
	}

}
