/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import modules.User;

/**
 *
 * @author oscar neiva
 */
public class UserController {
    private User user;
    private LinkedList<User> users;
    
    public UserController(){
        users = new LinkedList<User>();
    }
    
    // CRUD - Create user
    public void createUser(String username, String password) throws IOException{
        FileWriter fileWriter = new FileWriter("./data/users.csv", true); 
        
        user = new User(username, password);
        String fileContent = user.getUsername() + "," + user.getPassword();
        
        fileWriter.write(fileContent);
        fileWriter.write(System.lineSeparator());
        fileWriter.close();
        
        System.out.println("User created");
    }
    
    // CRUD - Read user
    public void readUser(){
    
    }
    
    // CRUD - Update user
    public void updateUser(){
    
    }
    
    // CRUD - Delete user
    public void deleteUser(){
    
    }
}
