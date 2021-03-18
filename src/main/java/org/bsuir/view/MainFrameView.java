package org.bsuir.view;

import org.bsuir.model.Model;

public class MainFrameView {

    public MainFrameView() {
        MainFrameBuilder frameBuilder = new MainFrameBuilder(new Model());

        new AddPatientView();
        new DeletePatientView();
        new SearchPatientView(new Model());
    }

}