package de.escidoc.vaadin.utilities;

import com.vaadin.ui.Tree;

/**
 * @author ASP
 * 
 */
public class TreeHelper {
    /**
     * Appends an child object to the parent.
     * 
     * @param tree
     *            the tree, where the child is appended.
     * @param parent
     *            the parent.
     * @param child
     *            the child.
     * @param childrenAllowed
     *            true if more children under the child are allowed, false
     *            otherwise.
     * @return
     */
    public static synchronized Object addChildren(
        final Tree tree, final Object parent, final Object child,
        final boolean childrenAllowed) {
        tree.addItem(child);
        tree.setParent(child, parent);
        tree.setChildrenAllowed(child, childrenAllowed);
        tree.expandItem(parent);
        return child;
    }

    public static synchronized Object addChildren(
        final Tree tree, final Object child, final boolean childrenAllowed) {
        tree.addItem(child);
        tree.setChildrenAllowed(child, childrenAllowed);
        return child;
    }

    public static synchronized Object addRoot(
        final Tree tree, final Object child, final boolean childrenAllowed) {
        tree.addItem(child);
        tree.setChildrenAllowed(child, childrenAllowed);
        return child;
    }

    public static synchronized Object addChildrenNotExpand(
        final Tree tree, final Object parent, final Object child,
        final boolean childrenAllowed) {
        tree.addItem(child);
        tree.setParent(child, parent);
        tree.setChildrenAllowed(child, childrenAllowed);
        return child;
    }

}