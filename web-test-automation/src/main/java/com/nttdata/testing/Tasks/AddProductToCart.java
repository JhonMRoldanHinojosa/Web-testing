package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.Alert;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class AddProductToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.PRODUCT_ITEM),
                Click.on(HomePage.ADD_TO_CART_BUTTON)
        );


        Alert alert = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
        if (alert.getText().equals("Product added.")) {
            alert.accept();
        }
    }

    public static Performable addProductToCart() {
        return new AddProductToCart();
    }
}

