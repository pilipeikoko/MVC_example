package org.example.view;

import org.example.model.FrameParameters;

import javax.swing.*;
import java.awt.*;

public class MainFramePageComponentsBuilder {
    private final JLabel[] labelItems;
    private final JButton[] buttonItems;
    private final JSpinner pageSpinner;

    public MainFramePageComponentsBuilder(){
        labelItems = new JLabel[FrameParameters.AMOUNT_OF_LABELS];
        buttonItems = new JButton[FrameParameters.AMOUNT_OF_BUTTONS];

        addJLabels();
        addJButtons();

        SpinnerModel value = new SpinnerNumberModel(10, 0, 100, 1);
        pageSpinner = new JSpinner(value);
        pageSpinner.setMaximumSize(new Dimension(30, 30));
    }

    private void addJButtons() {
        JButton firstPageButton = new JButton("First page");
        JButton lastPageButton = new JButton("Last page");
        JButton previousPageButton = new JButton();
        JButton nextPageButton = new JButton();

        previousPageButton.setIcon(new ImageIcon(FrameParameters.ICON_LOCATION + "arrow_0" + FrameParameters.ICON_EXPANSION));
        nextPageButton.setIcon(new ImageIcon(FrameParameters.ICON_LOCATION + "arrow_1" + FrameParameters.ICON_EXPANSION));

        nextPageButton.setMargin(new Insets(0, 0, 0, 0));
        previousPageButton.setMargin(new Insets(0, 0, 0, 0));

        buttonItems[0] = firstPageButton;
        buttonItems[1] = previousPageButton;
        buttonItems[2] = nextPageButton;
        buttonItems[3] = lastPageButton;
    }

    private void addJLabels() {
        JLabel chooseRecordCountLabel = new JLabel("Choose record count");
        JLabel pageCountLabel = new JLabel("Page count");
        JLabel totalRecordCounterLabel = new JLabel("Total record counter");
        JLabel pageNumberLabel = new JLabel("Page number");

        labelItems[0] = chooseRecordCountLabel;
        labelItems[1] = pageCountLabel;
        labelItems[2] = totalRecordCounterLabel;
        labelItems[3] = pageNumberLabel;
    }

    public JButton[] getButtonItems() {
        return buttonItems;
    }

    public JLabel[] getLabelItems() {
        return labelItems;
    }

    public JSpinner getPageSpinner() {
        return pageSpinner;
    }
}
