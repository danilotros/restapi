package stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static utils.Routes.BASE_URL;

public class SetTheStage {
    @Before
    public void prepateStage(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("daniel").whoCan(CallAnApi.at(BASE_URL.toString()));
    }
}
