package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private long id;
    private String correo;
    private String password;
    private Timestamp fecha;

    @Override
    public String toString(){
        return "Login{id="+this.id
                +", nombre="+this.correo
                +", password="+this.password
                +", fecha="+this.fecha
                +"}";
    }
}
