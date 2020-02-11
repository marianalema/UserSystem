/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersystem;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import scenes.LoginScreen;

/**
 *
 * @author oscar neiva
 */
public class UserSystem extends Application{
    
    // Method to start the initial stage with the first scene
    public void start(Stage stage)throws IOException{
        LoginScreen loginScreen = new LoginScreen();
        stage.setTitle("User System");
        stage.setResizable(false);
        stage.setScene(loginScreen.getLoginScreen());
        stage.show();
    }
    
    // Main method
    public static void main (String[] args){
        launch(args);
    }
}
