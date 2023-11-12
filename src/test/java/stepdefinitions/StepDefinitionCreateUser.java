package stepdefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserModel;


import tasks.CreateUser;
import questions.LastResponseStatus;



import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constants.CREATE_USER_CODE;

public class StepDefinitionCreateUser {
    @When("^you create an user with name (.*) and job (.*)$")
    public void youCreateAnUserWithNameAndJob(String name, String job) {
        List<UserModel> userModelList=new ArrayList<UserModel>();
        UserModel userModel=new UserModel(name,job);
        userModelList.add(userModel);
        theActorInTheSpotlight().attemptsTo(CreateUser.with(userModelList));
    }

    @Then("I should see that user created")
    public void iShouldSeeThatUserCreated() {
        theActorInTheSpotlight().should(seeThat(LastResponseStatus.is(CREATE_USER_CODE)));
    }


}
