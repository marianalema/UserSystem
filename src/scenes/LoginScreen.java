/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;


import controllers.UserController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author oscar neiva
 */
public class LoginScreen {
    
    // Class attributes
    private Scene scene;
    
    // Constructor of the class LoginScreen
    public LoginScreen(){
        Label userLabel = new Label("Username");
        TextField usernameTextField = new TextField();
        
        Label passwordLabel = new Label("Password");
        TextField passwordTextField = new TextField();
        
        Button confirmButton = new Button();
        confirmButton.setText("Confirm");
        confirmButton.setOnAction(e ->{
            UserController userController = new UserController();
            System.out.println(usernameTextField.getText() + passwordTextField.getText());
            try {
                userController.createUser(usernameTextField.getText() , passwordTextField.getText());
            } catch (IOException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        HBox topBox = new HBox();
        topBox.getChildren().addAll(userLabel, usernameTextField);
        
        HBox centerBox = new HBox();
        centerBox.getChildren().addAll(passwordLabel, passwordTextField);
        
        HBox bottomBox = new HBox();
        bottomBox.getChildren().addAll(confirmButton);
        
        BorderPane pane = new BorderPane();
        pane.setTop(topBox);
        pane.setCenter(centerBox);
        pane.setBottom(bottomBox);
        
        scene = new Scene(pane,300,300);
    }
    
    // Method to return the constructed LoginScreen
    public Scene getLoginScreen(){
        return scene;
    }
}
