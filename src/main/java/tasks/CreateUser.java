package tasks;

import interactions.ConsumeServices;
import models.UserModel;
import utils.Routes;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import java.util.List;

public class CreateUser implements Performable {
    private List<UserModel> userModelList;

    public CreateUser(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }
    public static CreateUser with(List<UserModel> userModelList){
        return Instrumented.instanceOf(CreateUser.class).withProperties(userModelList);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ConsumeServices.withPost(Routes.CREATE_USER.toString(),userModelList.get(0))
        );
    }
}
