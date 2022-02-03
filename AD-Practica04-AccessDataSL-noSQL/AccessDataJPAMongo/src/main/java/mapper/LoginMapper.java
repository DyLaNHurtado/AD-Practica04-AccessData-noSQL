package mapper;

import dao.Login;
import dto.LoginDTO;

/**
 * Mapper de Login
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class LoginMapper extends BaseMapper<Login, LoginDTO> {

    /**
     * Devuelve un Login a partir de un LoginDTO
     * @param item LoginDTO
     * @return Login
     */
    @Override
    public Login fromDTO(LoginDTO item) {
        return new Login(item.getId(),item.getFecha(),item.getToken(),item.getIsActivo());
    }

    /**
     * Devuelve un LoginDTO a partir de un Login
     * @param item Login
     * @return LoginDTO
     */
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