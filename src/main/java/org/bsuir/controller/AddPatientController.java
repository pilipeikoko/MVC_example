package org.bsuir.controller;

import org.bsuir.model.Model;
import org.bsuir.model.Patient;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

//todo add alerts
public class AddPatientController {
    private final Model model;
    private Patient patient;
    private final JTextField[] textFields;
    private final JDatePanelImpl[] datePanels;
    private final JButton enterButton;

    public AddPatientController(Model model,JTextField[] textFields,JDatePanelImpl[] datePanels,JButton enterButton){
        this.model = model;
        this.textFields = textFields;
        this.datePanels = datePanels;
        this.enterButton = enterButton;
        setEnterButtonAction();
    }

    private void setEnterButtonAction() {
        enterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInfo();
                checkInfo();
                addPatientToModel();
                SwingUtilities.getWindowAncestor(enterButton).dispose();
            }
        });
    }

    private void addPatientToModel() {
        model.addPatient(patient);
    }


    private void checkInfo() {
        //todo
    }

    private void getInfo() {
        String fullName = textFields[0].getText();
        String placeOfResidence = textFields[1].getText();
        Date birthday =(Date) datePanels[0].getModel().getValue();
        Date dateOfReceipt = (Date) datePanels[1].getModel().getValue();
        String doctorsFullName = textFields[2].getText();
        String conclusion=textFields[3].getText();
        patient = new Patient(fullName,placeOfResidence,birthday,dateOfReceipt,doctorsFullName,conclusion);
    }
}
