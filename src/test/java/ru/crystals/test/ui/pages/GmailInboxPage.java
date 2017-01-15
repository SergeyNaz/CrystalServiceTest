package ru.crystals.test.ui.pages;

import ru.crystals.test.ui.elements.Button;
import ru.crystals.test.ui.elements.Element;
import org.openqa.selenium.By;
import ru.crystals.test.ui.Names;

import java.security.KeyException;
import java.util.ArrayList;

public class GmailInboxPage extends Page {

    public GmailInboxPage(String name, String urlRegexp) throws KeyException {
        super(name, urlRegexp);
        super.registerElements(new ArrayList<Element>() {{
            add(new Button(Names.GOOGLE_ACCOUNT, By.xpath(
                    "//div[@id='gb']//a[contains(@title,'Google Account')]")));
            add(new Button(Names.SIGN_OUT, By.id("gb_71")));
        }});
    }
}
