package org.bsuir.controller;

import org.bsuir.exception.EmptyFieldException;
import org.bsuir.model.DateManager;
import org.bsuir.model.PatientsTableModel;
import org.bsuir.model.Parameters;
import org.bsuir.view.Alert;
import org.bsuir.view.DeletePatientBuilder;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

public class DeletePatientController {

    private final PatientsTableModel patientsTableModel;
    private final JButton deleteButton;
    /**
     * @see DeletePatientBuilder#getTextFields()
     */
    private final JTextField[] textFields;
    /**
     * @see DeletePatientBuilder#getLabelItems()
     */
    private final JLabel[] labelItems;
    /**
     * @see DeletePatientBuilder#getDatePanels()
     */
    private final JDatePanelImpl[] datePanels;
    private final JComboBox<String> deleteByTypeComboBox;
    private final JPanel cards;

    public DeletePatientController(PatientsTableModel model, JButton deleteButton
            , JTextField[] textFields, JLabel[] labelItems
            , JDatePanelImpl[] datePanels, JComboBox<String> deleteByTypeComboBox, JPanel cards) {

        this.patientsTableModel = model;
        this.deleteButton = deleteButton;
        this.textFields = textFields;
        this.labelItems = labelItems;
        this.datePanels = datePanels;
        this.deleteByTypeComboBox = deleteByTypeComboBox;
        this.cards = cards;

        setComboBoxController();
        setRemoveButtonAction();
    }

    private void setComboBoxController() {
        deleteByTypeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout layout = (CardLayout) (cards.getLayout());
                layout.show(cards, (String) e.getItem());
            }
        });
    }

    private void setRemoveButtonAction() {
        deleteButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int amountOfDeletedPatients = 0;

                    String deleteType = (String) deleteByTypeComboBox.getSelectedItem();

                    if (deleteType == null) {
                        throw new EmptyFieldException("Unknown type");
                    }

                    if (deleteType.equals(Parameters.SEARCH_TYPES[0])) {
                        String fullName = getFullName();
                        String address = getAddress();

                        amountOfDeletedPatients = patientsTableModel.deleteByFullNameOrAddress(fullName, address);
                    } else if (deleteType.equals(Parameters.SEARCH_TYPES[1])) {
                        DateManager birthday = new DateManager(getBirthday());

                        amountOfDeletedPatients = patientsTableModel.deleteByBirthday(birthday);
                    } else if (deleteType.equals(Parameters.SEARCH_TYPES[2])) {
                        String doctorsFullName = getDoctorFullName();
                        DateManager dateOfReceipt = new DateManager(getDateOfReceipt());

                        amountOfDeletedPatients = patientsTableModel.deleteByDoctorsFullNameOrDateReceipt(doctorsFullName, dateOfReceipt);

                    }

                    SwingUtilities.getWindowAncestor(deleteButton).dispose();
                    Alert.deletionAlert(amountOfDeletedPatients);
                } catch (EmptyFieldException exception) {
                    Alert.unknownTypeAlert();
                }
            }
        });
    }

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
