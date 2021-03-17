package org.bsuir.view;

import org.bsuir.model.Model;

import javax.swing.*;
import java.awt.*;

public class MainFrameBuilder {
    private final JFrame frame;

    private final MainFrameMenuBarBuilder menuBarBuilder;
    private final MainFrameTableBuilder tableBuilder;
    private final MainFramePageComponentsBuilder pageComponentsBuilder;

    public MainFrameBuilder(Model model) {
        menuBarBuilder = new MainFrameMenuBarBuilder();
        tableBuilder = new MainFrameTableBuilder(model);
        pageComponentsBuilder = new MainFramePageComponentsBuilder();


        frame = new JFrame("Hospital database");
        setFrame();
    }

    private void setFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMenuBar(menuBarBuilder.getMenuBar());

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        setHorizontalLayout(layout);
        setVerticalLayout(layout);

        frame.pack();
        frame.setSize(700, 300);

        frame.setVisible(true);
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


    public MenuItem[] getMenuBarItems(){
        return this.menuBarBuilder.getMenuBarItems();
    }

    public JButton[] getButtonItems(){
        return this.pageComponentsBuilder.getButtonItems();
    }

    public JLabel[] getLabelItems(){
        return this.pageComponentsBuilder.getLabelItems();
    }

    public JSpinner getPageSpinner(){
        return this.pageComponentsBuilder.getPageSpinner();
    }


}
