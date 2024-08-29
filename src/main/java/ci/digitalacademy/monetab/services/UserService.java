package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    Optional<UserDTO> findOne(Long id_user);

    List<UserDTO> findAll();

    void delete(Long id_user);

    Optional<UserDTO> findByPseudoAndPassword(String pseudo, String password);

}
