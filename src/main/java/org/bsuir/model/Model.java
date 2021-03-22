package org.bsuir.model;

import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class Model extends DefaultTableModel {

    public Model() {

        super(TableParameters.data, TableParameters.TABLE_HEADER);
    }

    public void addPatient(Patient patient) {

        addRow(parsePatient(patient));
        System.out.println("Added patient");
    }


    /**
     * @param fullName surname of the patient to remove
     * @param address  address of the patient to remove
     * @return amount of removed patients
     */
    public int deleteByFullNameOrAddress(String fullName, String address) {

        int counter = 0;

        for (int i = 0; i < getRowCount(); ++i) {
            if (getValueAt(i, 1).equals(address)
                    || getValueAt(i, 0).equals(fullName)) {

                ++counter;
                removeRow(i--);
            }
        }
        System.out.println("Removed " + counter + "patients");

        return counter;
    }

    /**
     * @param birthday the date to remove patients
     * @return amount of deleted patients
     */
    public int deleteByBirthday(Date birthday) {
        int counter = 0;
        String parsedBirthday = parseDate(birthday);

        for (int i = 0; i < getRowCount(); ++i) {

            if (getValueAt(i, 2).equals(parsedBirthday)) {

                ++counter;
                removeRow(i--);
            }
        }
        System.out.println("Removed " + counter + "patients");

        return counter;
    }

    private Object[] parsePatient(Patient patient) {

        Object[] objects = new Object[6];
        objects[0] = patient.getFullName();
        objects[1] = patient.getPlaceOfResidence();
        objects[2] = parseDate(patient.getBirthday());
        objects[3] = parseDate(patient.getDateOfReceipt());
        objects[4] = patient.getDoctorsFullName();
        objects[5] = patient.getConclusion();
        return objects;
    }

    private String parseDate(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return new DateLabelFormatter().valueToString(calendar);
    }

    public int deleteByDoctorsFullNameOrDateReceipt(String doctorsFullName, Date dateOfReceipt) {
        int counter = 0;
        String parsedDateOfReceipt = parseDate(dateOfReceipt);

        for (int i = 0; i < getRowCount(); ++i) {

            if (getValueAt(i, 3).equals(parsedDateOfReceipt)
                    || getValueAt(i, 4).equals(doctorsFullName)) {

                ++counter;
                removeRow(i--);
            }
        }
        System.out.println("Deleted " + counter + " patients");

        return counter;

    }

    public Model createSubModelByFullNameAndAddress(String fullName, String address) {
        Model model = new Model();

        //todo remove it
        while (model.getRowCount() != 0)
            model.removeRow(0);

        for (int i = 0; i < getRowCount(); ++i) {
            if (getValueAt(i, 1).equals(address)
                    || getValueAt(i, 0).equals(fullName)) {

                Vector<Vector> tableData = getDataVector();

                Vector patientData = tableData.elementAt(i);

                model.addRow(patientData.toArray());
            }
        }
        return model;
    }

    public Model createSubModelByBirthday(Date birthday) {
        Model model = new Model();

        //todo remove it
        while (model.getRowCount() != 0)
            model.removeRow(0);


        String parsedBirthday = parseDate(birthday);

        for (int i = 0; i < getRowCount(); ++i) {

            if (getValueAt(i, 2).equals(parsedBirthday)) {
                //todo fix trash finding
                Vector<Vector> tableData = getDataVector();

                Vector patientData = tableData.elementAt(i);

                model.addRow(patientData.toArray());

            }
        }
        return model;
    }

    public Model createSubModelByDoctorsFullNameOrDateReceipt(String doctorsFullName, Date dateOfReceipt) {

        Model model = new Model();

        //todo remove it
        while (model.getRowCount() != 0)
            model.removeRow(0);

        String parsedDateOfReceipt = parseDate(dateOfReceipt);

        for (int i = 0; i < getRowCount(); ++i) {

            if (getValueAt(i, 3).equals(parsedDateOfReceipt)
                    || getValueAt(i, 4).equals(doctorsFullName)) {

                Vector<Vector> tableData = getDataVector();

                Vector patientData = tableData.elementAt(i);

                model.addRow(patientData.toArray());

            }
        }
        return model;
    }
}
