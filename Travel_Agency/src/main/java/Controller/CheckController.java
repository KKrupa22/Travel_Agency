/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kamil.krupa.cw2_final.App;

/**
 *
 * @author Kamil
 */
public class CheckController implements Initializable {
    
    @FXML private Button back;
    @FXML private TableView availableTab;
    @FXML private TableColumn countryCol;
    @FXML private TableColumn cityCol;
    @FXML private TableColumn depCityCol;
    @FXML private TableColumn priceCol;
    @FXML private TableColumn dateCol;
    private GenericList<Trip> trips;
    private String[] args;
    private double budget;
    private ObservableList<Trip> data = FXCollections.observableArrayList();
    
    /**
     * setBudget method is used to set new budget.
     * @param budget - our budget
     */
    
    public void setBudget(double budget) {
        this.budget = budget;
        refreshTable();
    }
    
    /**
     * CheckController constructor is used to load new window to ask to insert our budget
     * @param trips - trip list
     * @param args - arguments from console
     * @throws IOException 
     */
    
    public CheckController (GenericList<Trip> trips, String[] args) throws IOException {
        this.trips = trips;
        this.args = args;
        
        if(args != null) {
            budget = Double.parseDouble(args[0]);
        } else {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/Budget.fxml"));
            loader.setControllerFactory(p -> {return new BudgetController(budget, this);});
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 230, 125));
            stage.show();
        }
        
        for(int i = 0; i < trips.size(); i++) {
            if(budget >= trips.get(i).getPrice()) {
                data.add(trips.get(i));
            }
        }
    }
    
    /**
     * refreshTable method is used to refresh our table after inserting budget
     */
    
    private void refreshTable() {
        data.clear();
        for (int i = 0; i < trips.size(); i++) {
            if (budget >= trips.get(i).getPrice()) {
                data.add(trips.get(i));
            }
        }
        availableTab.setItems(data);
    }
    
    /**
     * back method is used to back to menu
     * @param event
     * @throws IOException 
     */
    
    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/MenuUser.fxml"));
        loader.setControllerFactory(p -> {return new MenuUserController(trips, args);});
        Parent root = loader.load();
        App.setRoot(root);
    }
    
    /**
     * initialize method is used to fill our table with data
     * @param url
     * @param rb 
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        availableTab.setItems(data);
        countryCol.setCellValueFactory(new PropertyValueFactory<Trip, String>("country"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Trip, String>("place"));
        depCityCol.setCellValueFactory(new PropertyValueFactory<Trip, String>("depPlace"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Trip, String>("price"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Trip, String>("date"));
    }
}
