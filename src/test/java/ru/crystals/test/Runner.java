package ru.crystals.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.crystals.test.ui.pages.GmailInboxListPage;
import ru.crystals.test.ui.pages.GmailInboxMailPage;
import ru.crystals.test.ui.pages.GmailLoginPage;
import ru.crystals.test.ui.pages.Page;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;


@CucumberOptions(features = "src/test/resources/features/",
        monochrome = true,
        tags = {},
        format = {"pretty", "html: cucumber-html-reports",
                "json:cucumber-html-reports/cucumber.json"},
        glue = "ru.crystals.test.steps")
@RunWith(Cucumber.class)
public class Runner {
    public static WebDriver driver;
    public static HashMap<String, Page> pages;
    public static Page currentPage;

    @BeforeClass
    public static void setUp() throws KeyException {
        System.setProperty("webdriver.gecko.driver", Settings.GECKODRIVER_PATH);
        driver = new FirefoxDriver();
        setUpPages();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static void setUpPages() throws KeyException {
        pages = new HashMap<String, Page>();
        for (Page page: new ArrayList<Page>(){{
            add(new GmailLoginPage());
            add(new GmailInboxListPage());
            add(new GmailInboxMailPage());
        }}){
            pages.put(page.getFullName(), page);
        }
    }
}
