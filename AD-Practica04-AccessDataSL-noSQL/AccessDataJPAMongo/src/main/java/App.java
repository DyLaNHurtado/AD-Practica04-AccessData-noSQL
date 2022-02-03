import utils.ApplicationProperties;

/**
 * Contiene el main del programa
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class App {
    public static void main(String[] args) {
        ApplicationProperties properties = new ApplicationProperties();
        System.out.println("Bienvenid@s a " +
                properties.readProperty("app.title") + " "
                + properties.readProperty("app.version") +
                " hecho por : " + properties.readProperty("app.autores") + " de " +
                properties.readProperty("app.curso"));
        Facade facade = Facade.getInstance();

        if (properties.readProperty("database.init").equals("true"))
            facade.initDataBase();

        //facade.testingJSON();
        facade.body();
    }
}
