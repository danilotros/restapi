package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostMethod implements Interaction {
    private String endpoint;
    private Object body;

    public PostMethod(String endpoint, Object body) {
        this.endpoint = endpoint;
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(requestSpecification -> requestSpecification
                                .header("Content-Type", ContentType.JSON)
                                .body(body)
                            )
        );

    }
}
