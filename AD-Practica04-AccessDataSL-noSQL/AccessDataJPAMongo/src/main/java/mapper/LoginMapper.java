package mapper;

import dao.Login;
import dto.LoginDTO;

public class LoginMapper extends BaseMapper<Login, LoginDTO> {
    @Override
    public Login fromDTO(LoginDTO item) {
        return new Login(item.getId(),item.getFecha(),item.getToken(),item.getIsActivo());
    }

    @Override
    public LoginDTO toDTO(Login item) {
        return LoginDTO.builder()
                .id(item.getId())
                .fecha(item.getFecha())
                .token(item.getToken())
                .isActivo(item.getActivo())
                .build();
    }
}