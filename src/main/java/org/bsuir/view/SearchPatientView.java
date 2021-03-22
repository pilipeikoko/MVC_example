package org.bsuir.view;

import org.bsuir.controller.SearchPatientController;
import org.bsuir.model.Model;

public class SearchPatientView {

    public SearchPatientView(Model model){
        SearchPatientBuilder searchPatientBuilder = new SearchPatientBuilder(model);
        SearchPatientController searchPatientController = new SearchPatientController(model, searchPatientBuilder.getDeleteButton(), searchPatientBuilder.getTextFields(), searchPatientBuilder.getLabelItems(), searchPatientBuilder.getDatePanels(), searchPatientBuilder.getSearchByTypeComboBox(), searchPatientBuilder.getTable());
    }

}
