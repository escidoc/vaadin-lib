/**
 * 
 */
package de.escidoc.vaadin.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

/**
 * @author ASP
 * 
 */
public class Converter {
    /**
     * Converts DateTime to String.
     * 
     * @param dateTime
     *            the information to convert.
     * @return the result.
     */
    public static synchronized String dateTimeToString(DateTime dateTime) {
        Date date = dateTime.toDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(date);
    }

}
