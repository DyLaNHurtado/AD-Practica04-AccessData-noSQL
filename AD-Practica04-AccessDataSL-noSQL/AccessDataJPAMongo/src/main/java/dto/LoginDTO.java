package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private long id;
    private Timestamp fecha;
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
