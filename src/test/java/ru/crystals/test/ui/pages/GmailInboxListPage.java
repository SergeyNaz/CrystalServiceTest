package ru.crystals.test.ui.pages;

import ru.crystals.test.ui.elements.Element;
import ru.crystals.test.ui.elements.List;
import ru.crystals.test.utils.ListItemLocatorTemplate;
import org.openqa.selenium.By;
import ru.crystals.test.ui.Names;

import java.security.KeyException;
import java.util.ArrayList;

/**
 * Created by sergey on 1/13/17.
 */
public class GmailInboxListPage extends GmailInboxPage {

    public GmailInboxListPage() throws KeyException {
        super(Names.GMAIL_INBOX_LIST, "https://mail.google.com/(.+)?");
        super.registerElements(new ArrayList<Element>(){{
            add(new List(Names.SUBJECTS_EMAILS, By.id(":31"),
                    new ListItemLocatorTemplate("//div[@class='y6']/span[1][.='", "']")));
        }});
    }
}
