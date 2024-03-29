package de.escidoc.vaadin.dialog;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.data.util.POJOItem;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

import de.escidoc.vaadin.Constants;
import de.escidoc.vaadin.utilities.LayoutHelper;

/**
 * 
 * @author ASP
 * 
 */
public class HistoryDialog extends Window implements Button.ClickListener {
    private static final long serialVersionUID = 4138381496395357610L;

    private final FormLayout layout = new FormLayout();

    private final Window mainWindow;

    /**
     * Displays an history dialog to the customer.
     * 
     * @param mainWindow
     *            the main window of the application.
     * @param caption
     *            the headline.
     * @param pojo
     *            the data binding.
     * @param className
     *            the name of the class.
     */
    public HistoryDialog(final Window mainWindow, final String caption,
        final POJOItem<?> pojo, final String className) {
        this(mainWindow, caption, Constants.ERROR_DIALOG_WIDTH,
            Constants.ERROR_DIALOG_HEIGTH, pojo, className);
    }

    /**
     * Displays an history dialog to the customer.
     * 
     * @param mainWindow
     *            the main window of the application.
     * @param caption
     *            the headline.
     * @param width
     *            the width of the window.
     * @param height
     *            the height of the window.
     * @param pojo
     *            the data binding.
     * @param className
     *            the name of the class.
     */
    public HistoryDialog(final Window mainWindow, final String caption,
        int width, int height, final POJOItem<?> pojo, final String className) {
        this.mainWindow = mainWindow;
        super.setWidth(width + Constants.PX);
        super.setHeight(height + Constants.PX);
        super.setCaption(caption);
        super.setModal(true);
        // created
        final SimpleDateFormat sdf =
            new SimpleDateFormat(Constants.DATE_FORMAT);
        final AbstractComponent createdByField =
            LayoutHelper.createElement(className, pojo, true,
                Constants.CREATED_BY);

        Object creationDate =
            pojo.getItemProperty(Constants.CREATED_ON).getValue();

        if (creationDate == null) {
            creationDate = new Date();
        }

        layout.addComponent(LayoutHelper.create("Created:", " by ", new Label(
            sdf.format(creationDate)), createdByField, 100,
            Constants.TEXT_WIDTH, false));

        // modified
        final AbstractComponent modifiedByField =
            LayoutHelper.createElement(className, pojo, true,
                Constants.MODIFIED_BY);
        Object modificationDate =
            pojo.getItemProperty(Constants.MODIFIED_ON).getValue();
        if (modificationDate == null) {
            modificationDate = new Date();
        }
        layout.addComponent(LayoutHelper.create("Modified:", " by ", new Label(
            sdf.format(modificationDate)), modifiedByField, 100,
            Constants.TEXT_WIDTH, false));
        Button button = new Button(Constants.OK, this);
        layout.addComponent(LayoutHelper.create("", button, 10, false));
        super.addComponent(layout);
    }

    @Override
    public final void buttonClick(ClickEvent event) {
        
        mainWindow.removeWindow(HistoryDialog.this);
    }

}
