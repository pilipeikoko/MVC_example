package org.bsuir.model;

import javax.swing.table.DefaultTableModel;

public class Model extends DefaultTableModel {

    public Model(){
        super(TableParameters.data, TableParameters.TABLE_HEADER);
    }
}
