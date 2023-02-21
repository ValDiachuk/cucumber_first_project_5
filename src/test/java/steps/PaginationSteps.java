package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPaginationPage;
import utilities.Driver;

public class PaginationSteps {
    WebDriver driver;
    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalPaginationPage techGlobalPaginationPage;
    @Before
    public void setup(){
        driver = Driver.getDriver();
        techGlobalBasePage = new TechGlobalBasePage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalPaginationPage = new TechGlobalPaginationPage();
    }
    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }
    @When("user moves to Practices header dropdown")
    public void userMovesToHeaderDropdown() {
        techGlobalBasePage.headerDropdown.click();
    }
    @And("user clicks on Frontend Testing header dropdown option")
    public void userClicksOnHeaderDropdownOption() {
        techGlobalBasePage.headerDropdownOptions.get(0).click();
    }
    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }
    @And("user clicks on {string} card")
    public void userClicksOnCard(String paginationCard) {
        techGlobalFrontendTestingHomePage.clickOnCard(paginationCard);
    }
    @And("user should see {string} heading")
    public void userShouldSeeHeading(String heading) {
        switch (heading) {
            case "Pagination":
                Assert.assertEquals("Pagination", techGlobalPaginationPage.mainHeading.getText());
                break;
            case "World City Populations 2022":
            Assert.assertEquals("World City Populations 2022", techGlobalPaginationPage.subHeading.getText());
            break;
        }
    }
    @And("user should see {string} paragraph")
    public void userShouldSeeParagraph(String paragraph) {
        Assert.assertEquals(paragraph, techGlobalPaginationPage.pageContent.getText());
    }
    @And("user should see {string} button is disabled")
    public void userShouldSeeButtonIsDisabled(String button) {
        switch(button){
            case "Previous":
                Assert.assertFalse(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(techGlobalPaginationPage.nextButton.isEnabled());
                break;
        }
    }
    @And("user should see {string} button is enabled")
    public void userShouldSeeButtonIsEnabled(String button) {
        switch (button){
            case "Previous":
                Assert.assertTrue(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(techGlobalPaginationPage.nextButton.isEnabled());
                break;
        }
    }
    @When("user clicks on Next button")
    public void userClicksOnButton() {
        techGlobalPaginationPage.nextButton.click();
    }
    @When("user clicks on Next button till it becomes disabled")
    public void userClicksOnButtonTillItBecomesDisabled() {
        while (techGlobalPaginationPage.nextButton.isEnabled()){
            techGlobalPaginationPage.nextButton.click();
        }
    }
    @And("user should see city with info below and an image")
    public void userShouldSeeCityWithInfoBelowAndAnImage(DataTable information) {

        for (int i = 0; i < information.asList().size();i++) {
          Assert.assertEquals(techGlobalPaginationPage.countryInfo.get(i).getText(), information.asList().get(i));
          Assert.assertTrue(techGlobalPaginationPage.cityImage.isDisplayed());
        }
        techGlobalPaginationPage.nextButton.click();
    }
}