package org.bsuir.view;

import javax.swing.*;

public class Alert {

    public static void deletionAlert(int amount) {
        if (amount == 0)
            unsuccessfulDeletionAlert();
        else
            successfulDeletionAlert(amount);
    }

    private static void successfulDeletionAlert(int amount) {
        JOptionPane.showMessageDialog(null, amount + " patients was successfully removed");
    }

    private static void unsuccessfulDeletionAlert() {
        JOptionPane.showMessageDialog(null, "Nothing found");
    }

    public static void successfulAddingAlert() {
        JOptionPane.showMessageDialog(null, "successfully added");
    }

    public static void unsuccessfulAddingAlert(String reason) {
        JOptionPane.showMessageDialog(null, "Incorrect format: " + reason);
    }
}