package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Pages.HomePage;
import com.nttdata.testing.Tasks.NavigateTo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Alert;


import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistrarUsuarioStepDefinition {
    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {

        actor.attemptsTo(NavigateTo.theHomePage());
    }

    @And("selecciona el boton de registro")
    public void seleccionaElBotonDeRegistro() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_SIGN_UP));
    }

    @And("selecciona el boton de login")
    public void seleccionaElBotonDeLogin() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_LOGIN));
    }

    @And("ingresa un nombre de usuario {string} y contrasenia {string}")
    public void ingresaUnNombreDeUsuarioYContrasenia(String username, String password) {
        theActorInTheSpotlight().attemptsTo(Enter.theValue(username).into(HomePage.INP_USERNAME));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(HomePage.INP_PASSWORD));
    }

    @And("ingresa al login un nombre de usuario {string} y contrasenia {string}")
    public void ingresaalloginUnNombreDeUsuarioYContrasenia(String username, String password) {
        theActorInTheSpotlight().attemptsTo(Enter.theValue(username).into(HomePage.LOGIN_USERNAME));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(HomePage.LOGIN_PASSWORD));
    }

    @When("selecciona el boton registrar")
    public void seleccionaElBotonRegistrar() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_REGISTRAR));
    }

    @When("selecciona el boton loguear")
    public void seleccionaElBotonloguear() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_CONFIRM_LOGIN));
    }

    @Then("se realiza el registro de manera exitosa")
    public void seRealizaElRegistroDeManeraExitosa() {
        System.out.println("exitoso");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




    @Given("el {actor} está en la página de productos")
    public void eluUsuarioEstaEnLaPaginaDeProductos() {
        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theHomePage()
        );
    }
    @When("selecciona un producto")
    public void SeleccionaUnProducto() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.PRODUCT_ITEM));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("el sistema muestra un mensaje de {string}")
    public void elSistemaMuestraUnMensajeDe(String expectedMessage) {
        Alert alert = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().alert();
        String actualMessage = alert.getText();
        assert actualMessage.equals(expectedMessage) : "Esperaba el mensaje: " + expectedMessage + ", pero obtuve: " + actualMessage;
        alert.accept();
    }

    @Then("el producto aparece en el carrito")
    public void elProductoApareceEnElCarrito() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePage.CART_BUTTON) );

    }

    @When("el uusuario selecciona un producto y lo agrega al carrito")
    public void elUusuarioSeleccionaUnProductoYLoAgregaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.PRODUCT_ITEM));
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.ADD_TO_CART_BUTTON));
    }

    @And("seleccion addtocart")
    public void seleccionAddtocart() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.ADD_TO_CART_BUTTON));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

