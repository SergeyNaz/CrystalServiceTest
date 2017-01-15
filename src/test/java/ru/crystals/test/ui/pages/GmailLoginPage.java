package ru.crystals.test.ui.pages;

import org.openqa.selenium.By;
import ru.crystals.test.ui.Names;
import ru.crystals.test.ui.elements.Button;
import ru.crystals.test.ui.elements.Element;
import ru.crystals.test.ui.elements.Field;

import java.security.KeyException;
import java.util.ArrayList;

public class GmailLoginPage extends Page {
    public GmailLoginPage() throws KeyException {
        super(Names.GMAIL_LOGIN, "https://accounts.google.com/(.+)");
        super.registerElements(new ArrayList<Element>() {{
            add(new Field(Names.EMAIL_ADDRESS, By.id("Email")));
            add(new Button(Names.NEXT, By.id("next")));
            add(new Field(Names.PASSWORD, By.id("Passwd")));
            add(new Button(Names.SIGN_IN, By.id("signIn")));
        }});
    }
}
