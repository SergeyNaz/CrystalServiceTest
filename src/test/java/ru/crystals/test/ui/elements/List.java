package ru.crystals.test.ui.elements;

import ru.crystals.test.Runner;
import ru.crystals.test.ui.ElementTypes;
import ru.crystals.test.utils.ListItemLocatorTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class List extends Element {
    private ListItemLocatorTemplate itemLocatorTemplate;

    public List(String name, By locator, ListItemLocatorTemplate itemLocatorTemplate) {
        super(name, locator, ElementTypes.LIST);
        this.itemLocatorTemplate = itemLocatorTemplate;
    }

    private By getItemLocator(String name) {
        return By.xpath(itemLocatorTemplate.getFirstPart() + name + itemLocatorTemplate.getSecondPart());
    }

    private WebElement getItemWebElement(String name) {
        By locator = getItemLocator(name);
        try {
            return Runner.driver.findElement(locator);
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException(
                    String.format("List element '%s' could not be found on the page. List locator: (%s)",
                            locator, this.getLocator().toString()));
        }
    }

    public void clickItem(String itemName) {
        getItemWebElement(itemName).click();
    }
}
