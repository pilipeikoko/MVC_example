package org.bsuir.controller;

import org.bsuir.view.MainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class Controller implements ActionListener {

    MainFrameView mainFrameView;
    private final DefaultTableModel model;

    public Controller(MainFrameView mainFrameView, DefaultTableModel model) {
        this.mainFrameView = mainFrameView;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

}
