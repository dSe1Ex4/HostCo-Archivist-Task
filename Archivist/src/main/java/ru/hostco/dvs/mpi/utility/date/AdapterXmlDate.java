package ru.hostco.dvs.mpi.utility.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdapterXmlDate
    extends XmlAdapter<String, LocalDate> {

  public LocalDate unmarshal(String value) {
    if (value == null) {
      return null;
    }
    return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
  }

  public String marshal(LocalDate value) {
    if (value == null) {
      return null;
    }
    return value.format(DateTimeFormatter.ISO_LOCAL_DATE);
  }
}
