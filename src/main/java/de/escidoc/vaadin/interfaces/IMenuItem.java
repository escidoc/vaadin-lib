/**
 * 
 */
package de.escidoc.vaadin.interfaces;

import java.util.Date;

/**
 * @author ASP
 * 
 */
public interface IMenuItem {
    /**
     * @return The unique ObjectId.
     */
    String getObjectId();

    /**
     * @param objId
     *            The unique ObjectId.
     */
    void setObjectId(String objId);

    /**
     * @return The name of the item.
     */
    String getName();

    /**
     * @return Who created the item.
     */
    String getCreatedBy();

    /**
     * @param createdBy
     *            Sets who created the item.
     */
    void setCreatedBy(String createdBy);

    /**
     * 
     * @return When was the item created.
     */
    Date getCreatedOn();

    /**
     * 
     * @param createdOn
     *            Sets when the item was created.
     */
    void setCreatedOn(Date createdOn);

    /**
     * 
     * @return Who modified the item the last time.
     */
    String getModifiedBy();

    /**
     * 
     * @param modifiedBy
     *            Sets who modified the item the last time.
     */
    void setModifiedBy(String modifiedBy);

    /**
     * 
     * @return When was the item the last time modified.
     */
    Date getModifiedOn();

    /**
     * 
     * @param modifiedOn
     *            Sets when the item was modified the last time.
     */
    void setModifiedOn(Date modifiedOn);

    /**
     * 
     * @return an id for the used content model.
     */
    String getContentModel();

    /**
     * 
     * @param id
     *            an id for the used content model.
     */
    void setContentModel(String id);

    /**
     * 
     * @return an id for the used context.
     */
    String getContext();

    /**
     * 
     * @param id
     *            an id for the used context.
     */
    void setContext(String id);

    /**
     * A unique identifier for determining the EscidocReference id.
     * 
     * @return a String matching a key in the constants definition.
     */
    String getReferenceType();

}
