/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kamil.krupa.cw2_final.App;

/**
 *
 * @author Kamil
 */
public class AddTripController {
    
    @FXML private TextField txtCountry;
    @FXML private TextField txtCity;
    @FXML private TextField txtDepCity;
    @FXML private TextField txtPrice;
    @FXML private TextField txtDate;
    @FXML private Button add;
    @FXML private Button back;
    private TripList trips;
    private String[] args;
    private String country;
    private String city;
    private String depCity;
    private String price;
    private String date;
    
    /**
     * AddTripController constructor is used to init class
     * @param trips - list of trips
     */
    
    public AddTripController(TripList trips){
        this.trips = trips;
    }
    
    /**
     * back method is used to back to menu
     * @param event
     * @throws IOException 
     */
    
    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/Menu.fxml"));
        loader.setControllerFactory(p -> {return new MenuController(trips, args);});
        Parent root = loader.load();
        App.setRoot(root);
    }
    
    /**
     * insertButton method is used to save data from user to the trip list
     * @param event 
     */
    
    @FXML
    public void insertButton(ActionEvent event) {
        try {
            country = txtCountry.getText();
            city = txtCity.getText();
            depCity = txtDepCity.getText();
            price = txtPrice.getText();
            date = txtDate.getText();
            
            if(country.isEmpty() || city.isEmpty() || depCity.isEmpty() || date.isEmpty() || price.isEmpty()) {
                throw new EmptyFieldsException("Fields cannot be null.");
            }
            
            Trip newTrip = new Trip(country, city, depCity, Double.parseDouble(price), date);
            trips.add(newTrip);
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Added succesfully");
            alert.setContentText("Trip added succesfully.");
            alert.showAndWait();
            
            txtCountry.clear();
            txtCity.clear();
            txtDepCity.clear();
            txtPrice.clear();
            txtDate.clear();
            
        } catch (EmptyFieldsException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty fields");
            alert.setHeaderText("Fields cannot be empty");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Price");
            alert.setContentText("Please enter a valid number for the price.");
            alert.showAndWait();
            return;
        } catch (NumberException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Invalid Price");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }
    }
}
