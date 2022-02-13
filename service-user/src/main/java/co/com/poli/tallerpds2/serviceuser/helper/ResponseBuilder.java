package co.com.poli.tallerpds2.serviceuser.helper;

import co.com.poli.tallerpds2.serviceuser.model.Response;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@Component
public class ResponseBuilder {

    public Response success(){
        return Response.builder()
                .code(OK.value())
                .data(OK.value())
                .build();
    }
    public Response success(Object data){
        return Response.builder()
                .code(OK.value())
                .data(data)
                .build();
    }
    public Response failed(Object data){
        return Response.builder()
                .code(INTERNAL_SERVER_ERROR.value())
                .data(data)
                .build();
    }

}
