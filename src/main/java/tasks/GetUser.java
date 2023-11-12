package tasks;

import interactions.ConsumeServices;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import static utils.Routes.GET_SINGLE_USER;

public class GetUser implements Performable {
    private String endpoint;

    public GetUser(String endpoint) {
        this.endpoint = endpoint;
    }

    public static GetUser with(){
        return Instrumented.instanceOf(GetUser.class).withProperties(GET_SINGLE_USER.toString());
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ConsumeServices.withGet(endpoint)
        );
    }
}
