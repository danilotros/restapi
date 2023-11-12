package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LastResponseStatus implements Question<Boolean> {
    private int cod;

    public LastResponseStatus(int cod) {
        this.cod = cod;
    }
    public static LastResponseStatus is(int cod){
        return new LastResponseStatus(cod);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int response= SerenityRest.lastResponse().getStatusCode();
        return response==cod;
    }
}
