package manager;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.NonNull;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Controlador de la base de datos NoSQL MongoDB
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class MongoDBController {

    private static MongoDBController controller;

    private String serverUrl;
    private String serverPort;
    private String dataBaseName;
    private String user;
    private String password;

    ConnectionString connectionString;
    CodecRegistry pojoCodecRegistry;
    CodecRegistry codecRegistry;
    MongoClientSettings clientSettings;

    MongoClient mongoClient;

    /**
     * Constructor privado
     */
    private MongoDBController() {
        initConfig();
    }

    /**
     * Patron Singleton
     * @return MongoDBController
     */
    public static MongoDBController getInstance() {
        if (controller == null) {
            controller = new MongoDBController();
        }
        return controller;
    }

    /**
     * Inicia la configuración para la conexión a la BD
     */
    private void initConfig() {
        serverUrl = "localhost";
        serverPort = "27017";
        dataBaseName = "mongodb";
        user = "mongoadmin";
        password = "mongopass";
        connectionString = new ConnectionString("mongodb://" + user + ":" + password + "@" + serverUrl + ":" + serverPort + "/" + dataBaseName + "?authSource=admin");
        pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
    }

    /**
     * Abre una conexión con la BD
     */
    public void open() {
        this.mongoClient = MongoClients.create(clientSettings);
    }

    /**
     * Cierra la conexión con la BD
     */
    public void close() {
        if (mongoClient != null) mongoClient.close();
    }

    /**
     * Devuelve una lista de las bases de datos de la BD
     * @return Optional<List<Document>>
     */
    public Optional<List<Document>> getDataBases() {
        return Optional.of(mongoClient.listDatabases().into(new ArrayList<>()));
    }

    /**
     * Elimina una base de datos
     * @param dataBaseName Nombre de la Base de Datos
     */
    public void removeDataBase(@NonNull String dataBaseName) {
        MongoDatabase dataBase = mongoClient.getDatabase(dataBaseName);
        dataBase.drop();// Si queremos borrar toda la base de datos
    }

    /**
     * Elimina una colleción de una base de datos
     * @param dataBaseName Nombre de la Base de Datos
     * @param collectionName Nombre de la Colección
     */
    public void removeCollection(@NonNull String dataBaseName, @NonNull String collectionName) {
        MongoDatabase dataBase = mongoClient.getDatabase(dataBaseName);
        dataBase.getCollection(collectionName).drop();
    }

    /**
     * Devuelve una Colección de la BD
     * @param dataBaseName
     * @param collectionName
     * @param aClass
     * @param <TDocument>
     * @return TDocument
     */
    public <TDocument> MongoCollection<TDocument> getCollection(@NonNull String dataBaseName,
                                                                @NonNull String collectionName,
                                                                @NonNull java.lang.Class<TDocument> aClass) {
        MongoDatabase dataBase = mongoClient.getDatabase(dataBaseName);
        return dataBase.getCollection(collectionName, aClass);
    }
}
