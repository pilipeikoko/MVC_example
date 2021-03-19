package org.bsuir.view;

import javax.swing.*;

public class Alert {

    public static void successfulDeletionAlert(int amount){
        JOptionPane.showMessageDialog(null,amount+" was successfully removed");
    }

    public static void unsuccessfulDeletionAlert(){
        JOptionPane.showMessageDialog(null,"nothing found");
    }

    public static void successfulAddingAlert(){
        JOptionPane.showMessageDialog(null,"successfully added");
    }

    public static void unsuccessfulAddingAlert(String reason){
        JOptionPane.showMessageDialog(null,"Incorrect format: " + reason);
    }
}