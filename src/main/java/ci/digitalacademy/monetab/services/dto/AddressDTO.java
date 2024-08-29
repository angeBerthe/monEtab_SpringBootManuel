package ci.digitalacademy.monetab.services.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDTO {

    private Long id_addess;

    private String country;

    private String city;

    private String street;


}
