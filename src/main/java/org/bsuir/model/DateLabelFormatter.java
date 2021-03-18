package org.bsuir.model;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private final static String DATE_PATTERN = "yyyy-MM-dd";
    private final static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_PATTERN);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return DATE_FORMATTER.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar calendar = (Calendar) value;
            return DATE_FORMATTER.format(calendar.getTime());
        }

        return "";
    }

}