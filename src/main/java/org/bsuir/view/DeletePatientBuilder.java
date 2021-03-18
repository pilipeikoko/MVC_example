package org.bsuir.view;

import org.bsuir.model.DateLabelFormatter;
import org.bsuir.model.Parameters;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Properties;

public class DeletePatientBuilder {
    private static final int AMOUNT_OF_TEXT_FIELDS = 3;
    private static final int AMOUNT_OF_DATE_PANELS = 2;
    private static final int AMOUNT_OF_LABEL_ITEMS = 5;

    private final JTextField[] textFields;
    private final JDatePanelImpl[] datePanels;
    private final JLabel[] labelItems;

    private final JPanel cards;
    private final JDialog dialog;
    private final JComboBox<String> deleteByTypeComboBox;
    private final JButton deleteButton;

    public DeletePatientBuilder() {
        textFields = new JTextField[AMOUNT_OF_TEXT_FIELDS];
        datePanels = new JDatePanelImpl[AMOUNT_OF_DATE_PANELS];
        labelItems = new JLabel[AMOUNT_OF_LABEL_ITEMS];

        dialog = new JDialog();

        deleteButton = new JButton("Delete");

        deleteByTypeComboBox = new JComboBox<>(Parameters.DELETE_TYPES);

        dialog.setPreferredSize(new Dimension(300, 160));

        deleteByTypeComboBox.setMaximumSize(new Dimension(30, 100));


        //TODO remove controller
        deleteByTypeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout layout = (CardLayout)(cards.getLayout());
                layout.show(cards, (String)e.getItem());
            }
        });



        JPanel defaultDeletePanel = createDefaultDeletePanel();


        JPanel surnameOrAddressPanel = createSurnameOrAddressPanel();
        JPanel birthdayPanel = createBirthdayPanel();
        JPanel fullDoctorsNameOrReceiptDatePanel = createFullDoctorsNameOrReceiptDatePanel();

        cards = new JPanel(new CardLayout());

        cards.add(surnameOrAddressPanel, Parameters.DELETE_TYPES[0]);
        cards.add(birthdayPanel, Parameters.DELETE_TYPES[1]);
        cards.add(fullDoctorsNameOrReceiptDatePanel,Parameters.DELETE_TYPES[2]);

        dialog.add(defaultDeletePanel,BorderLayout.NORTH);
        dialog.add(cards,BorderLayout.CENTER);
        dialog.add(deleteButton,BorderLayout.SOUTH);


        dialog.pack();
        dialog.setVisible(true);
    }

    private JPanel createFullDoctorsNameOrReceiptDatePanel() {

        JPanel receiptDatePanel = new JPanel();
        JLabel receiptDateLabel = new JLabel("Receipt date:");

        UtilDateModel dateOfReceiptModel = new UtilDateModel();
        JDatePanelImpl dateOfReceiptPanel = new JDatePanelImpl(dateOfReceiptModel, new Properties());
        JDatePickerImpl dateOfReceiptPicker = new JDatePickerImpl(dateOfReceiptPanel, new DateLabelFormatter());

        JLabel doctorsFullNameLabel = new JLabel("Doctors full name");
        JTextField doctorsFullNameTextField = new JTextField();
        doctorsFullNameTextField.setPreferredSize(new Dimension(100,30));

        GroupLayout layout = new GroupLayout(receiptDatePanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        receiptDatePanel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(doctorsFullNameLabel)
                        .addComponent(doctorsFullNameTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(receiptDateLabel)
                        .addComponent(dateOfReceiptPicker)
                )
        );

        layout.setVerticalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(doctorsFullNameLabel)
                        .addComponent(doctorsFullNameTextField))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(receiptDateLabel)
                        .addComponent(dateOfReceiptPicker)
                )
        );

        labelItems[3] = receiptDateLabel;
        labelItems[4] = doctorsFullNameLabel;

        textFields[2] = doctorsFullNameTextField;

        datePanels[1] = dateOfReceiptPanel;

        return receiptDatePanel;
    }

    private JPanel createBirthdayPanel() {
        JPanel birthdayPanel = new JPanel();
        JLabel birthdayLabel = new JLabel("Birthday:");

        UtilDateModel dateOfBirthModel = new UtilDateModel();
        JDatePanelImpl dateOfBirthPanel = new JDatePanelImpl(dateOfBirthModel, new Properties());
        JDatePickerImpl dateOfBirthPicker = new JDatePickerImpl(dateOfBirthPanel, new DateLabelFormatter());

        birthdayPanel.add(birthdayLabel);
        birthdayPanel.add(dateOfBirthPicker);

        labelItems[2] = birthdayLabel;
        datePanels[0] = dateOfBirthPanel;

        return birthdayPanel;
    }

    private JPanel createDefaultDeletePanel() {
        JLabel deleteByLabel = new JLabel("Delete by:");

        JPanel defaultDeletePanel = new JPanel();

        defaultDeletePanel.add(deleteByLabel);
        defaultDeletePanel.add(deleteByTypeComboBox);
        defaultDeletePanel.setMaximumSize(new Dimension(300,100));

        return defaultDeletePanel;
    }

    private JPanel createSurnameOrAddressPanel(){
        JPanel surnameOrAddressPanel = new JPanel();

        addSurnameOrAddressPanelComponents();

        surnameOrAddressPanel.setPreferredSize(new Dimension(300,200));

        GroupLayout layout = new GroupLayout(surnameOrAddressPanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        surnameOrAddressPanel.setLayout(layout);


        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(labelItems[0])
                        .addComponent(textFields[0]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(labelItems[1])
                        .addComponent(textFields[1])
                )
        );

        layout.setVerticalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelItems[0])
                        .addComponent(textFields[0]))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelItems[1])
                        .addComponent(textFields[1])
                )
        );


        return surnameOrAddressPanel;
    }

    private void addSurnameOrAddressPanelComponents() {
        JLabel fullNameLabel = new JLabel("Full name");
        JLabel addressLabel = new JLabel("Address");

        JTextField fullNameTextField = new JTextField();
        fullNameTextField.setPreferredSize(new Dimension(100,30));
        JTextField addressTextField = new JTextField();
        addressTextField.setPreferredSize(new Dimension(100,30));

        textFields[0] = fullNameTextField;
        textFields[1] = addressTextField;

        labelItems[0] = fullNameLabel;
        labelItems[1] = addressLabel;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTextField[] getTextFields() {
        return textFields;
    }

    public JLabel[] getLabelItems() {
        return labelItems;
    }

    public JDatePanelImpl[] getDatePanels() {
        return datePanels;
    }

    public JComboBox getDeleteByTypeComboBox() {
        return deleteByTypeComboBox;
    }
}
