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
        // Labels and text fields
        Label userLabel = new Label("Username");
        TextField usernameTextField = new TextField();
        TextField newUsernameTextField = new TextField();
        
        Label passwordLabel = new Label("Password");
        TextField passwordTextField = new TextField();
        TextField newPasswordTextField = new TextField();
        
        // Create button
        Button createButton = new Button();
        createButton.setText("Create");
        createButton.setOnAction(e ->{
            try {
                UserController userController = new UserController();
                userController.createUser(usernameTextField.getText() , passwordTextField.getText());
            } catch (IOException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Read button
        Button readButton = new Button();
        readButton.setText("Read");
        readButton.setOnAction(e ->{
            try {
                UserController userController = new UserController();
                userController.readUser(usernameTextField.getText() , passwordTextField.getText());
            } catch (IOException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Update button
        Button updateButton = new Button();
        updateButton.setText("Update");
        updateButton.setOnAction(e ->{
            try {
                UserController userController = new UserController();
                userController.updateUser(usernameTextField.getText() , passwordTextField.getText(), newUsernameTextField.getText() , newPasswordTextField.getText());
            } catch (IOException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Delete button
        Button deleteButton = new Button();
        deleteButton.setText("Delete");
        deleteButton.setOnAction(e ->{
            try {
                UserController userController = new UserController();
                userController.deleteUser(usernameTextField.getText() , passwordTextField.getText());
            } catch (IOException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Setting boxes and panes
        HBox topBox = new HBox();
        topBox.getChildren().addAll(userLabel, usernameTextField, newUsernameTextField);
        
        HBox centerBox = new HBox();
        centerBox.getChildren().addAll(passwordLabel, passwordTextField, newPasswordTextField);
        
        HBox bottomBox = new HBox();
        bottomBox.getChildren().addAll(createButton, readButton, updateButton, deleteButton);
        
        BorderPane pane = new BorderPane();
        pane.setTop(topBox);
        pane.setCenter(centerBox);
        pane.setBottom(bottomBox);
        
        scene = new Scene(pane,500,300);
    }
    
    // Method to return the constructed LoginScreen
    public Scene getLoginScreen(){
        return scene;
    }
}
