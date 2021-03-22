package org.bsuir.controller;

import org.bsuir.model.Model;
import org.bsuir.model.Parameters;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class SearchPatientController {
    private final Model fullModel;
    private final JButton searchButton;
    private final JTextField[] textFields;
    private final JLabel[] labelItems;
    private final JDatePanelImpl[] datePanels;
    private final JComboBox<String> searchByTypeComboBox;
    private final JTable table;

    public SearchPatientController(Model fullModel, JButton searchButton
            , JTextField[] textFields, JLabel[] labelItems
            , JDatePanelImpl[] datePanel, JComboBox<String> searchByTypeComboBox
            , JTable table) {

        this.table = table;
        this.fullModel = fullModel;
        this.datePanels = datePanel;
        this.searchButton = searchButton;
        this.searchByTypeComboBox = searchByTypeComboBox;
        this.labelItems = labelItems;
        this.textFields = textFields;
        table.setModel(fullModel);
        System.out.println(fullModel.getRowCount());
        setSearchButtonAction();
    }

    private void setSearchButtonAction() {
        searchButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (searchByTypeComboBox.getSelectedItem().equals(Parameters.SEARCH_TYPES[0])) {
                    String fullName = getFullName();
                    String address = getAddress();

                    Model subModel = fullModel.createSubModelByFullNameAndAddress(fullName,address);
                    table.setModel(subModel);

                } else if (searchByTypeComboBox.getSelectedItem().equals(Parameters.SEARCH_TYPES[1])) {
                    Date birthday = getBirthday();
                    Model subModel = fullModel.createSubModelByBirthday(birthday);
                    table.setModel(subModel);


                } else if (searchByTypeComboBox.getSelectedItem().equals(Parameters.SEARCH_TYPES[2])) {
                    String doctorsFullName = getDoctorFullName();
                    Date dateOfReceipt = getDateOfReceipt();

                    Model subModel = fullModel.createSubModelByDoctorsFullNameOrDateReceipt(doctorsFullName,dateOfReceipt);
                    table.setModel(subModel);
                }

            }
        });
    }

    //todo check info
    private Date getDateOfReceipt() {
        return (Date) datePanels[1].getModel().getValue();
    }

    private String getDoctorFullName() {
        return textFields[2].getText();
    }

    private Date getBirthday() {
        return (Date) datePanels[0].getModel().getValue();
    }

    private String getAddress() {
        return textFields[1].getText();
    }

    private String getFullName() {
        return textFields[0].getText();
    }
}
