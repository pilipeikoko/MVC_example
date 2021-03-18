package org.bsuir.view;

import org.bsuir.model.Model;

public class SearchPatientView {

    public SearchPatientView(Model model){
        new SearchPatientBuilder(model);
    }

}
