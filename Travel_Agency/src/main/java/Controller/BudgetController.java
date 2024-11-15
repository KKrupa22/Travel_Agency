/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.WrongPriceException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Kamil
 */
public class BudgetController {
    
    @FXML private TextField insertField;
    @FXML private Button save;
    private double budget;
    private CheckController checkController;
    
    /**
     * BudgetController constructor is used to initialize our controller
     * @param budget - our budget
     * @param check - CheckController class instantion
     */
    
    public BudgetController(double budget, CheckController check) {
        this.budget = budget;
        this.checkController = check;
    }
    
    /**
     * save method is used to insert and pass our budget to CheckController class
     * @param event 
     */
    
    @FXML
    public void save(ActionEvent event) {
        try {
            budget = Double.parseDouble(insertField.getText());
            if(budget <= 0) {
                throw new WrongPriceException("Price can't be 0, less or text.");
            }
        } catch (WrongPriceException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Price");
            alert.setHeaderText("Invalid Price Entry");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Non-numeric Input");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        
        insertField.clear();
        
        if(budget > 0) {
        checkController.setBudget(budget);
        Node n = (Node) event.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
        }
        
    }
}
