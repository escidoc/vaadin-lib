package de.escidoc.vaadin.dialog;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

import de.escidoc.vaadin.utilities.LayoutHelper;

public class ErrorDialog extends Window {
    private static final long serialVersionUID = 6255824594582824620L;

    private final FormLayout layout = new FormLayout();

    public ErrorDialog(final Window mainWindow, final String caption,
        final String errorMessage) {
        super.setCaption(caption);
        super.setModal(true);
        layout.addComponent(LayoutHelper.create("", new Label(errorMessage),
            10, false));
        Button button = new Button("OK");
        layout.addComponent(LayoutHelper.create("", button, 10, false));
        button.addListener(new Button.ClickListener() {
            private static final long serialVersionUID = 6160566882245069146L;

            @Override
            public void buttonClick(ClickEvent event) {
                mainWindow.removeWindow(ErrorDialog.this);
            }
        });
        super.addComponent(layout);
    }
}
