/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import kamil.krupa.cw2_final.*;

/**
 * FXML Controller class
 *
 * @author Kamil Krupa
 */
public class AvailableController implements Initializable {
    
    @FXML private Button back;
    @FXML private TableView availableTab;
    @FXML private TableColumn<Trip, String> countryCol;
    @FXML private TableColumn<Trip, String> cityCol;
    @FXML private TableColumn<Trip, String> depCityCol;
    @FXML private TableColumn<Trip, Double> priceCol;
    @FXML private TableColumn<Trip, String> dateCol;
    
    private TripList trips;
    private String[] args;
    
    /**
     * AvailableController constructor is used to init our class
     * @param trips 
     */
    
    public AvailableController (TripList trips) {
        this.trips = trips;
    }
    
    /**
     * back method is used to back to the menu
     * @param event
     * @throws IOException 
     */
    
    @FXML
    public void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/Menu.fxml"));
        loader.setControllerFactory(p -> {return new MenuController(trips, args);});
        Parent root = loader.load();
        App.setRoot(root);
    }

    /**
     * initialize method is used to fill table with data
     * @param url
     * @param rb 
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        availableTab.setItems(trips.getData());
        availableTab.setEditable(true);
        
        countryCol.setCellValueFactory(new PropertyValueFactory<Trip, String>("country"));
        countryCol.setCellFactory(TextFieldTableCell.forTableColumn());	
        countryCol.setOnEditCommit(t -> {
            (t.getTableView().getItems().get(t.getTablePosition().getRow())).setCountry(t.getNewValue());
        });
        
        cityCol.setCellValueFactory(new PropertyValueFactory<Trip, String>("place"));
        cityCol.setCellFactory(TextFieldTableCell.forTableColumn());	
        cityCol.setOnEditCommit(t -> {
            (t.getTableView().getItems().get(t.getTablePosition().getRow())).setPlace(t.getNewValue());
        });
        
        depCityCol.setCellValueFactory(new PropertyValueFactory<Trip, String>("depPlace"));
        depCityCol.setCellFactory(TextFieldTableCell.forTableColumn());	
        depCityCol.setOnEditCommit(t -> {
            (t.getTableView().getItems().get(t.getTablePosition().getRow())).setDepPlace(t.getNewValue());
        });
        
        priceCol.setCellValueFactory(new PropertyValueFactory<Trip, Double>("price"));
//        priceCol.setCellFactory(TextFieldTableCell.forTableColumn());	
//        priceCol.setOnEditCommit(t -> {
//            (t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(t.getNewValue());
//        });
        
        dateCol.setCellValueFactory(new PropertyValueFactory<Trip, String>("date"));
        dateCol.setCellFactory(TextFieldTableCell.forTableColumn());	
        dateCol.setOnEditCommit(t -> {
            (t.getTableView().getItems().get(t.getTablePosition().getRow())).setDate(t.getNewValue());
        });
    }
}
