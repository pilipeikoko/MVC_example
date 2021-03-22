package org.bsuir.view;

import org.bsuir.controller.RemovePatientController;
import org.bsuir.model.Model;

public class DeletePatientView {
    public DeletePatientView(Model model) {
        DeletePatientBuilder deletePatientBuilder = new DeletePatientBuilder();
        RemovePatientController removePatientController = new RemovePatientController(model, deletePatientBuilder.getDeleteButton(), deletePatientBuilder.getTextFields(), deletePatientBuilder.getLabelItems(), deletePatientBuilder.getDatePanels(), deletePatientBuilder.getDeleteByTypeComboBox());
    }
}
