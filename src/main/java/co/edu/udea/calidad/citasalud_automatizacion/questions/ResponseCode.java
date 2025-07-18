package co.edu.udea.calidad.citasalud_automatizacion.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;

public class ResponseCode implements Question<Integer> {

    public static ResponseCode was() {
        return new ResponseCode();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

}