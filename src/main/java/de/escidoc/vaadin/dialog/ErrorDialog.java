package de.escidoc.vaadin.dialog;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import de.escidoc.vaadin.utilities.LayoutHelper;

/**
 * 
 * @author ASP
 * 
 */
public class ErrorDialog extends Window implements Button.ClickListener {
    private static final long serialVersionUID = 6255824594582824620L;

    private final FormLayout layout = new FormLayout();

    private final Window mainWindow;

    /**
     * Displays an error message dialog to the customer.
     * 
     * @param mainWindow
     *            the main window of the application.
     * @param caption
     *            the headline.
     * @param errorMessage
     *            the message, describing what went wrong.
     */
    public ErrorDialog(final Window mainWindow, final String caption,
        final String errorMessage) {

        this(mainWindow, caption, errorMessage, 600, 300);
    }

    /**
     * Displays an error message dialog to the customer.
     * 
     * @param mainWindow
     *            the main window of the application.
     * @param caption
     *            the headline.
     * @param errorMessage
     *            the message, describing what went wrong.
     * @param width
     *            the width of the window.
     * @param height
     *            the height of the window.
     */
    public ErrorDialog(final Window mainWindow, final String caption,
        final String errorMessage, int width, int height) {

        this.mainWindow = mainWindow;
        super.setWidth(width + "px");
        super.setHeight(height + "px");
        super.setCaption(caption);
        super.setModal(true);
        layout.addComponent(LayoutHelper.create("", new Label(errorMessage),
            10, false));
        Button button = new Button("OK");
        layout.addComponent(LayoutHelper.create("", button, 10, false));
        button.addListener(this);
        super.addComponent(layout);
    }

    /**
     * Displays an error message dialog to the customer.
     * 
     * @param mainWindow
     *            the main window of the application.
     * @param caption
     *            the headline.
     * @param exception
     *            the exception caught.
     */
    public ErrorDialog(final Window mainWindow, final String caption,
        final Exception exception) {

        this(mainWindow, caption, exception, 600, 300);
    }

    /**
     * Displays an error message dialog to the customer.
     * 
     * @param mainWindow
     *            the main window of the application.
     * @param caption
     *            the headline.
     * @param exception
     *            the exception caught.
     * @param width
     *            the width of the window.
     * @param height
     *            the height of the window.
     */
    public ErrorDialog(final Window mainWindow, final String caption,
        final Exception exception, int width, int height) {

        this.mainWindow = mainWindow;
        super.setWidth(width + "px");
        super.setHeight(height + "px");
        super.setCaption(caption);

        super.setModal(true);
        layout.addComponent(LayoutHelper.create("",
            new Label(exception.getMessage()), 10, false));
        Button button = new Button("OK");
        layout.addComponent(LayoutHelper.create("", button, 10, false));

        StackTraceElement[] elements = exception.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : elements) {
            sb.append(element.toString() + "\n");
        }

        TextField trace = new TextField();
        trace.setRows(7);
        trace.setColumns(80);
        trace.setValue(sb.toString());
        layout.addComponent(trace);
        button.addListener(this);
        super.addComponent(layout);
    }

    @Override
    public void buttonClick(ClickEvent event) {

        mainWindow.removeWindow(ErrorDialog.this);
    }
}
