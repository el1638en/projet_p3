package com.openclassrooms.bibliotheque.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTypeAdapter extends XmlAdapter<XMLGregorianCalendar, Date> {
    private final DatatypeFactory datatypeFactory;

    public DateTypeAdapter() throws DatatypeConfigurationException {
        this.datatypeFactory = DatatypeFactory.newInstance();
    }

    @Override
    public Date unmarshal(XMLGregorianCalendar inputDate) throws Exception {
        return inputDate.toGregorianCalendar().getTime();
    }

    @Override
    public XMLGregorianCalendar marshal(Date date) throws Exception {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        return datatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }
}