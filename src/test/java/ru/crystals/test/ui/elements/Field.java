package ru.crystals.test.ui.elements;

import ru.crystals.test.ui.ElementTypes;
import org.openqa.selenium.By;

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
