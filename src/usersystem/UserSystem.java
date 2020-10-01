/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usersystem;

import javafx.application.Application;
import javafx.stage.Stage;
import view.LoginScreen;

/**
 *
 * @author oscarneiva
 */
public class UserSystem extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("User System");
        LoginScreen loginScreen = new LoginScreen(stage);
        stage.setScene(loginScreen.getScene());
        stage.setHeight(200);
        stage.setWidth(400);
        stage.show();
    }
}
