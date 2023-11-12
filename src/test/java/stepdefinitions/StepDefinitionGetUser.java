package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.LastResponseStatus;
import tasks.GetUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constants.GET_USER_CODE;

public class StepDefinitionGetUser {
    @When("^you search an user$")
    public void youSearchAnUser() {
        theActorInTheSpotlight().attemptsTo(
                GetUser.with()
        );
    }

    @Then("^I should see that user$")
    public void iShouldSeeThatUser() {
        theActorInTheSpotlight().should(seeThat(LastResponseStatus.is(GET_USER_CODE)));
    }
}
