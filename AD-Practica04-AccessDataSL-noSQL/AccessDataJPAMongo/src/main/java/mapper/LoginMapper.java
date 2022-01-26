package mapper;

import dao.Login;
import dto.LoginDTO;

public class LoginMapper extends BaseMapper<Login, LoginDTO> {
    @Override
    public Login fromDTO(LoginDTO item) {
        return Login.builder()
                .id(item.getId())
                .correo(item.getCorreo())
                .password(item.getPassword())
                .fecha(item.getFecha())
                .build();
    }

    @Override
    public LoginDTO toDTO(Login item) {
        return LoginDTO.builder()
                .id(item.getId())
                .correo(item.getCorreo())
                .password(item.getPassword())
                .fecha(item.getFecha())
                .build();
    }
}