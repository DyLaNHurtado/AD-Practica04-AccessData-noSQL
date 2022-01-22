package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import dao.*;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
@Builder

@XmlRootElement(name="programador")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProgramadorDTO {
    private String idProgramador;
    private String nombre;
    private LocalDate fechaAlta;
    private Departamento departamento;
    private List<Proyecto> proyectosParticipa;
    private List<String> tecnologias;
    private Double salario;
    private boolean jefeDepartamento;
    private boolean jefeProyecto;

    // From/To JSON IMPLEMENTAR METODOS CUANDO PASEMOS A JSON
    public static ProgramadorDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, ProgramadorDTO.class);
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
