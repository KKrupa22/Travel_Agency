package kamil.krupa.cw2_final;

import Controller.LoginController;
import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;
    private static TripList trips;
    private static String[] args;
    private static Users users;
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/fxml/Login.fxml"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void setRoot(Parent root) throws IOException {
        scene.setRoot(root);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        fxmlLoader.setControllerFactory(p -> {return new LoginController(users, trips, args);});
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        users = new Users();
        users.add(new User("kamil", "123", "Kamil", "Krupa", false));
        users.add(new User("maciek", "321", "Maciej", "Adminowski", true));
        trips = new TripList();
        App.args = args;
        launch();
    }

}