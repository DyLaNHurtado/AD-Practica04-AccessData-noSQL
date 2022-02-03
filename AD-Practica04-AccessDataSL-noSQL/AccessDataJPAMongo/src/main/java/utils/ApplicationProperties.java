package utils;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manejo del archivo application properties
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class ApplicationProperties {
    private final Properties properties;

    /**
     * Constructor
     */
    public ApplicationProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));

        } catch (IOException ex) {
            System.err.println("IOException Ocurrido al leer el fichero de propiedades: " + ex.getMessage());
            Logger.getLogger(getClass().getName()).log(Level.ALL, "IOException Ocurrido al leer el fichero de propiedades: " + ex.getMessage());
        }
    }

    /**
     * Lectura del fichero properties
     * @param keyName clave de la propiedad
     * @return String valor de la propiedad
     */
    public String readProperty(String keyName) {
        Logger.getLogger(getClass().getName()).log(Level.INFO, "Leyendo propiedad " + keyName);
        return properties.getProperty(keyName, "No existe esa clave en el fichero de propiedades");
    }
}
