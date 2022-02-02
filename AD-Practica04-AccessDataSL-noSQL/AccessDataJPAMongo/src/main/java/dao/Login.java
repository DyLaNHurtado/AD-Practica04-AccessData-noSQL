package dao;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
public class Login {

    private long id;
    private Timestamp fecha;
    private UUID token;
    private Boolean isActivo;

    public Login() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Boolean getActivo() {
        return isActivo;
    }

    public void setActivo(Boolean activo) {
        isActivo = activo;
    }
}
