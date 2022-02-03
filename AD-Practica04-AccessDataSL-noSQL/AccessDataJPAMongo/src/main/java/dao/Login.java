package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DAO de Login
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    private long id;
    private LocalDate fecha;
    private UUID token;
    private Boolean isActivo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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
