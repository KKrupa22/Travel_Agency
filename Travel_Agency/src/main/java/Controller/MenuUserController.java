/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import kamil.krupa.cw2_final.*;

/**
 * MenuController class which is controlling menu of application.
 * @author Kamil
 */

public class MenuUserController {
    
    @FXML private Button available;
    @FXML private Button check;
    @FXML private Button exit;
    private TripList trips;
    private String[] args;
    
    
    /**
     * MenuController constructor which is given trip and arguments.
     * @param trips - list of our trips
     * @param args - argument passed from console
     */
   
    public MenuUserController (TripList trips, String[] args) {
        this.trips = trips;
        this.args = args;
    }
    
    /**
     * availableTrip is method to open new availableTrip window.
     * @param event
     * @throws IOException 
     */
    
    @FXML
    private void availableTrip(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/AvailableUser.fxml"));
        loader.setControllerFactory(p -> {return new AvailableUserController(trips);});
        Parent root = loader.load();
        App.setRoot(root);
    }
    
    /**
     * checkTrip method is used to open new checkTrip window
     * @param event
     * @throws IOException 
     */
    
    @FXML
    private void checkTrip(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/Check.fxml"));
        loader.setControllerFactory(p -> {
            try {
                return new CheckController(trips, args);
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        });
        Parent root = loader.load();
        App.setRoot(root);
    }
    
    /**
     * exit method is used to exit app.
     * @param event
     * @throws IOException 
     */
    
    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }
    
}
