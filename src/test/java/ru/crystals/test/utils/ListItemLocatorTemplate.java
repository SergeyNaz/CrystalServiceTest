package ru.crystals.test.utils;

/**
 * Created by sergey on 1/14/17.
 */
public class ListItemLocatorTemplate {
    private String firstPart;
    private String secondPart;

    public ListItemLocatorTemplate(String firstPart, String secondPart){
        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }

    public String getFirstPart() {
        return firstPart;
    }

    public String getSecondPart() {
        return secondPart;
    }
}
