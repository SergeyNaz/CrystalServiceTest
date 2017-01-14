package ru.crystals.test.ui.pages;

import ru.crystals.test.ui.elements.Element;
import ru.crystals.test.ui.elements.EmailLabel;
import ru.crystals.test.ui.elements.Label;
import org.openqa.selenium.By;
import ru.crystals.test.ui.Names;

import java.security.KeyException;
import java.util.ArrayList;

/**
 * Created by sergey on 1/12/17.
 */
public class GmailInboxMailPage extends GmailInboxPage {

    public GmailInboxMailPage() throws KeyException {
        super(Names.GMAIL_INBOX_MAIL, "https://mail.google.com/(.+)?");
        super.registerElements(new ArrayList<Element>(){{
            add(new EmailLabel(Names.EMAIL_SENDER, By.xpath("//div[@id=':6m']//span[@class='go']")));
            add(new Label(Names.EMAIL_SUBJECT, By.id(":5x")));
            add(new Label(Names.EMAIL_CONTENT, By.id(":6n")));
        }});
    }
}
