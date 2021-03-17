package org.example.controller;

import org.example.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class Controller implements ActionListener {

    View view;
    private final DefaultTableModel model;

    public Controller(View view, DefaultTableModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

}
