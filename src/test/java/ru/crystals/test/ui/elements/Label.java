package ru.crystals.test.ui.elements;

import ru.crystals.test.ui.ElementTypes;
import org.openqa.selenium.By;

public class Label extends Element {
    public Label(String name, By locator) {
        super(name, locator, ElementTypes.LABEL);
    }
}
