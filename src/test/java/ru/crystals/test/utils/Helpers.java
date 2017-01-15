package ru.crystals.test.utils;

import ru.crystals.test.ui.ElementTypes;
import ru.crystals.test.ui.Names;
import org.openqa.selenium.NotFoundException;

import java.lang.reflect.Field;

public class Helpers {
    public static void checkElementParams(String targetName, String targetElementType) throws IllegalAccessException {
        checkName(targetName);
        checkElementType(targetElementType);
    }

    public static void checkName(String targetName) throws IllegalAccessException {
        for (Field field : Names.class.getFields()) {
            if (field.get(null).equals(targetName)) {
                return;
            }
        }
        throw new NotFoundException(
                String.format("There are no '%s' name at the Names class", targetName));
    }

    public static void checkElementType(String targetElementType) throws IllegalAccessException {
        for (Field field : ElementTypes.class.getFields()) {
            if (field.get(null).equals(targetElementType)) {
                return;
            }
        }
        throw new NotFoundException(
                String.format("There are no '%s' element type at the ElementTypes class", targetElementType));
    }

    public static String getFullElementName(String name, String elementType) {
        return String.format("%s %s", name, elementType);
    }
}
