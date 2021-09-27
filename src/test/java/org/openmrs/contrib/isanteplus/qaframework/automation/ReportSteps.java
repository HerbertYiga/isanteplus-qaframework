package org.openmrs.contrib.isanteplus.qaframework.automation;

import org.openmrs.contrib.isanteplus.qaframework.RunTest;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.HomePage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.LoginPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.ReportsPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.RunReportPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.test.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportSteps extends TestBase {
	
	private LoginPage loginPage;
	
	private HomePage homePage;
	
	private ReportsPage  reportsPage;
	
	private RunReportPage runReportPage;
	
	
	@Before(RunTest.HOOK.REPORTS)
	public void setUp() {
		loginPage = new LoginPage(getWebDriver());
	}
	
	@After(RunTest.HOOK.REPORTS)
	public void destroy() {
		quit();
	}
	
	@Given("User loads HomePage")
	public void visitLoginPage() throws Exception {
		homePage = loginPage.goToHomePage();
	}
	
	@When("User clicks on Report App") 
	public void clickOnReportApp() {
		reportsPage = homePage.clickOnReportsApp();
	}
	
	@And("User click the Report Name")
	public void clickOnNumberOfHivLink() {
		runReportPage = reportsPage.clickOnNUmberOfHivPatientsLink();
	}
	
	@Then("User clicks on calendar icon")
	public void userClicksOnCurrendar() {
		runReportPage.clickOnCalender();
	}
	
	@And("User clicks on start date calendar")
	public void userClicksOnStartDate() {
		runReportPage.chooseCurrentDate();
	}
	
	@And("User Select the output format")
	public void selectFormat() {
		runReportPage.selectOutPutFormat();
	}

	@Then("User clicks on Run Button")
	public void userClicksOnRunReport() {
		runReportPage.clickOnRunButton();
		runReportPage.waitForPage();
	}
}
