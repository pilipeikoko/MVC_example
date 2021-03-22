package org.bsuir.view;

import org.bsuir.controller.DeletePatientController;
import org.bsuir.model.Model;

public class DeletePatientView {
    public DeletePatientView(Model model) {
        DeletePatientBuilder deletePatientBuilder = new DeletePatientBuilder();
        new DeletePatientController(model, deletePatientBuilder.getDeleteButton(), deletePatientBuilder.getTextFields(), deletePatientBuilder.getLabelItems(), deletePatientBuilder.getDatePanels(), deletePatientBuilder.getDeleteByTypeComboBox(),deletePatientBuilder.getCards());
    }
}
