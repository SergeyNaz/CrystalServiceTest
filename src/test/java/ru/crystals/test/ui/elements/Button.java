package ru.crystals.test.ui.elements;

import ru.crystals.test.ui.ElementTypes;
import org.openqa.selenium.By;

public class Button extends Element {
    public Button(String name, By locator) {
        super(name, locator, ElementTypes.BUTTON);
    }
}
