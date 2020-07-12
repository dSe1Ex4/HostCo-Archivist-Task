package co.host.archivist.soap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.hostco.reguser.types.GetUserRequest;
import ru.hostco.reguser.types.GetUserResponse;
import ru.hostco.reguser.types.ObjectFactory;

public class UserClient extends WebServiceGatewaySupport {
    @Value("${SOAP.HostCo.Token}")
    private String TOKEN;
    @Value("${SOAP.HostCo.URL}")
    private String SoapURL;

    public GetUserResponse getUserBySnils(String snils) {
        ObjectFactory factory = new ObjectFactory();

        GetUserRequest request = factory.createGetUserRequest();
        request.setSNILS(snils);
        request.setToken("D468E929-A94E-4F16-A7D2-DB414EC53071");

        return (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        request,
                        new SoapActionCallback(SoapURL)
                );
    }
}