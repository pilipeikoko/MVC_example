package org.example.view;

import org.example.model.FrameParameters;

import java.awt.*;

public class MainFrameMenuBarBuilder {

    private MenuBar menuBar;
    private final MenuItem[] menuBarItems;

    public MainFrameMenuBarBuilder() {
        menuBarItems = new MenuItem[FrameParameters.AMOUNT_OF_MENU_BAR_ITEMS];
        makeMenuBar();
    }

    private void makeMenuBar() {
        MenuItem openFileItem = new MenuItem("Open file");
        MenuItem saveAsItem = new MenuItem("Save us");
        MenuItem addPatient = new MenuItem("Add");
        MenuItem deletePatient = new MenuItem("Delete");
        MenuItem searchPatient = new MenuItem("Search");

        addMenuBarItems(openFileItem, saveAsItem, addPatient, deletePatient, searchPatient);

        Menu fileMenu = new Menu("File");
        Menu patientMenu = new Menu("Patient");

        fileMenu.add(openFileItem);
        fileMenu.add(saveAsItem);

        patientMenu.add(addPatient);
        patientMenu.add(deletePatient);
        patientMenu.add(searchPatient);

        menuBar = new MenuBar();
        menuBar.add(fileMenu);
        menuBar.add(patientMenu);

    }

    private void addMenuBarItems(MenuItem openFileItem, MenuItem saveAsItem, MenuItem addPatient, MenuItem deletePatient, MenuItem searchPatient) {
        menuBarItems[0] = openFileItem;
        menuBarItems[1] = saveAsItem;
        menuBarItems[2] = addPatient;
        menuBarItems[3] = deletePatient;
        menuBarItems[4] = searchPatient;
    }

    public MenuItem[] getMenuBarItems() {
        return menuBarItems;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}
