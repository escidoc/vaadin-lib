/**
 * 
 */
package de.escidoc.vaadin.interfaces;

import com.vaadin.event.Action;

/**
 * @author ASP
 * 
 */
public interface IMenuItemWithMenuActions extends IMenuItem {
    /**
     * @return an array of action that should be possible in the context menu.
     */
    Action[] getActions();

}
