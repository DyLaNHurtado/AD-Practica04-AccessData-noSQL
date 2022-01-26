package dao;

import lombok.Builder;

import java.sql.Timestamp;
@Builder
public class Login {

    private long id;
    private String correo;
    private String password;
    private Timestamp fecha;

    public Login() {
    }

    public Login(String correo, String password, Timestamp fecha) {
        this.correo = correo;
        this.password = password;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
