/**
 * 
 */
package de.escidoc.vaadin.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import de.escidoc.vaadin.Constants;

/**
 * @author ASP
 * 
 */
public final class Converter {

    private Converter() {
        // Utility classes should not have a public or default constructor.
    }

    /**
     * Converts DateTime to String.
     * 
     * @param dateTime
     *            the information to convert.
     * @return the result.
     */
    public static synchronized String dateTimeToString(DateTime dateTime) {
        Date date = dateTime.toDate();
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
        return sdf.format(date);
    }

    /**
     * Vaadin uses an Object to return either a single value
     * 
     * @param o
     *            the return object from a tree, combobox, list, ....
     * @return a list of selected objects.
     */
    public static synchronized List<Object> getSelected(Object o) {
        final List<Object> selected = new ArrayList<Object>();
        if (o instanceof Set) {
            selected.addAll((Set<?>) o); // More than one result...
        }
        else { // Just one selected.
            selected.add(o);
        }
        return selected;
    }

}
