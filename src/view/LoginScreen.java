/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.UserController;
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
 * @author oscarneiva
 */
public class LoginScreen {
    private Scene scene;
    private Label username, password;
    private VBox centerBox;
    private HBox usernameBox, passwordBox;
    private BorderPane borderPane;
    private TextField usernameField, passwordField;
    private Button signinBtn;
    private UserController userController;
    
    public LoginScreen(Stage stage){
        initComponents(stage);
    }
    
    public void initComponents(Stage stage){
        username = new Label("Username");
        password = new Label("Password");
        usernameField = new TextField();
        passwordField = new TextField();
        
        usernameBox = new HBox(10);
        usernameBox.getChildren().addAll(username, usernameField);
        usernameBox.setAlignment(Pos.CENTER);
        
        passwordBox = new HBox(10);
        passwordBox.getChildren().addAll(password, passwordField);
        passwordBox.setAlignment(Pos.CENTER);
        
        signinBtn = new Button("SignIn");
        signinBtn.setOnAction(e->{
            userController = new UserController();
            userController.read(usernameField.getText(), passwordField.getText());
        });
        
        centerBox = new VBox(10);
        centerBox.getChildren().addAll(usernameBox, passwordBox, signinBtn);
        centerBox.setAlignment(Pos.CENTER);
        
        borderPane = new BorderPane();
        borderPane.setCenter(centerBox);
        
        scene = new Scene(borderPane);
    }
    
    public Scene getScene(){
        return scene;
    }
}
