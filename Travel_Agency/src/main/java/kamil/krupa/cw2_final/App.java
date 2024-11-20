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
    private static GenericList<Trip> trips;
    private static String[] args;
    private static GenericList<User> users;
    

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
    
    public static void main(String[] args) throws NumberException, EmptyFieldsException, WrongDateException {
        users = new GenericList<User>();
        users.add(new User("kamil", "123", "Kamil", "Krupa", false));
        users.add(new User("maciek", "321", "Maciej", "Adminowski", true));
        
        trips = new GenericList<Trip>();
        trips.add(new Trip("Poland", "Warsaw", "Katowice", 500, "20.11-24.11.2024"));
        trips.add(new Trip("Germany", "Berlin", "Katowice", 1500, "20.11-24.11.2024"));
        trips.add(new Trip("Spain", "Madrid", "Cracow", 2000, "10.12-16.12.2024"));
        trips.add(new Trip("England", "London", "Warsaw", 1250, "20.12-27.12.2024"));
        trips.add(new Trip("Japan", "Tokyo", "Berlin", 3000, "03.01-05.01.2025"));
        trips.add(new Trip("Italy", "Rome", "Katowice", 2200, "30.01-07.02.2024"));
        
        App.args = args;
        launch();
    }

}