package co.host.archivist.soap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.hostco.reguser.types.GetUserRequest;
import ru.hostco.reguser.types.GetUserResponse;
import ru.hostco.reguser.types.ObjectFactory;

/**
 * SOAP Клиент для запроса /getUser
 */
public class UserClient extends WebServiceGatewaySupport {
    @Value("${app.SOAP.Token}")
    private String TOKEN;
    @Value("${app.SOAP.BaseReqURL}")
    private String SOAP_URL;

    public GetUserResponse getUserBySnils(String snils) {
        ObjectFactory factory = new ObjectFactory();

        GetUserRequest request = factory.createGetUserRequest();
        request.setSNILS(snils);
        request.setToken(TOKEN);

        final String GET_REQ = "/getUser";
        return (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        request,
                        new SoapActionCallback(SOAP_URL+GET_REQ)
                );
    }
}