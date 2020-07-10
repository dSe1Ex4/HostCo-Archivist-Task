package ru.hostco.dvs.mpi.utility.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdapterXmlDateTime
    extends XmlAdapter<String, LocalDateTime> {

  public LocalDateTime unmarshal(String value) {
    if (value == null) {
      return null;
    }
    return LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  public String marshal(LocalDateTime value) {
    if (value == null) {
      return null;
    }
    return value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }
}
