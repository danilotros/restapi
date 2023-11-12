package interactions;

import net.serenitybdd.screenplay.Tasks;

public class ConsumeServices {
    private ConsumeServices(){

    }
    public static PostMethod withPost(String enpoint,Object body){
        return Tasks.instrumented(PostMethod.class,enpoint,body);
    }
    public static GetMethod withGet(String endpoint){
        return Tasks.instrumented(GetMethod.class,endpoint);
    }
}
