package guru.springmk.endpoint;

import com.myschemasoap.spring_boot_soap.GetUserRequest;
import com.myschemasoap.spring_boot_soap.GetUserResponse;
import guru.springmk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private UserService userServices;

    @Autowired
    public UserEndpoint(UserService userServices) {
        this.userServices = userServices;
    }

    private static final String NAMESPACE_URI = "http://myschemasoap.com/spring-boot-soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request ){
        GetUserResponse response = new GetUserResponse();
        response.setUser(userServices.getUsers(request.getName()));
        return response;
    }
}
