package ru.crystals.test.steps;

import cucumber.api.java.en.*;
import ru.crystals.test.Runner;
import ru.crystals.test.ui.ElementTypes;
import ru.crystals.test.ui.elements.Element;
import ru.crystals.test.ui.elements.Field;
import ru.crystals.test.ui.elements.List;
import ru.crystals.test.utils.Helpers;

public class Common {
    @When("I click \"(.+)\" ([\\w|]+)")
    public void clickElement(String elementName, String elementType) {
        Runner.currentPage.getElement(String.format("%s %s", elementName, elementType)).click();
    }

    @Given("^I open \"([^\"]*)\" url")
    public void openUrl(String url) {
        Runner.driver.get(url);
    }

    @When("I type \"(.+)\" in \"(.+)\" field")
    public void typeText(String text, String name) throws IllegalAccessException {
        Helpers.checkName(name);
        try {
            Field element = (Field) Runner.currentPage.getElement(Helpers.getFullElementName(name, ElementTypes.FIELD));
            element.clear();
            element.fill(text);
        } catch (ClassCastException ex) {
            throw new ClassCastException(String.format(
                    "There is no field with the name %s on the %s page", name, Runner.currentPage.getName()));
        }
    }

    @And("\"(.+)\" (.+) should be shown")
    public void assertIsShown(String name, String elementType) throws IllegalAccessException, InterruptedException {
        Helpers.checkElementParams(name, elementType);
        String fullName = Helpers.getFullElementName(name, elementType);
        if (Runner.pages.containsKey(fullName)) {
            Runner.pages.get(fullName).waitUntilVisible();
            Helpers.checkName(name);
            Runner.currentPage = Runner.pages.get(fullName);
            if (Runner.currentPage == null) {
                throw new NullPointerException(String.format("%s does not exist", fullName));
            }
        } else {
            Runner.currentPage.getElement(fullName).waitUntilVisible();
        }
    }

    @When("I click on \"(.+)\" item in \"(.+)\" ([\\w|]+)")
    public void clickItemInElement(String itemName, String elementName, String elementType)
            throws IllegalAccessException {
        Helpers.checkElementParams(elementName, elementType);
        String elementFullName = Helpers.getFullElementName(elementName, elementType);
        List targetList = (List) Runner.currentPage.getElement(elementFullName);
        targetList.clickItem(itemName);
    }

    @Then("\"(.+)\" ([\\w|]+) should have text \"(.+)\"")
    public void checkElementText(String elementName, String elementType, String expectedText) throws IllegalAccessException {
        Helpers.checkElementParams(elementName, elementType);
        String fullElementName = Helpers.getFullElementName(elementName, elementType);
        Element targetElement = Runner.currentPage.getElement(fullElementName);

        if (!targetElement.getText().equals(expectedText)) {
            throw new AssertionError(
                    String.format("%s doesn't have text '%s'", fullElementName, expectedText));
        }
    }
}
