package org.bsuir.view;

import org.bsuir.controller.MainFrameController;
import org.bsuir.model.Model;


public class MainFrameView {

    public MainFrameView() {
        Model model = new Model();
        MainFrameBuilder frameBuilder = new MainFrameBuilder(model);

        new MainFrameController(model,frameBuilder.getMenuBarItems(),frameBuilder.getButtonItems(),frameBuilder.getLabelItems(), frameBuilder.getPageSpinner(), frameBuilder.getTable());

    }

}