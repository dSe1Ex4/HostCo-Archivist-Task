package co.host.archivist.soap.dto;

import lombok.Data;
import ru.hostco.reguser.types.DocumentsType;
import ru.hostco.reguser.types.GetUserResponse;
import ru.hostco.reguser.types.LoginStrictType;
import java.time.LocalDate;

@Data
public class UserSoap {
    protected String snils;
    protected String lastname;
    protected String firstname;
    protected String middlename;
    protected LocalDate birthDate;
    protected String phone;
    protected String email;
    protected Integer gender;
    protected String policyNumber;
    protected String birthPlace;
    protected DocumentsType documents;

    public UserSoap(GetUserResponse userResponse) {
        final LoginStrictType login = userResponse.getLogin();
        this.snils = login.getSNILS();
        this.lastname = login.getLastname();
        this.firstname = login.getFirstname();
        this.middlename = login.getMiddlename();
        this.birthDate = login.getBirthDate();
        this.phone = login.getPhone();
        this.email = login.getEmail();
        this.gender = login.getGender();
        this.policyNumber = login.getPolicyNumber();
        this.birthPlace = login.getBirthPlace();
        this.documents = login.getDocuments();
    }
}
