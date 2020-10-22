/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.UserController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Oscar Neiva
 */
public class UpdateScreen {
    private Scene scene;
    private Label username, password, newUsername, newPassword;
    private VBox centerBox;
    private HBox usernameBox, passwordBox, buttonBox, newUsernameBox, newPasswordBox;
    private BorderPane borderPane;
    private TextField usernameField, passwordField, newUsernameField, newPasswordField;
    private Button updateBtn;
    private UserController userController;
    
    public UpdateScreen(Stage stage){
        initComponents(stage);
    }
    
    public void initComponents(Stage stage){
        userController = new UserController();

        username = new Label("Username");
        password = new Label("Password");
        newUsername = new Label("New Username");
        newPassword = new Label("New Password");
        
        usernameField = new TextField();
        passwordField = new TextField();
        newUsernameField = new TextField();
        newPasswordField = new TextField();
        
        usernameBox = new HBox(10);
        usernameBox.getChildren().addAll(username, usernameField);
        usernameBox.setAlignment(Pos.CENTER);
        
        newUsernameBox = new HBox(10);
        newUsernameBox.getChildren().addAll(newUsername, newUsernameField);
        newUsernameBox.setAlignment(Pos.CENTER);
        
        passwordBox = new HBox(10);
        passwordBox.getChildren().addAll(password, passwordField);
        passwordBox.setAlignment(Pos.CENTER);
        
        newPasswordBox = new HBox(10);
        newPasswordBox.getChildren().addAll(newPassword, newPasswordField);
        newPasswordBox.setAlignment(Pos.CENTER);

        updateBtn = new Button("Update Account");
        updateBtn.setOnAction(e->{
            try {
                userController.update(  
                        usernameField.getText(),
                        newUsernameField.getText(),
                        passwordField.getText(),
                        newPasswordField.getText()
                );
            } catch (IOException ex) {
                Logger.getLogger(UpdateScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(updateBtn);
        buttonBox.setAlignment(Pos.CENTER);
        
        centerBox = new VBox(10);
        centerBox.getChildren().addAll(usernameBox, newUsernameBox, passwordBox, newPasswordBox, buttonBox);
        centerBox.setAlignment(Pos.CENTER);
        
        borderPane = new BorderPane();
        borderPane.setCenter(centerBox);
        
        scene = new Scene(borderPane);
    }
    
    public Scene getScene(){
        return scene;
    }
}
