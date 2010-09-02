/**
 * 
 */
package de.escidoc.vaadin.interfaces;

import java.util.Date;

import com.vaadin.event.Action;

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

    public void setObjectId(String objId);

    /**
     * @return The name of the instrumemnt.
     */
    public String getName();

    public String getCreatedBy();

    public void setCreatedBy(String createdBy);

    public Date getCreatedOn();

    public void setCreatedOn(Date createdOn);

    public String getModifiedBy();

    public void setModifiedBy(String modifiedBy);

    public Date getModifiedOn();

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

}
