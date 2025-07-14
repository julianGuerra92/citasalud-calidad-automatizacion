package co.edu.udea.calidad.citasalud_automatizacion.stepdefinitions;

import co.edu.udea.calidad.citasalud_automatizacion.models.RegisterRequest;
import co.edu.udea.calidad.citasalud_automatizacion.questions.ResponseCode;
import co.edu.udea.calidad.citasalud_automatizacion.tasks.RegisterTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class RegisterStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Robin")
                .can(CallAnApi.at("https://citasalud-back.onrender.com"));
    }

    @Given("que quiero registrarme como nuevo usuario")
    public void queQuieroRegistrarmeComoNuevoUsuario() {
        OnStage.theActorCalled("Robin");
    }

    @When("ingreso los datos de nuevo usuario")
    public void ingresoLosDatosDeNuevoUsuario() {
        RegisterRequest request = new RegisterRequest(
                "1001370439",
                "udea2025@Mm",
                "Nelson",
                "Aguirre",
                "Antioquia",
                "Medellín",
                "Calle Falsa 123",
                "nelson.aguirre6@udea.edu.co",
                "3011234567"
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterTask.withData(request)
        );
    }

    @When("ingreso los datos: {string}, {string}, {string}")
    public void ingresoDatosInvalidos(String dni, String password, String email) {
        RegisterRequest request = new RegisterRequest(
                dni,
                password,
                "Nombre",
                "Apellido",
                "Antioquia",
                "Medellín",
                "Calle Ejemplo 123",
                email,
                "3011234567"
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterTask.withData(request)
        );
    }

    @Then("debería recibir una respuesta correcta")
    public void deberiaRecibirElCorreoDeConfirmacion() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResponseCode.was(), equalTo(200))
        );
    }

    @Then("debería recibir una respuesta de error del sistema")
    public void deberiaRecibirRespuestaDeErrorDelSistema() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResponseCode.was(), equalTo(403))
        );
    }
}
