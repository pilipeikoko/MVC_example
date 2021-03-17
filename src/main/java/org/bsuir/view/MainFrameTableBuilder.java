package org.bsuir.view;

import org.bsuir.model.Model;

import javax.swing.*;
import java.awt.*;

public class MainFrameTableBuilder {
    private final JTable table;
    private final JScrollPane tableScrollPane;

    public MainFrameTableBuilder(Model model){
        this.table = new JTable();
        this.tableScrollPane = new JScrollPane(table);

        setTableInfo(model);
        setScrollPane();
    }

    private void setScrollPane() {
        tableScrollPane.setPreferredSize(new Dimension(700, 200));
    }

    private void setTableInfo(Model model) {
        table.setModel(model);
        table.getTableHeader().setFont(new Font("Segou UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(32, 136, 203));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.setGridColor(new Color(100, 100, 100));
        table.setPreferredSize(new Dimension(700, 200));
    }

    public JTable getTable() {
        return table;
    }

    public JScrollPane getTableScrollPane() {
        return tableScrollPane;
    }
}
