package org.bsuir.controller;

import org.bsuir.model.Model;
import org.bsuir.model.Patient;
import org.bsuir.view.AddPatientBuilder;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

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
        setButtonAction();
    }

    private void setButtonAction() {
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
        model.addRow(parsePatient());
    }

    private Object[] parsePatient(){
        Object[] objects = new Object[6];
        objects[0] = patient.getFullName();
        objects[1] = patient.getPlaceOfResidence();
        objects[2] =patient.getBirthday();
        objects[3] =patient.getDateOfReceipt();
        objects[4] =patient.getDoctorsFullName();
        objects[5] =patient.getConclusion();
        return objects;

    }

    private void checkInfo() {
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
