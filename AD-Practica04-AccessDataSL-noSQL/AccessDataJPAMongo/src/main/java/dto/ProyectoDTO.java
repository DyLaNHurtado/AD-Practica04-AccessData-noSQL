package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.Departamento;
import dao.JefeProyecto;
import dao.Programador;
import dao.Repositorio;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder

@XmlRootElement(name="proyecto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProyectoDTO {
    private long id;
    private String nombre;
    private Double presupuesto;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private List<String> tecnologias = new ArrayList<>();
    private JefeProyecto jefe;
    private Departamento departamento;
    private Repositorio repositorio;
    private List<Programador> programadores = new ArrayList<>();
    // From/To JSON IMPLEMENTAR METODOS CUANDO PASEMOS A JSON
    public static ProyectoDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, ProyectoDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() // Quitamos los campos que no están expuestos @expose y evitamos lo anterior
                .setPrettyPrinting()
                .create();
        // Otra manera de quitar un campo determinado para imprimir
        // prettyGson.toJsonTree(this).getAsJsonObject().remove("password");
        return prettyGson.toJson(this);
    }
}
