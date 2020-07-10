package co.host.archivist.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //(Get/Set)ers
@AllArgsConstructor  //Конструктор
public class User {
    private long userId;
    private String firstName;
    private String middleName;
    private String lastName;
}
