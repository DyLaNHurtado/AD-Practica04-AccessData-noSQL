package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO de Login
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private long id;
    private LocalDate fecha;
    private UUID token;
    private Boolean isActivo;

    @Override
    public String toString(){
        return "Login{id="+this.id
                +", fecha="+this.fecha
                +", token="+this.token
                +", isActivo="+this.isActivo
                +"}";
    }
}
