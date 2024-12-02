package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.Marca;

import static org.hamcrest.Matchers.is;
import static utilities.FrontEndOperation.checkThat;
import static utilities.FrontEndOperation.waitSeconds;

public class MyStepdads extends GenericTest<Marca> {

  @Before
    public void setUp() {
        cleanReportsAndLogs();
        setController();
    }

  @Given("I open the login page")
  public void iOpenTheLoginPage() {
    controller.acceptCookies();
  }

  @When("I enter the credentials")
  public void iEnterTheCredentials() {
    controller.fillLogin();
  }

  @Then("I should see the error message")
  public void iShouldSeeTheErrorMessage() {
    //waitSeconds(2);
    checkThat("Comparing visible message", controller.isVisible(), is(true));
  }

  @After
    public void tearDown() {
        shutController();
        runReports();
    }
}
