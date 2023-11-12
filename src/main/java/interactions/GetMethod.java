package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetMethod implements Interaction {
    private String endpoint;

    public GetMethod(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endpoint)
        );
    }
}
