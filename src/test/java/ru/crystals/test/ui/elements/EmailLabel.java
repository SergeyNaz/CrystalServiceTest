package ru.crystals.test.ui.elements;

import ru.crystals.test.ui.ElementTypes;
import org.openqa.selenium.By;

/**
 * Created by sergey on 1/14/17.
 */
public class EmailLabel extends Element {
    public EmailLabel(String name, By locator) {
        super(name, locator, ElementTypes.LABEL);
    }

    @Override
    public String getText() {
        String sourceEmail = getWebElement().getText();
        return sourceEmail.substring(1, sourceEmail.length() - 1);
    }
}
