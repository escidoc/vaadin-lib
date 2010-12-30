/**
 * 
 */
package de.escidoc.vaadin.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.data.util.POJOItem;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

import de.escidoc.vaadin.Constants;
import de.escidoc.vaadin.interfaces.IMenuItem;

/**
 * @author ASP
 * 
 */
public class LayoutHelper {

    private LayoutHelper() {
        // Utility classes should not have a public or default constructor.
    }

    private final static Map<String, List<Field>> attachedFieldsMap =
        new HashMap<String, List<Field>>();

    /**
     * Helper method. Puts a blank in front of a component.
     * 
     * @param label
     *            The label in front of the control.
     * @param comp
     *            The component to display.
     * @param width
     *            the fixed size of the label. The parameter has to be in CSS
     *            style, i.e. 400px for instance.
     * @param required
     *            should it be marked with an asterisk.
     * @return The component in an horizontal layout. A blank in front and
     *         afterwards is inserted.
     */
    public static synchronized HorizontalLayout create(

    String label, Component comp, int width, boolean required) {
        HorizontalLayout hor = new HorizontalLayout();
        hor.setHeight(Constants.DEFAULT_HEIGHT);
        hor.addComponent(new Label(" "));
        String text = Constants.P_ALIGN_RIGHT + label + Constants.P;
        Label l;
        hor.addComponent(l = new Label(text, Label.CONTENT_XHTML));
        l.setSizeUndefined();
        l.setWidth(width + Constants.PX);
        hor.setComponentAlignment(l, com.vaadin.ui.Alignment.MIDDLE_RIGHT);

        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:13px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(comp);
        hor.setComponentAlignment(comp, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" "));
        hor.setSpacing(false);
        return hor;
    }

    /**
     * Helper method. Puts a blank in front of a component.
     * 
     * @param label
     *            The label in front of the control.
     * @param comp
     *            The component to display.
     * @param width
     *            the fixed size of the label. The parameter has to be in CSS
     *            style, i.e. 400px for instance.
     * @param required
     *            should it be marked with an asterisk.
     * @return The component in an horizontal layout. A blank in front and
     *         afterwards is inserted.
     */
    public static synchronized HorizontalLayout create(

    String label, CheckBox comp, int width, boolean required) {
        HorizontalLayout hor = new HorizontalLayout();
        hor.setHeight(Constants.DEFAULT_HEIGHT);
        hor.addComponent(new Label(" "));
        String text = Constants.P_ALIGN_RIGHT + label + Constants.P;
        Label l;
        hor.addComponent(l = new Label(text, Label.CONTENT_XHTML));
        l.setSizeUndefined();
        l.setWidth(width + Constants.PX);
        hor.setComponentAlignment(l, Alignment.MIDDLE_RIGHT);

        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:13px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(comp);
        hor.setComponentAlignment(comp, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" "));
        hor.setSpacing(false);
        return hor;
    }

    /**
     * Helper method. Puts a blank in front of a component.
     * 
     * @param label
     *            The label in front of the control.
     * @param comp
     *            The component to display.
     * @param width
     *            the fixed size of the label. The parameter has to be in CSS
     *            style, i.e. 400px for instance.
     * @param height
     *            the height of the layout
     * @param required
     *            should it be marked with an asterisk.
     * @return The component in an horizontal layout. A blank in front and
     *         afterwards is inserted.
     */
    public static synchronized HorizontalLayout create(

    String label, Component comp, int width, int height, boolean required) {
        HorizontalLayout hor = new HorizontalLayout();
        // hor.setHeight("30px");
        hor.setHeight(height + Constants.PX);
        hor.addComponent(new Label(" "));
        String text = Constants.P_ALIGN_RIGHT + label + Constants.P;
        Label l;
        hor.addComponent(l = new Label(text, Label.CONTENT_XHTML));
        l.setSizeUndefined();
        l.setWidth(width + Constants.PX);
        hor.setComponentAlignment(l, Alignment.MIDDLE_RIGHT);

        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:"
                        + (height / 2 - 13) + "px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(comp);
        hor.setComponentAlignment(comp, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" "));
        hor.setSpacing(false);
        return hor;
    }

    /**
     * Helper method. Puts a blank in front of a component.
     * 
     * @param label
     *            The label in front of the control.
     * @param comp
     *            The component to display.
     * @param width
     *            the fixed size of the label. The parameter has to be in CSS
     *            style, i.e. 400px for instance.
     * @param height
     * @param required
     *            should it be marked with an asterisk.
     * @param buttons
     *            the buttons to display.
     * @return The component in an horizontal layout. A blank in front and
     *         afterwards is inserted.
     */
    public static synchronized VerticalLayout create(
        String label, Component comp, int width, int height, boolean required,
        Button[] buttons) {

        HorizontalLayout hor = new HorizontalLayout();
        hor.setHeight(height + Constants.PX);
        hor.addComponent(new Label(" "));
        String text = Constants.P_ALIGN_RIGHT + label + Constants.P;
        Label l;
        hor.addComponent(l = new Label(text, Label.CONTENT_XHTML));
        l.setSizeUndefined();
        l.setWidth(width + Constants.PX);
        hor.setComponentAlignment(l, Alignment.MIDDLE_RIGHT);

        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:"
                        + (height / 2 - 13) + "px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(comp);
        hor.setComponentAlignment(comp, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" &nbsp; ", Label.CONTENT_XHTML));

        VerticalLayout vl = new VerticalLayout();
        vl.addComponent(hor);
        // VerticalLayout vl = new VerticalLayout();
        // int count = buttons.length;
        // TODO: Place the buttons centered ....
        // int numberOfElements = height / 22;
        // int indent = (numberOfElements - count) / 2;
        // indent++;
        // for (int i = 0; i < indent; i++) {
        // vl.addComponent(new Label("&nbsp;", Label.CONTENT_XHTML));
        // // vl.addComponent(new Label(" ", Label.CONTENT_XHTML));
        // }
        // for (Button b : buttons) {
        // vl.addComponent(b);
        // }
        // hor.addComponent(vl);
        HorizontalLayout hl = new HorizontalLayout();
        Label la = new Label("&nbsp;", Label.CONTENT_XHTML);
        la.setSizeUndefined();
        la.setWidth(width + Constants.PX);
        hl.addComponent(la);
        for (Button b : buttons) {
            hl.addComponent(b);
        }
        vl.addComponent(hl);
        hor.setSpacing(false);
        return vl;
    }

    /**
     * Helper method. Puts a blank in front of a component.
     * 
     * @param label
     *            The label in front of the control.
     * @param accordion
     *            The accordion to display.
     * @param width
     *            the fixed size of the label. The parameter has to be in CSS
     *            style, i.e. 400px for instance.
     * @param height
     * @param required
     *            should it be marked with an asterisk.
     * @return The component in an horizontal layout. A blank in front and
     *         afterwards is inserted.
     */
    public static synchronized HorizontalLayout create(
        String label, Accordion accordion, int width, int height,
        boolean required) {

        HorizontalLayout hor = new HorizontalLayout();
        hor.setHeight(height + Constants.PX);
        hor.addComponent(new Label(" "));
        String text = Constants.P_ALIGN_RIGHT + label + Constants.P;
        Label l;
        hor.addComponent(l = new Label(text, Label.CONTENT_XHTML));
        l.setSizeUndefined();
        l.setWidth(width + Constants.PX);
        hor.setComponentAlignment(l, Alignment.MIDDLE_RIGHT);
        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:"
                        + (height / 2 - 13) + "px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }

        Panel pan = new Panel();
        pan.setSizeFull();
        // Have it take all space available in the layout.
        accordion.setSizeFull();
        // Some components to put in the Accordion.

        String xml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root>\n\t<X>\n\t\t<today>\n\t\t</today>\n\t\t<today/>\n\t\t<today/>\n\t</X>\n</root>";

        for (int i = 0; i < 30; i++) {
            accordion.addTab(new Label(xml, Label.CONTENT_PREFORMATTED), "Tab"
                + i, null);
        }

        pan.addComponent(accordion);
        // pan.setSizeUndefined();
        pan.setWidth(accordion.getWidth() + Constants.PX);
        // pan.setHeight("500px");
        pan.setStyleName(Reindeer.PANEL_LIGHT);
        hor.addComponent(pan);
        hor.setComponentAlignment(pan, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" "));
        hor.setSpacing(false);
        return hor;
    }

    /**
     * Helper method. Puts a blank in front of a component. Two labels with
     * different size in front of two components.
     * 
     * @param labelLeft
     *            the left (leading) label.
     * @param labelRight
     *            the right (leading) label.
     * @param compLeft
     *            the left component.
     * @param compRight
     *            the right component.
     * @param widthLeft
     *            the width of the left label.
     * @param widthRight
     *            the width of the right label.
     * @param required
     *            true if the component is required, otherwise false.
     * @return the customized component placed in a horizontal layout.
     */
    public static synchronized HorizontalLayout create(
        String labelLeft, String labelRight, Component compLeft,
        Component compRight, int widthLeft, int widthRight, boolean required) {

        HorizontalLayout hor = new HorizontalLayout();
        hor.setHeight(Constants.DEFAULT_HEIGHT);
        hor.addComponent(new Label(" "));
        String text = Constants.P_ALIGN_RIGHT + labelLeft + Constants.P;
        Label ll, lr;
        hor.addComponent(ll = new Label(text, Label.CONTENT_XHTML));
        ll.setSizeUndefined();
        ll.setWidth(widthLeft + Constants.PX);
        hor.setComponentAlignment(ll, Alignment.MIDDLE_RIGHT);
        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:13px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(compLeft);
        hor.setComponentAlignment(compLeft, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label("&nbsp;", Label.CONTENT_XHTML));
        String text2 = Constants.P_ALIGN_RIGHT + labelRight + Constants.P;
        hor.addComponent(lr = new Label(text2, Label.CONTENT_XHTML));
        lr.setSizeUndefined();
        lr.setWidth(widthRight + Constants.PX);
        hor.setComponentAlignment(lr, Alignment.MIDDLE_RIGHT);
        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:13px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(compRight);
        hor.setComponentAlignment(compRight, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" "));
        hor.setSpacing(false);
        return hor;
    }

    /**
     * 
     * @param labelLeft
     * @param labelRight
     * @param compLeft
     * @param compRight
     * @param widthLeft
     * @param widthRight
     * @param required
     * @return the constructed result.
     */
    public static synchronized HorizontalLayout create(
        String labelLeft, String labelRight, Label compLeft, Label compRight,
        int widthLeft, int widthRight, boolean required) {

        HorizontalLayout hor = new HorizontalLayout();
        hor.setHeight(Constants.DEFAULT_HEIGHT);
        hor.addComponent(new Label(" "));
        String text = Constants.P_ALIGN_RIGHT + labelLeft + Constants.P;
        Label ll, lr;
        hor.addComponent(ll = new Label(text, Label.CONTENT_XHTML));
        ll.setSizeUndefined();
        ll.setWidth(widthLeft + Constants.PX);
        hor.setComponentAlignment(ll, Alignment.MIDDLE_RIGHT);
        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:13px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(compLeft);
        hor.setComponentAlignment(compLeft, Alignment.BOTTOM_RIGHT);
        hor.addComponent(new Label("&nbsp;", Label.CONTENT_XHTML));
        String text2 = Constants.P_ALIGN_RIGHT + labelRight + Constants.P;
        hor.addComponent(lr = new Label(text2, Label.CONTENT_XHTML));
        lr.setSizeUndefined();
        lr.setWidth(widthRight + Constants.PX);
        hor.setComponentAlignment(lr, Alignment.BOTTOM_RIGHT);
        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:13px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(compRight);
        hor.setComponentAlignment(compRight, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" "));
        hor.setSpacing(false);
        return hor;
    }

    /**
     * Helper method for placing components.
     * 
     * @param labelLeft
     *            the left (leading) label.
     * @param labelRight
     *            the right (leading) label.
     * @param compLeft
     *            the left component.
     * @param compRight
     *            the right component.
     * @param width
     *            the width of the label.
     * @param required
     *            true if the component is required, otherwise false.
     * @return the customized component placed in a horizontal layout.
     */
    public static synchronized HorizontalLayout create(
        String labelLeft, String labelRight, Component compLeft,
        Component compRight, int width, boolean required) {

        HorizontalLayout hor = new HorizontalLayout();
        hor.setHeight(Constants.DEFAULT_HEIGHT);
        hor.addComponent(new Label(" "));
        String text = Constants.P_ALIGN_RIGHT + labelLeft + Constants.P;
        Label ll, lr;
        hor.addComponent(ll = new Label(text, Label.CONTENT_XHTML));
        ll.setSizeUndefined();
        ll.setWidth(width + Constants.PX);
        hor.setComponentAlignment(ll, Alignment.MIDDLE_RIGHT);
        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:13px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(compLeft);
        hor.setComponentAlignment(compLeft, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label("&nbsp;", Label.CONTENT_XHTML));
        String text2 = Constants.P_ALIGN_RIGHT + labelRight + Constants.P;
        hor.addComponent(lr = new Label(text2, Label.CONTENT_XHTML));
        lr.setSizeUndefined();
        lr.setWidth(width + Constants.PX);
        hor.setComponentAlignment(lr, Alignment.MIDDLE_RIGHT);
        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:13px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(compRight);
        hor.setComponentAlignment(compRight, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" "));
        hor.setSpacing(false);
        return hor;
    }

    /**
     * Helper method. Puts a blank in front of a component. Useful for buttons.
     * 
     * @param comp
     *            The component to display.
     * @return The component in an grid layout. A blank in front and afterwards
     *         is inserted.
     */
    public static synchronized GridLayout create(Component comp) {

        GridLayout hor = new GridLayout(3, 1);
        hor.setHeight(Constants.DEFAULT_HEIGHT);
        hor.addComponent(new Label(" "), 0, 0);
        hor.addComponent(comp, 1, 0);
        hor.setComponentAlignment(comp, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" "), 2, 0);
        hor.setSpacing(false);
        return hor;
    }

    /**
     * Creates an element depending on its state.
     * 
     * @param className
     *            the name of the calling class.
     * @param item
     *            an instance of POJOItem.
     * 
     * @param readOnly
     *            can the values be changed.
     * @param propertyName
     *            the name of the binding property.
     * @return the initialized component.
     */
    public static synchronized AbstractComponent createElement(
        final String className, final POJOItem<?> item, final boolean readOnly,
        final String propertyName) {

        AbstractComponent comp;
        if (readOnly) {
            comp = new Label();
            ((Label) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
        }
        else {
            comp = new TextField();
            ((TextField) comp).setNullRepresentation("");
            ((TextField) comp).setWriteThrough(false);
            ((TextField) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
            List<Field> attachedFields = attachedFieldsMap.get(className);
            if (attachedFields == null) {
                attachedFields = new ArrayList<Field>();
                attachedFieldsMap.put(className, attachedFields);
            }
            attachedFields.add((Field) comp);
        }
        return comp;
    }

    /**
     * Creates an element depending on its state.
     * 
     * @param className
     *            the name of the calling class.
     * @param item
     *            an instance of POJOItem.
     * 
     * @param readOnly
     *            can the values be changed.
     * @param propertyName
     *            the name of the binding property.
     * @param values
     *            the values to display in the select element.
     * @return the initialized component.
     */
    public static synchronized AbstractComponent createSelectElement(
        final String className, final POJOItem<?> item, final boolean readOnly,
        final String propertyName, final String[] values) {

        AbstractComponent comp;
        if (readOnly) {
            comp = new Label();
            ((Label) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
        }
        else {
            comp = new Select();
            for (final String theItem : values) {
                ((Select) comp).addItem(theItem);
            }
            ((Select) comp).setWriteThrough(false);
            ((Select) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
            List<Field> attachedFields = attachedFieldsMap.get(className);
            if (attachedFields == null) {
                attachedFields = new ArrayList<Field>();
                attachedFieldsMap.put(className, attachedFields);
            }
            attachedFields.add((Field) comp);
        }
        return comp;
    }

    /**
     * Creates a Select depending on its state.
     * 
     * @param className
     *            the name of the calling class.
     * @param item
     *            an instance of POJOItem.
     * 
     * @param readOnly
     *            can the values be changed.
     * @param propertyName
     *            the name of the binding property.
     * @param values
     *            the values to display in the select element.
     * @return the initialized component.
     */
    public static synchronized AbstractComponent createSelectElement(
        final String className, final POJOItem<?> item, final boolean readOnly,
        final String propertyName, final Enum<?>[] values) {

        AbstractComponent comp;
        if (readOnly) {
            comp = new Label();
            ((Label) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
        }
        else {
            comp = new Select();
            for (final Enum<?> theItem : values) {
                ((Select) comp).addItem(theItem);
            }
            ((Select) comp).setWriteThrough(false);
            ((Select) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
            List<Field> attachedFields = attachedFieldsMap.get(className);
            if (attachedFields == null) {
                attachedFields = new ArrayList<Field>();
                attachedFieldsMap.put(className, attachedFields);
            }
            attachedFields.add((Field) comp);
        }
        return comp;
    }

    /**
     * Creates a native select depending on its state.
     * 
     * @param className
     *            the name of the calling class.
     * @param item
     *            an instance of POJOItem.
     * 
     * @param readOnly
     *            can the values be changed.
     * @param propertyName
     *            the name of the binding property.
     * @param values
     *            the values to display in the select element.
     * @return the initialized component.
     */
    public static synchronized AbstractComponent createNativeSelectElement(
        final String className, final POJOItem<?> item, final boolean readOnly,
        final String propertyName, final Enum<?>[] values) {

        AbstractComponent comp;
        if (readOnly) {
            comp = new Label();
            ((Label) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
        }
        else {
            comp = new NativeSelect();
            for (final Enum<?> theItem : values) {
                ((NativeSelect) comp).addItem(theItem);
            }
            ((NativeSelect) comp).setWriteThrough(false);
            ((NativeSelect) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
            List<Field> attachedFields = attachedFieldsMap.get(className);
            if (attachedFields == null) {
                attachedFields = new ArrayList<Field>();
                attachedFieldsMap.put(className, attachedFields);
            }
            attachedFields.add((Field) comp);
        }
        return comp;
    }

    /**
     * Creates a native select depending on its state.
     * 
     * @param className
     *            the name of the calling class.
     * @param item
     *            an instance of POJOItem.
     * 
     * @param readOnly
     *            can the values be changed.
     * @param propertyName
     *            the name of the binding property.
     * @param values
     *            the values to display in the select element.
     * @return the initialized component.
     */
    public static synchronized AbstractComponent createNativeSelectElement(
        final String className, final POJOItem<?> item, final boolean readOnly,
        final String propertyName, final IMenuItem[] values) {

        AbstractComponent comp;
        if (readOnly) {
            comp = new Label();
            ((Label) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
        }
        else {
            comp = new NativeSelect();
            for (final IMenuItem theItem : values) {
                ((NativeSelect) comp).addItem(theItem);
            }
            ((NativeSelect) comp).setWriteThrough(false);
            ((NativeSelect) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
            List<Field> attachedFields = attachedFieldsMap.get(className);
            if (attachedFields == null) {
                attachedFields = new ArrayList<Field>();
                attachedFieldsMap.put(className, attachedFields);
            }
            attachedFields.add((Field) comp);
        }
        return comp;
    }

    /**
     * Creates a select depending on its state.
     * 
     * @param className
     *            the name of the calling class.
     * @param item
     *            an instance of POJOItem.
     * 
     * @param readOnly
     *            can the values be changed.
     * @param propertyName
     *            the name of the binding property.
     * @param values
     *            the values to display in the select element.
     * @return the initialized component.
     */
    public static synchronized AbstractComponent createSelectElement(
        final String className, final POJOItem<?> item, final boolean readOnly,
        final String propertyName, final IMenuItem[] values) {
        AbstractComponent comp;
        if (readOnly) {
            comp = new Label();
            ((Label) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
        }
        else {
            comp = new Select();
            for (final IMenuItem theItem : values) {
                ((Select) comp).addItem(theItem);
            }
            ((Select) comp).setWriteThrough(false);
            ((Select) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
            List<Field> attachedFields = attachedFieldsMap.get(className);
            if (attachedFields == null) {
                attachedFields = new ArrayList<Field>();
                attachedFieldsMap.put(className, attachedFields);
            }
            attachedFields.add((Field) comp);
        }
        return comp;
    }

    /**
     * Creates a select depending on its state.
     * 
     * @param className
     *            the name of the calling class.
     * @param item
     *            an instance of POJOItem.
     * 
     * @param readOnly
     *            can the values be changed.
     * @param propertyName
     *            the name of the binding property.
     * @return the initialized component.
     */
    public static synchronized AbstractComponent createListElement(
        final String className, final POJOItem<?> item, final boolean readOnly,
        final String propertyName) {

        final AbstractComponent comp = new ListSelect();
        ((ListSelect) comp).setReadOnly(readOnly);
        ((ListSelect) comp).setPropertyDataSource(item
            .getItemProperty(propertyName));
        ((ListSelect) comp).setWriteThrough(false);
        List<Field> attachedFields = attachedFieldsMap.get(className);
        if (attachedFields == null) {
            attachedFields = new ArrayList<Field>();
            attachedFieldsMap.put(className, attachedFields);
        }
        attachedFields.add((Field) comp);
        return comp;
    }

    /**
     * Creates a select depending on its state.
     * 
     * @param className
     *            the name of the calling class.
     * @param item
     *            an instance of POJOItem.
     * 
     * @param readOnly
     *            can the values be changed.
     * @param propertyName
     *            the name of the binding property.
     * @param resolution
     *            the resolution of the calendar.
     * @return the initialized component.
     */
    public static synchronized AbstractComponent createDateElement(
        final String className, final POJOItem<?> item, final boolean readOnly,
        final String propertyName, int resolution) {

        AbstractComponent comp;
        if (readOnly) {
            comp = new Label();
            ((Label) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
        }
        else {
            comp = new DateField();
            ((DateField) comp).setResolution(resolution);
            ((DateField) comp).setWriteThrough(false);
            ((DateField) comp).setPropertyDataSource(item
                .getItemProperty(propertyName));
            List<Field> attachedFields = attachedFieldsMap.get(className);
            if (attachedFields == null) {
                attachedFields = new ArrayList<Field>();
                attachedFieldsMap.put(className, attachedFields);
            }
            attachedFields.add((Field) comp);
        }
        return comp;
    }

    /**
     * Creates a select depending on its state.
     * 
     * @param className
     *            the name of the calling class.
     * @param item
     *            an instance of POJOItem.
     * 
     * @param readOnly
     *            can the values be changed.
     * @param text
     *            the text of the checkbox.
     * @param propertyName
     *            the name of the binding property.
     * @param resolution
     *            the resolution of the calendar.
     * @return the initialized component.
     */
    public static synchronized AbstractComponent createCheckBoxElement(
        final String className, final POJOItem<?> item, final boolean readOnly,
        final String text, final String propertyName) {

        AbstractComponent comp = new CheckBox(text);
        comp.setReadOnly(readOnly);
        ((CheckBox) comp).setWriteThrough(false);
        ((CheckBox) comp).setPropertyDataSource(item
            .getItemProperty(propertyName));
        List<Field> attachedFields = attachedFieldsMap.get(className);
        if (attachedFields == null) {
            attachedFields = new ArrayList<Field>();
            attachedFieldsMap.put(className, attachedFields);
        }
        attachedFields.add((Field) comp);
        return comp;
    }

    /**
     * @param form
     *            the form layout to add the component to.
     * @param comp
     *            the component to add.
     * @param label
     *            the label in front of the component.
     * @param labelWidth
     *            the min. width of the label.
     * @param width
     *            the width of the component.
     * @param height
     *            the height of the
     * @param required
     *            true if the field is mandatory.
     */
    public static synchronized void addElement(
        final FormLayout form, final AbstractComponent comp,
        final String label, final int labelWidth, final int width,
        final int height, final boolean required) {
        
        comp.setWidth(width + Constants.PX);
        form.addComponent(LayoutHelper.create(label, comp, labelWidth, height,
            required));
    }

    /**
     * @param form
     *            the form layout to add the component to.
     * @param comp
     *            the component to add.
     * @param label
     *            the label in front of the component.
     * @param labelWidth
     *            the min. width of the label.
     * @param width
     *            the width of the component.
     * @param height
     *            the height of the
     * @param required
     *            true if the field is mandatory.
     * @param buttons
     *            the buttons to display.
     */
    public static synchronized void addElement(
        final FormLayout form, final AbstractComponent comp,
        final String label, final int labelWidth, final int width,
        final int height, final boolean required, Button[] buttons) {
     
        comp.setWidth(width + Constants.PX);
        form.addComponent(LayoutHelper.create(label, comp, labelWidth, height,
            required, buttons));
    }

    /**
     * @param form
     *            the form layout to add the component to.
     * @param comp
     *            the component to add.
     * @param label
     *            the label in front of the component.
     * @param labelWidth
     *            the min. width of the label.
     * @param width
     *            the width of the component.
     * @param required
     *            true if the field is mandatory.
     */
    public static synchronized void addElement(
        final FormLayout form, final AbstractComponent comp,
        final String label, final int labelWidth, final int width,
        final boolean required) {
        comp.setWidth(width + Constants.PX);
        form.addComponent(LayoutHelper
            .create(label, comp, labelWidth, required));

    }

    /**
     * @param form
     *            the form layout to add the component to.
     * @param comp
     *            the component to add.
     * @param label
     *            the label in front of the component.
     * @param labelWidth
     *            the min. width of the label.
     * @param width
     *            the width of the component.
     * @param required
     *            true if the field is mandatory.
     */
    public static synchronized void addElement(
        final FormLayout form, final FormLayout comp, final String label,
        final int labelWidth, final int width, final boolean required) {
        comp.setWidth(width + Constants.PX);
        form.addComponent(LayoutHelper
            .create(label, comp, labelWidth, required));

    }

    /**
     * Helper method. Puts a blank in front of a component.
     * 
     * @param label
     *            The label in front of the control.
     * @param comp
     *            The customer build component to display.
     * @param width
     *            the fixed size of the label. The parameter has to be in CSS
     *            style, i.e. 400px for instance.
     * @param required
     *            should it be marked with an asterisk.
     * @return The component in an horizontal layout. A blank in front and
     *         afterwards is inserted.
     */
    public static synchronized HorizontalLayout create(
        String label, FormLayout comp, int width, boolean required) {

        HorizontalLayout hor = new HorizontalLayout();
        hor.setHeight("400px");
        hor.addComponent(new Label(" "));
        String text = Constants.P_ALIGN_RIGHT + label + Constants.P;
        Label l;
        hor.addComponent(l = new Label(text, Label.CONTENT_XHTML));
        l.setSizeUndefined();
        l.setWidth(width + Constants.PX);
        hor.setComponentAlignment(l, com.vaadin.ui.Alignment.MIDDLE_RIGHT);

        if (required) {
            hor
                .addComponent(new Label(
                    "&nbsp;<span style=\"color:red; position:relative; top:13px;\">*</span>",
                    Label.CONTENT_XHTML));
        }
        else {
            hor.addComponent(new Label("&nbsp;&nbsp;", Label.CONTENT_XHTML));
        }
        hor.addComponent(comp);
        hor.setComponentAlignment(comp, Alignment.MIDDLE_RIGHT);
        hor.addComponent(new Label(" "));
        hor.setSpacing(false);
        return hor;
    }

    /**
     * @param className
     * @return
     */
    public static List<Field> getAttachedFields(String className) {
        return attachedFieldsMap.get(className);
    }

}
