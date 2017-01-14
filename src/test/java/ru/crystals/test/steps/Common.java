package ru.crystals.test.steps;

import cucumber.api.java.en.*;
import ru.crystals.test.Runner;
import ru.crystals.test.ui.elements.Element;
import ru.crystals.test.ui.elements.Field;
import ru.crystals.test.ui.elements.List;
import ru.crystals.test.utils.Helpers;
import org.apache.bcel.verifier.exc.AssertionViolatedException;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Created by sergey on 1/12/17.
 */
public class Common {
    @When("I click \"(.+)\" ([\\w|]+)?$")
    public void clickElement(String element_name, String elment_type) {
        Runner.currentPage.getElement(String.format("%s %s", element_name, elment_type)).click();
    }

    @Given("^I open \"([^\"]*)\" url$")
    public void openUrl(String url) {
        Runner.driver.get(url);
    }

    @When("I type \"(.+)\" in \"(.+)\" (.+)$")
    public void typeText(String text, String name, String element_type) throws IllegalAccessException {
        Helpers.checkElementParams(name, element_type);
        Field element = (Field) Runner.currentPage.getElement(String.format("%s %s", name, element_type));
        element.clear();
        element.fill(text);
    }

    @When("\"(.+)\" (.+) is shown")
    public void setCurrentPage(String name, String element_type) throws IllegalAccessException {
        Helpers.checkElementParams(name, element_type);
        Runner.currentPage = Runner.pages.get(String.format("%s %s", name, element_type));
    }


    @And("\"(.+)\" (.+) should be shown$")
    public void assertIsShown(String name, String elementType) throws IllegalAccessException {
        Helpers.checkElementParams(name, elementType);
        String elementFullName = String.format("%s %s", name, elementType);

        if (Runner.pages.containsKey(elementFullName)) {
            throw new NotImplementedException("Check of page visibility is not implemented yet");
        } else {
            Runner.currentPage.getElement(elementFullName).waitUntilVisible();
        }
    }

    @When("I click on \"(.+)?\" item in \"(.+)?\" ([\\w|]+)?$")
    public void clickItemInElement(String itemName, String elementName, String elementType)
            throws IllegalAccessException {
        Helpers.checkElementParams(elementName, elementType);
        String elementFullName = String.format("%s %s", elementName, elementType);
        List targetList = (List) Runner.currentPage.getElement(elementFullName);
        targetList.clickItem(itemName);
    }

    @Then("\"(.+)?\" ([\\w| ]+)? should have text \"(.+)?\"")
    public void checkElementText(String elementName, String elementType, String expectedText) throws IllegalAccessException {
        Helpers.checkElementParams(elementName, elementType);
        String fullElementName = String.format("%s %s", elementName, elementType);
        Element targetElement = Runner.currentPage.getElement(fullElementName);

        if (!targetElement.getText().equals(expectedText)) {
            throw new AssertionViolatedException(
                    String.format("%s doesn't have text '%s'", fullElementName, expectedText));
        }
    }
}
