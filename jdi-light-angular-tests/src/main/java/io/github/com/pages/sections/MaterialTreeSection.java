package io.github.com.pages.sections;


import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.Menu2D;

public class MaterialTreeSection {
    @UI("tree-dynamic-example")
    public static UIElement dynamicExample;
    @UI("#tree-dynamic")
    public static Menu2D dynamicTree;
    @UI("tree-flat-overview-example")
    public static UIElement flatExample;
    @UI("#tree-flat")
    public static Menu2D flatTree;
    @UI("tree-checklist-example")
    public static UIElement checkBoxesExample;
    @UI("#tree-checklist")
    public static Menu2D checkBoxesTree;
}
