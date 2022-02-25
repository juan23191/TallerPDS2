package co.com.poli.tallerpds2.serviceuser.entityDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO implements Serializable {

        private final Long serializableversionUID =1L;
        private Long id;
        private String name;
        private String lastname;

}
