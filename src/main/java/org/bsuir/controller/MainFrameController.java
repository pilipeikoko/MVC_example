package org.bsuir.controller;

import org.bsuir.model.Model;
import org.bsuir.view.AddPatientView;
import org.bsuir.view.DeletePatientView;
import org.bsuir.view.SearchPatientView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrameController {
    private final MenuItem[] menuItems;
    private final JButton[] buttonItems;
    private final JLabel[] labelItems;
    private final JSpinner pageSpinner;
    private final Model model;

    public MainFrameController(Model model,MenuItem[] menuItems,JButton[] buttonItems,JLabel[] labelItems,JSpinner pageSpinner){
        this.model = model;
        this.buttonItems = buttonItems;
        this.menuItems = menuItems;
        this.labelItems = labelItems;
        this.pageSpinner = pageSpinner;
        setMenuItemsController();
    }

    public void setMenuItemsController(){
        menuItems[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatientView(model);
            }
        });

        menuItems[3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeletePatientView();
            }
        });

        menuItems[4].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchPatientView(new Model());
            }
        });
    }
}
