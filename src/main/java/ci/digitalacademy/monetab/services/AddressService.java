package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.NoteFile;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    AddressDTO save(AddressDTO addressDTO);

    AddressDTO update(AddressDTO addressDTO);

    Optional<AddressDTO> findOne(Long id_address);

    List<AddressDTO> findAll();

    void delete(Long id_address);
}
