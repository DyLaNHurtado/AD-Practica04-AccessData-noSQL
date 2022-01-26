package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import dao.JefeDepartamento;
import dao.Programador;
import dao.Proyecto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@XmlRootElement(name = "departamento")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartamentoDTO {
    private long id;
    private String nombre;
    private JefeDepartamento jefeDepartamento;
    private List<Proyecto> proyFinalizados;
    private List<Proyecto> proyDesarrollo;
    private Double presupuesto;
    private Double presupuestoAnual;
    private List<Programador> trabajadores;


    // From/To JSON IMPLEMENTAR METODOS CUANDO PASEMOS A JSON
    public static DepartamentoDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, DepartamentoDTO.class);
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
