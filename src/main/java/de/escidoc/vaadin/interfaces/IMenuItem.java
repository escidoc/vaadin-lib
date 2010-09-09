/**
 * 
 */
package de.escidoc.vaadin.interfaces;

import java.util.Date;

import com.vaadin.event.Action;

import de.escidoc.core.resources.om.container.Container;
import de.escidoc.core.resources.om.item.Item;

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
     * @param objId
     *            The unique ObjectId.
     */
    public void setObjectId(String objId);

    /**
     * @return The name of the item.
     */
    public String getName();

    /**
     * @return Who created the item.
     */
    public String getCreatedBy();

    /**
     * @param createdBy
     *            Sets who created the item.
     */
    public void setCreatedBy(String createdBy);

    /**
     * 
     * @return When was the item created.
     */
    public Date getCreatedOn();

    /**
     * 
     * @param createdOn
     *            Sets when the item was created.
     */
    public void setCreatedOn(Date createdOn);

    /**
     * 
     * @return Who modified the item the last time.
     */
    public String getModifiedBy();

    /**
     * 
     * @param modifiedBy
     *            Sets who modified the item the last time.
     */
    public void setModifiedBy(String modifiedBy);

    /**
     * 
     * @return When was the item the last time modified.
     */
    public Date getModifiedOn();

    /**
     * 
     * @param modifiedOn
     *            Sets when the item was modified the last time.
     */
    public void setModifiedOn(Date modifiedOn);

    /**
     * @return an array of action that should be possible in the context menu.
     */
    public Action[] getActions();

    /** Displays the content of this bean. */
    public void debug();

    /**
     * Converts the content of the bean to an <code>item</code>.
     * 
     * @return the result of the conversion.
     */
    public Item toItem();

    /**
     * Converts the content of the bean to a <code>container</code>.
     * 
     * @return the result of the conversion.
     */
    public Container toContainer();
}
