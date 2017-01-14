package ru.crystals.test.ui.elements;

import ru.crystals.test.ui.ElementTypes;
import org.openqa.selenium.By;

/**
 * Created by sergey on 1/12/17.
 */
public class Field extends Element {
    public Field(String name, By locator) {
        super(name, locator, ElementTypes.FIELD);
    }

    public void clear() {
        getWebElement().clear();
    }

    public void fill(String textToType) {
        getWebElement().sendKeys(textToType);
    }

}
