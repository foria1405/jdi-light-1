package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDISnackbar;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import com.epam.jdi.light.material.elements.inputs.Button;

public class ConsecutiveSnackbarFrame extends Section {

    @UI(".MuiButton-root[1]")
    public Button openFirstSnackbarButton;

    @UI(".MuiButton-root[2]")
    public Button openSecondSnackbarButton;

    @JDISnackbar(root = ".MuiSnackbar-root",
            message = ".MuiSnackbarContent-message",
            actions = ".MuiSnackbarContent-action button")
    public Snackbar snackbar;

}