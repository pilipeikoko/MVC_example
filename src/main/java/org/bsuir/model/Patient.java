package org.bsuir.model;

import java.util.Date;

public class Patient {
    private final String fullName;
    private final String placeOfResidence;
    private final Date birthday;
    private final Date dateOfReceipt;
    private final String doctorsFullName;
    private final String conclusion;

    public Patient(String fullName, String placeOfResidence,Date birthday,Date dateOfReceipt,String doctorsFullName,String conclusion){
        this.fullName = fullName;
        this.placeOfResidence = placeOfResidence;
        this.birthday = birthday;
        this.dateOfReceipt = dateOfReceipt;
        this.doctorsFullName = doctorsFullName;
        this.conclusion = conclusion;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    public String getConclusion() {
        return conclusion;
    }

    public String getDoctorsFullName() {
        return doctorsFullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }
}
