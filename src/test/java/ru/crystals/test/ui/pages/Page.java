package ru.crystals.test.ui.pages;

import ru.crystals.test.Runner;
import ru.crystals.test.ui.ElementTypes;
import ru.crystals.test.ui.elements.Element;
import org.openqa.selenium.NoSuchElementException;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 1/12/17.
 */
public class Page {
    private String urlRegexp;
    private String name;
    private String eType;
    private Map<String, Element> elements;

    public Page(String name, String urlRegexp) {
        this.urlRegexp = urlRegexp;
        this.name = name;
        eType = ElementTypes.PAGE;
        elements = new HashMap<String, Element>();
    }

    public String getName() {
        return name;
    }

    public String getUrlRegexp() {
        return urlRegexp;
    }

    public String getFullName() {
        return String.format("%s page", name);
    }

    public Map<String, Element> getElements() {
        return elements;
    }

    public Element getElement(String fullname) {
        Element element = elements.get(fullname);
        if (element == null) {
            throw new NoSuchElementException(String.format("Not found element with '%s' name", fullname));
        } else {
            return elements.get(fullname);
        }
    }

    public void registerElement(Element element) {
        String fullElementName = element.getFullName();
        if (elements.containsKey(fullElementName)) {
            throw new KeyAlreadyExistsException(
                    String.format("Element with %s name already added to %s page",
                            fullElementName, getFullName()));
        } else {
            element.setParent(this);
            elements.put(fullElementName, element);
        }
    }

    public void registerElements(List<Element> elements) {
        for (Element element : elements) {
            registerElement(element);
        }
    }

    public boolean isVisible() {
        String currentUrl = Runner.driver.getCurrentUrl();
        Pattern pattern = Pattern.compile(urlRegexp);
        Matcher matcher = pattern.matcher(currentUrl);
        return matcher.find();
    }


}
