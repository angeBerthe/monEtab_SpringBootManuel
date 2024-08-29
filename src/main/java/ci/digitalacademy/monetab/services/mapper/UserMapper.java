package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.dto.UserDTO;

public final class UserMapper {

    private UserMapper(){}

    public static UserDTO fromEntity(User user){
        UserDTO userDTO = UserDTO.builder()
                .id_user(user.getId_user())
                .pseudo(user.getPseudo())
                .password(user.getPassword())
                .creationDate(user.getCreationDate())
                .build();
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO){
        User user = User.builder()
                .id_user(userDTO.getId_user())
                .pseudo(userDTO.getPseudo())
                .password(userDTO.getPassword())
                .creationDate(userDTO.getCreationDate())
                .build();
        return user;
    }
}
