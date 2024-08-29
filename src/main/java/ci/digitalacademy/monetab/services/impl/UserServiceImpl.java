package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import ci.digitalacademy.monetab.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //Permet de créer les constructeurs des propriétés requit
@Slf4j  //2eme manière de faire la journalisation
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);// 1ere manière de faire la journalisation

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save: {}", userDTO );
        User user = UserMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return UserMapper.fromEntity(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        log.debug("Request to update: {}", userDTO);
        return findOne(userDTO.getId_user()).map(existingUser ->{
            existingUser.setPseudo(userDTO.getPseudo());
            existingUser.setPassword(userDTO.getPassword());
            return save(userDTO);
        }).orElseThrow(() ->new IllegalArgumentException());

    }

    @Override
    public Optional<UserDTO> findOne(Long id_user) {
        log.debug("Resquest to get id: {}", id_user);
        return userRepository.findById(id_user).map(user -> {
            return UserMapper.fromEntity(user);
        });
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(user -> {
            return UserMapper.fromEntity(user);
        }).toList();
    }

    @Override
    public void delete(Long id_user) {
        log.debug("Request to update {}", id_user);
        userRepository.deleteById(id_user);
    }

    @Override
    public Optional<UserDTO> findByPseudoAndPassword(String pseudo, String password) {
        log.debug("Request to find user by pseudo: {} and password: {}", pseudo, password);
        return userRepository.findByPseudoAndPassword(pseudo, password)
                .map(UserMapper::fromEntity);
    }


}
