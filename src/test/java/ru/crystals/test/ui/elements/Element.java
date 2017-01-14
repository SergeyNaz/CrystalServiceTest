package ru.crystals.test.ui.elements;

import ru.crystals.test.Runner;
import ru.crystals.test.Settings;
import ru.crystals.test.ui.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sergey on 1/12/17.
 */
public class Element {
    private String name;
    private String eType;
    private By locator;
    private Page parent;

    public Element(String name, By locator, String eType) {
        this.name = name;
        this.eType = eType;
        this.locator = locator;
        this.parent = null;
    }

    public String getName() {
        return name;
    }

    public By getLocator() {
        return locator;
    }

    public String geteType() {
        return eType;
    }

    public Page getParent() {
        return parent;
    }

    public void setParent(Page parent) {
        this.parent = parent;
    }

    public String getText() {
        return getWebElement().getText().trim();
    }

    public String getFullName() {
        return String.format("%s %s", name, eType);
    }

    public WebElement getWebElement() throws NoSuchElementException {
        try {
            return Runner.driver.findElement(locator);
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException(
                    String.format("No found element with %s locator", locator));
        }
    }

    public void click() {
        getWebElement().click();
    }

    public void waitUntilVisible() {
        WebDriverWait wait = new WebDriverWait(Runner.driver, Settings.MAX_ELEMENT_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
