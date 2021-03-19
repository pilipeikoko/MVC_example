package org.bsuir.view;

import org.bsuir.controller.AddPatientController;
import org.bsuir.model.Model;

public class AddPatientView {

    public AddPatientView(Model model){
        AddPatientBuilder addPatientBuilder = new AddPatientBuilder();
        AddPatientController addPatientController = new AddPatientController(model,addPatientBuilder.getTextFields(), addPatientBuilder.getDatePanels(), addPatientBuilder.getEnterButton());
    }
}
