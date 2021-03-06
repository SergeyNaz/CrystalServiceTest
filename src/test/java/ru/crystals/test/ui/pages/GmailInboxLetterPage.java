package ru.crystals.test.ui.pages;

import ru.crystals.test.ui.elements.Element;
import ru.crystals.test.ui.elements.EmailLabel;
import ru.crystals.test.ui.elements.Label;
import org.openqa.selenium.By;
import ru.crystals.test.ui.Names;

import java.security.KeyException;
import java.util.ArrayList;

public class GmailInboxLetterPage extends GmailInboxPage {

    public GmailInboxLetterPage() throws KeyException {
        super(Names.GMAIL_INBOX_MAIL, "https://mail.google.com/(.+)/#inbox/(.+)");
        super.registerElements(new ArrayList<Element>() {{
            add(new EmailLabel(Names.EMAIL_SENDER, By.xpath("//span[@class='go']")));
            add(new Label(Names.EMAIL_SUBJECT, By.xpath("//h2[@class='hP']")));
            add(new Label(Names.EMAIL_CONTENT, By.xpath("//div[@class='a3s aXjCH m15993edfcc3d5e75']")));
        }});
    }
}
