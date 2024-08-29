package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.services.dto.AddressDTO;


public final class AddressMapper {

    private AddressMapper(){}


        public static AddressDTO fromEntity(Address address){
        AddressDTO addressDTO = AddressDTO.builder()
                .id_addess(address.getId_addess())
                .country(address.getCountry())
                .street(address.getStreet())
                .city(address.getCity())
                .build();
            return addressDTO;
    }

    public static Address toEntity(AddressDTO addressDTO){
        Address address = Address.builder()
                .id_addess(addressDTO.getId_addess())
                .country(addressDTO.getCountry())
                .street(addressDTO.getStreet())
                .city(addressDTO.getCity())
                .build();
        return address;
    }
}
