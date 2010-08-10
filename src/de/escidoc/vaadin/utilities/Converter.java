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
    public static synchronized String dateTimeToString(DateTime dateTime){
		Date date = dateTime.toDate();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(date);
    }

}
