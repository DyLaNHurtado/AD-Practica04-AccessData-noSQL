import controller.LoginController;
import dto.LoginDTO;
import repository.RepoLogin;
import utils.ApplicationProperties;

import java.util.List;


public class App {
    public static void main(String[] args) {
        ApplicationProperties properties = new ApplicationProperties();
        System.out.println("Bienvenid@s a " +
                properties.readProperty("app.title") + " "
                + properties.readProperty("app.version") +
                " hecho por : " + properties.readProperty("app.autores") + " de " +
                properties.readProperty("app.curso"));
        Facade facade = Facade.getInstance();
        
        // Iniciamos la base de datos al estado original en cada prueba
        if (properties.readProperty("database.init").equals("true"))
            facade.initDataBase();

        //facade.testingJSON();
        facade.body();
    }
}
