package controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.Proyecto;
import dto.ProgramadorDTO;
import dto.ProyectoDTO;
import repository.RepoProgramador;
import service.ProgramadorService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.sql.SQLException;

public class ProgramadorController {
    private static ProgramadorController controller = null;
    private Marshaller marshaller;

    // Mi Servicio unido al repositorio
    private final ProgramadorService programadorService;

    // Implementamos nuestro Singleton para el controlador
    private ProgramadorController(ProgramadorService programadorService) {
        this.programadorService = programadorService;
    }

    public static ProgramadorController getInstance() {
        if (controller == null) {
            controller = new ProgramadorController(new ProgramadorService(new RepoProgramador()));
        }
        return controller;
    }

    public String getAllProgramadorsJSON() {
        try {
            // Vamos a devolver el JSON de los programadors
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorService.getAllProgramadores());
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getAll: " + e.getMessage());
            return "Error ProgramadorController en getAll: " + e.getMessage();
        }
    }

    public String getProgramadorByIdJSON(String id) {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorService.getProgramadorById(id));
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getProgramadorById: " + e.getMessage());
            return "Error ProgramadorController en getProgramadorById: " + e.getMessage();
        }
    }

    public String postProgramadorJSON(ProgramadorDTO programadorDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorService.postProgramador(programadorDTO));
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en postProgramador: " + e.getMessage());
            return "Error ProgramadorController en postProgramador: " + e.getMessage();
        }
    }

    public String updateProgramadorJSON(ProgramadorDTO comitDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorService.updateProgramador(comitDTO));
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en updateProgramador: " + e.getMessage());
            return "Error ProgramadorController en updateProgramador: " + e.getMessage();
        }
    }

    public String deleteProgramadorJSON(ProgramadorDTO programadorDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorService.deleteProgramador(programadorDTO));
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en deleteProgramador: " + e.getMessage());
            return "Error ProgramadorController en deleteProgramador: " + e.getMessage();
        }
    }

    public void getAllProgramadoresFullInfo() {
        try {
            programadorService.getAllProgramadoresFullInfo();
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getAllProgramadoresInfo: " + e.getMessage());
        }
    }

    //XML
    public void getAllProgramadoresXML() {
        try {
            // Vamos a devolver el XML de los commits
            JAXBContext jaxbContext = JAXBContext.newInstance(ProgramadorDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(programadorService.getAllProgramadores(), System.out);
        } catch (SQLException | JAXBException e) {
            System.err.println("Error ProgramadorController en getAllProgramadoresXML: " + e.getMessage());
        }
    }

    public void getProgramadorByIdXML(String id) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProgramadorDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(programadorService.getProgramadorById(id), System.out);
        } catch (SQLException | JAXBException e) {
            System.err.println("Error ProgramadorController en getProgramadorByIdXML: " + e.getMessage());
        }
    }

    public void postProgramadorXML(ProgramadorDTO programadorDTO) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProgramadorDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(programadorService.postProgramador(programadorDTO), System.out);
        } catch (SQLException | JAXBException e) {
            System.err.println("Error ProgramadorController en postProgramadorXML: " + e.getMessage());
        }
    }

    public void updateProgramadorXML(ProgramadorDTO programadorDTO) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProgramadorDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(programadorService.updateProgramador(programadorDTO), System.out);
        } catch (SQLException | JAXBException e) {
            System.err.println("Error ProgramadorController en updateProgramadorXML: " + e.getMessage());
        }
    }
    /**
     * Printea  el save de programador en XML
     * @author Dylan Hurtado
     * @version 11/12/2021 - 1.0
     */
    public void deleteProgramadorXML(ProgramadorDTO programadorDTO) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProgramadorDTO.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(programadorService.deleteProgramador(programadorDTO), System.out);
        } catch (SQLException | JAXBException e) {
            System.err.println("Error ProgramadorController en deleteProgramadorXML: " + e.getMessage());
        }
    }


}