package co.edu.udea.calidad.citasalud_automatizacion.stepdefinitions;

import co.edu.udea.calidad.citasalud_automatizacion.questions.ResponseCode;
import co.edu.udea.calidad.citasalud_automatizacion.tasks.LoginTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Robin")
                .can(CallAnApi.at("https://citasalud-back.onrender.com"));
    }

    @Given("que soy un usuario registrado")
    public void queSoyUnUsuarioRegistrado() {
        OnStage.theActorCalled("Robin");
    }

    @When("ingreso mis credenciales válidas")
    public void ingresoMisCredencialesValidas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials("1001370327", "udea2025@M")
        );
    }

    @When("ingreso credenciales inválidas")
    public void ingresoCredencialesInvalidas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials("123456789", "contrasena_incorrecta")
        );
    }

    @Then("debería ver una respuesta exitosa del sistema")
    public void deberiaVerUnaRespuestaExitosaDelSistema() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResponseCode.was(), equalTo(200))
        );
    }

    @Then("debería ver una respuesta de error del sistema")
    public void deberiaVerUnaRespuestaDeErrorDelSistema() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResponseCode.was(), equalTo(403))
        );
    }

}
