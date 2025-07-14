package co.edu.udea.calidad.citasalud_automatizacion.tasks;

import co.edu.udea.calidad.citasalud_automatizacion.models.LoginRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task{
    private final LoginRequest loginRequest;

    public LoginTask(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    public static LoginTask withCredentials(String dni, String password) {
        return instrumented(LoginTask.class, new LoginRequest(dni, password));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/auth/login")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(loginRequest)
                        )
        );
    }
}