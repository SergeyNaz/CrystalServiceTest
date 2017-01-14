package ru.crystals.test.utils;

import ru.crystals.test.ui.ElementTypes;
import ru.crystals.test.ui.Names;
import org.openqa.selenium.NotFoundException;

import java.lang.reflect.Field;

/**
 * Created by sergey on 1/12/17.
 */
public class Helpers {
    public static void checkElementParams(String targetName, String targetElementType) throws IllegalAccessException {
        checkNames(targetName);
        checkElementTypes(targetElementType);
    }

    public static void checkNames(String targetName) throws IllegalAccessException {
        for (Field field : Names.class.getFields()) {
            if (field.get(null).equals(targetName)) {
                return;
            }
        }
        throw new NotFoundException(
                String.format("There are no '%s' name at the Names class", targetName));
    }

    public static void checkElementTypes(String targetElementType) throws IllegalAccessException {
        for (Field field : ElementTypes.class.getFields()) {
            if (field.get(null).equals(targetElementType)) {
                return;
            }
        }
        throw new NotFoundException(
                String.format("There are no '%s' element type at the ElementTypes class", targetElementType));
    }
}
