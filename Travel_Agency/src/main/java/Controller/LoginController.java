/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import kamil.krupa.cw2_final.App;

/**
 * FXML Controller class
 *
 * @author Kamil
 */

public class LoginController {
    
        @FXML private TextField loginText;
        @FXML private PasswordField passwordText;
        @FXML private Button login;
        private Users users;
        private ArrayList<User> usersList; 
        private TripList trips;
        private String[] args;
        
    public LoginController(Users users, TripList trips, String[] args) {
        this.users = users;
        this.trips = trips;
        this.args = args;
        this.usersList = new ArrayList<>();
        
        for(int i = 0; i < users.size(); i++) {
            usersList.add(users.get(i));
        }
    }
    
    public void login(ActionEvent event) throws IOException {
        try {
            for(User user : usersList) {
                if(user.login().equals(loginText.getText()) && user.password().equals(passwordText.getText())) {
                    if(user.isAdmin() == false) {
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/MenuUser.fxml"));
                        loader.setControllerFactory(p -> {return new MenuUserController(trips, args);});
                        Parent root = loader.load();
                        App.setRoot(root);
                        break;
                    } else {
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/Menu.fxml"));
                        loader.setControllerFactory(p -> {return new MenuController(trips, args);});
                        Parent root = loader.load();
                        App.setRoot(root);
                        break;
                    }
                }
                if(user.login().equals(loginText.getText()) && !user.password().equals(passwordText.getText())) {
                    throw new WrongLoginException("Wrong login or password.");
                }
            }
            if(loginText.getText().isEmpty() || passwordText.getText().isEmpty()) {
                throw new EmptyFieldsException("Fields cannot be empty.");
            }
            
        } catch (EmptyFieldsException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty fields");
            alert.setHeaderText("Fields cannot be empty");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }  
        catch (WrongLoginException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong Login or password");
            alert.setHeaderText("Wrong login or password.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }  
    }
}
