package co.host.archivist.soap;

import co.host.archivist.soap.dto.UserSoap;
import co.host.archivist.soap.exceptions.SoapResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hostco.reguser.types.GetUserResponse;

import java.util.Objects;

@Component
public class SoapModelManager {
    private static UserClient userClient;

    public static UserSoap getUserClientBySnils(String snils){
        final GetUserResponse response = userClient.getUserBySnils(snils);
        if ( Objects.nonNull(response.getError()) ){
            throw new SoapResponseException(response.getError().getErrorText());
        }

        return new UserSoap(response);
    }

    @Autowired
    private void setUserClient(UserClient userClient) {
        SoapModelManager.userClient = userClient;
    }
}
