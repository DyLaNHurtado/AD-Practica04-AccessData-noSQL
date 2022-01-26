package mapper;

import dao.Login;
import dto.LoginDTO;

public class LoginMapper extends BaseMapper<Login, LoginDTO> {
    @Override
    public Login fromDTO(LoginDTO item) {
        return new Login(item.getId(),item.getCorreo(),
                item.getPassword(),item.getFecha());
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