package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import dao.Programador;
import dao.Proyecto;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@Builder

@XmlRootElement(name="tecnologia")
@XmlAccessorType(XmlAccessType.FIELD)
public class TecnologiaDTO {
    private String idTecnologia;
    private String nombre;
    private List<Programador> programadores;
    private List<Proyecto> proyectos;

    // From/To JSON IMPLEMENTAR METODOS CUANDO PASEMOS A JSON
    public static TecnologiaDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, TecnologiaDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() // Quitamos los campos que no están expuestos @expose y evitamos lo anterior
                .setPrettyPrinting()
                .create();
        return prettyGson.toJson(this);
    }
}
