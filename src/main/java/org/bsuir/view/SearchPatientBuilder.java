package org.bsuir.view;

import org.bsuir.model.Model;
import org.bsuir.model.Parameters;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SearchPatientBuilder {
    private final CardsBuilder cardsBuilder;
    private final JButton searchButton;
    private final JDialog dialog;
    private final JComboBox<String> searchByTypeComboBox;
    private final TableBuilder tableBuilder;
    private final PageComponentsBuilder pageComponentsBuilder;

    public SearchPatientBuilder(Model model){
        cardsBuilder = new CardsBuilder();

        searchButton = new JButton("Search");

        dialog = new JDialog();
        dialog.setPreferredSize(new Dimension(900, 525));

        searchByTypeComboBox = new JComboBox<>(Parameters.DELETE_TYPES);
        searchByTypeComboBox.setMaximumSize(new Dimension(30, 100));

        tableBuilder = new TableBuilder(model);
        pageComponentsBuilder = new PageComponentsBuilder();

        //todo remove controller
        searchByTypeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout layout = (CardLayout)(cardsBuilder.getCards().getLayout());
                layout.show(cardsBuilder.getCards(), (String)e.getItem());
            }
        });

        JPanel defaultSearchPanel = createDefaultDeletePanel();
        JPanel tablePanel = createTablePanel();

        dialog.add(defaultSearchPanel,BorderLayout.NORTH);
        dialog.add(cardsBuilder.getCards(),BorderLayout.CENTER);
        dialog.add(searchButton,BorderLayout.SOUTH);
        dialog.add(tablePanel,BorderLayout.EAST);



        dialog.pack();
        dialog.setVisible(true);
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(700,300));
        GroupLayout layout = new GroupLayout(tablePanel);
        tablePanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        setHorizontalLayout(layout);
        setVerticalLayout(layout);

        return tablePanel;
    }

    private void setVerticalLayout(GroupLayout layout) {
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(tableBuilder.getTable().getTableHeader())
                .addComponent(tableBuilder.getTableScrollPane())
                .addGroup(layout.createParallelGroup()
                        .addComponent(pageComponentsBuilder.getLabelItems()[0])
                        .addComponent(pageComponentsBuilder.getPageSpinner()))
                .addGroup(layout.createParallelGroup()
                        .addComponent(pageComponentsBuilder.getLabelItems()[1])
                        .addComponent(pageComponentsBuilder.getButtonItems()[0])
                        .addComponent(pageComponentsBuilder.getButtonItems()[1])
                        .addComponent(pageComponentsBuilder.getButtonItems()[2])
                        .addComponent(pageComponentsBuilder.getButtonItems()[3]))
                .addComponent(pageComponentsBuilder.getLabelItems()[2])
                .addComponent(pageComponentsBuilder.getLabelItems()[3]));

    }

    private void setHorizontalLayout(GroupLayout layout) {
        layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(
                layout.createParallelGroup()
                        .addComponent(tableBuilder.getTable().getTableHeader())
                        .addComponent(tableBuilder.getTableScrollPane())
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pageComponentsBuilder.getLabelItems()[0])
                                .addComponent(pageComponentsBuilder.getPageSpinner()))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pageComponentsBuilder.getLabelItems()[1])
                                .addComponent(pageComponentsBuilder.getButtonItems()[0])
                                .addComponent(pageComponentsBuilder.getButtonItems()[1])
                                .addComponent(pageComponentsBuilder.getButtonItems()[2])
                                .addComponent(pageComponentsBuilder.getButtonItems()[3]))
                        .addComponent(pageComponentsBuilder.getLabelItems()[2])
                        .addComponent(pageComponentsBuilder.getLabelItems()[3], GroupLayout.Alignment.CENTER)));

    }

    private JPanel createDefaultDeletePanel() {
        JLabel searchByLabel = new JLabel("Search by:");

        JPanel defaultSearchPanel = new JPanel();

        defaultSearchPanel.add(searchByLabel);
        defaultSearchPanel.add(searchByTypeComboBox);
        defaultSearchPanel.setMaximumSize(new Dimension(300,100));

        return defaultSearchPanel;
    }

    public JButton getDeleteButton() {
        return searchButton;
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
        return searchByTypeComboBox;
    }
}
