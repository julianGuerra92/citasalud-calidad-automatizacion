package co.edu.udea.calidad.citasalud_automatizacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/register.feature",
        glue = "co.edu.udea.calidad.citasalud_automatizacion.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RegisterRunner {
}
