package co.edu.udea.calidad.citasalud_automatizacion.tasks;

import co.edu.udea.calidad.citasalud_automatizacion.models.RegisterRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterTask implements Task {

    private final RegisterRequest request;

    public RegisterTask(RegisterRequest request) {
        this.request = request;
    }

    public static RegisterTask withData(RegisterRequest request) {
        return instrumented(RegisterTask.class, request);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/auth/register")
                        .with(req -> req
                                .header("Content-Type", "application/json")
                                .body(request)
                        )
        );
    }
}
