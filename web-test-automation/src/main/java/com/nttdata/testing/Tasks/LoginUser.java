package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginUser implements Task {

    private final String username;
    private final String password;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(HomePage.BTN_LOGIN),

                Enter.theValue(username).into(HomePage.LOGIN_USERNAME),

                Enter.theValue(password).into(HomePage.LOGIN_PASSWORD),

                Click.on(HomePage.BTN_CONFIRM_LOGIN)
        );
    }

    public static Performable withCredentials(String username, String password) {
        return new LoginUser(username, password);
    }
}
