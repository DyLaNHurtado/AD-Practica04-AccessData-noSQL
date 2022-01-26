package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.JefeProyectoDTO;
import repository.RepoJefeProyecto;
import service.JefeProyectoService;

import java.sql.SQLException;

public class JefeProyectoController {
    private static JefeProyectoController controller;
    private final JefeProyectoService service;
    private JefeProyectoController(JefeProyectoService service){
        this.service=service;
    }
    public JefeProyectoController getInstance(){
        if(controller==null){
            controller=new JefeProyectoController(new JefeProyectoService(new RepoJefeProyecto()));
        }
        return controller;
    }
    /**
     * Printea  todos los jefes de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getAllJefeProyecto() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.getAllJefeProyecto());
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en getAll: " + e.getMessage());
            return "Error JefeProyectoController en getAll: " + e.getMessage();
        }
    }
    /**
     * Printea jefe de proyecto por id en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String getJefeProyectoByIdJSON(Long id) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.getJefeProyectoById(id));
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en getJefeProyectoById: " + e.getMessage());
            return "Error JefeProyectoController en getJefeProyectoById: " + e.getMessage();
        }
    }
    /**
     * Printea  el save de jefe de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String postJefeProyecto(JefeProyectoDTO jefeProyectoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.postJefeProyecto(jefeProyectoDTO));
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en postJefeProyecto: " + e.getMessage());
            return "Error JefeProyectoController en postJefeProyecto: " + e.getMessage();
        }
    }
    /**
     * Printea  el update de jefe de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String updateJefeProyecto(JefeProyectoDTO jefeProyectoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.updateJefeProyecto(jefeProyectoDTO));
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en updateJefeProyecto: " + e.getMessage());
            return "Error JefeProyectoController en updateJefeProyecto: " + e.getMessage();
        }
    }
    /**
     * Printea  el delete de jefe de proyecto en JSON
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public String deleteJefeProyecto(JefeProyectoDTO jefeProyectoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(service.deleteJefeProyecto(jefeProyectoDTO));
        } catch (SQLException e) {
            System.err.println("Error JefeProyectoController en deleteJefeProyecto: " + e.getMessage());
            return "Error JefeProyectoController en deleteJefeProyecto: " + e.getMessage();
        }
    }
}
