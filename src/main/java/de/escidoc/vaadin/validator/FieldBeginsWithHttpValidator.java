/**
 * 
 */
package de.escidoc.vaadin.validator;

import com.vaadin.terminal.UserError;
import com.vaadin.ui.TextField;

/**
 * @author ASP
 * 
 */
public class FieldBeginsWithHttpValidator {

    private FieldBeginsWithHttpValidator() {

        // Utility classes should not have a public or default constructor.
    }

    /**
     * A simple validator to test, if the field is filled.
     * 
     * @param textField
     *            The text field to test.
     * @param message
     *            The message that should be shown (as a tool tip) if the result
     *            is bad.
     * @return true if the field is filled, otherwise false.
     */
    public static synchronized boolean isValid(
        final TextField textField, final String message) {

        Object obj = textField.getValue();
        if (obj != null) {
            String value = (String) obj;
            value = value.toLowerCase();
            if (!value.startsWith("http://")) {
                textField.setComponentError(null);
                textField.setComponentError(new UserError(message));
                return false;
            }
            textField.setComponentError(null);
            return true;
        }
        return false; // String is empty!!!
    }
}
