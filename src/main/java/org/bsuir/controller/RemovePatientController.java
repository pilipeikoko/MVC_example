package org.bsuir.controller;

import org.bsuir.model.Model;
import org.bsuir.model.Parameters;
import org.bsuir.model.Patient;
import org.bsuir.view.Alert;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class RemovePatientController {

    private final Model model;
    private final JButton deleteButton;
    private final JTextField[] textFields;
    private final JLabel[] labelItems;
    private final JDatePanelImpl[] datePanels;
    private final JComboBox<String> deleteByTypeComboBox;

    public RemovePatientController(Model model, JButton deleteButton
            , JTextField[] textFields, JLabel[] labelItems
            , JDatePanelImpl[] datePanels, JComboBox<String> deleteByTypeComboBox) {
        this.model = model;
        this.deleteButton = deleteButton;
        this.textFields = textFields;
        this.labelItems = labelItems;
        this.datePanels = datePanels;
        this.deleteByTypeComboBox = deleteByTypeComboBox;

        setRemoveButtonAction();
    }

    private void setRemoveButtonAction() {
        deleteButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amountOfDeletedPatients = 0;

                if (deleteByTypeComboBox.getSelectedItem().equals(Parameters.SEARCH_TYPES[0])) {
                    String fullName = getFullName();
                    String address = getAddress();

                    amountOfDeletedPatients = model.deleteByFullNameOrAddress(fullName, address);
                }
                else if(deleteByTypeComboBox.getSelectedItem().equals(Parameters.SEARCH_TYPES[1])){
                    Date birthday = getBirthday();

                    amountOfDeletedPatients = model.deleteByBirthday(birthday);
                }
                else if(deleteByTypeComboBox.getSelectedItem().equals(Parameters.SEARCH_TYPES[2])){
                    String doctorsFullName = getDoctorFullName();
                    Date dateOfReceipt = getDateOfReceipt();

                    amountOfDeletedPatients = model.deleteByDoctorsFullNameOrDateReceipt(doctorsFullName,dateOfReceipt);

                }


                SwingUtilities.getWindowAncestor(deleteButton).dispose();
                Alert.deletionAlert(amountOfDeletedPatients);
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
        return (Date)datePanels[0].getModel().getValue();
    }

    private String getAddress() {
        return textFields[1].getText();
    }

    private String getFullName() {
        return textFields[0].getText();
    }



}
