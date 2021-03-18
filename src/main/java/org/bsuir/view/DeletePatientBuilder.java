package org.bsuir.view;

import org.bsuir.model.Parameters;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DeletePatientBuilder {

    private final CardsBuilder cardsBuilder;
    private final JDialog dialog;
    private final JComboBox<String> deleteByTypeComboBox;
    private final JButton deleteButton;

    public DeletePatientBuilder() {
        deleteButton = new JButton("Delete");

        cardsBuilder = new CardsBuilder();

        dialog = new JDialog();
        dialog.setPreferredSize(new Dimension(400, 220));

        deleteByTypeComboBox = new JComboBox<>(Parameters.DELETE_TYPES);
        deleteByTypeComboBox.setMaximumSize(new Dimension(30, 100));

        //TODO remove controller
        deleteByTypeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout layout = (CardLayout)(cardsBuilder.getCards().getLayout());
                layout.show(cardsBuilder.getCards(), (String)e.getItem());
            }
        });

        JPanel defaultDeletePanel = createDefaultDeletePanel();

        dialog.add(defaultDeletePanel,BorderLayout.NORTH);
        dialog.add(cardsBuilder.getCards(),BorderLayout.CENTER);
        dialog.add(deleteButton,BorderLayout.SOUTH);

        dialog.pack();
        dialog.setVisible(true);
    }


    private JPanel createDefaultDeletePanel() {
        JLabel deleteByLabel = new JLabel("Delete by:");

        JPanel defaultDeletePanel = new JPanel();

        defaultDeletePanel.add(deleteByLabel);
        defaultDeletePanel.add(deleteByTypeComboBox);
        defaultDeletePanel.setMaximumSize(new Dimension(300,100));

        return defaultDeletePanel;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTextField[] getTextFields() {
        return cardsBuilder.getTextFields();
    }

    public JLabel[] getLabelItems() {
        return cardsBuilder.getLabelItems();
    }

    public JDatePanelImpl[] getDatePanels() {
        return cardsBuilder.getDatePanels();
    }

    public JComboBox<String> getDeleteByTypeComboBox() {
        return deleteByTypeComboBox;
    }
}
