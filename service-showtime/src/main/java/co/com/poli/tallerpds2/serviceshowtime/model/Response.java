package co.com.poli.tallerpds2.serviceshowtime.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Integer code;
    private Object data;
}
