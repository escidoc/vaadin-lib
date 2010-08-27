/**
 * 
 */
package de.escidoc.vaadin.interfaces;

import com.vaadin.event.Action;

/**
 * @author ASP
 * 
 */
public interface IMenuItem {
    /**
     * @return The unique ObjectId.
     */
    public String getObjectId();

    /**
     * @return The name of the instrumemnt.
     */
    public String getName();

    /**
     * @return an array of action that should be possible in the context menu.
     */
    public Action[] getActions();

    public void debug();
}
