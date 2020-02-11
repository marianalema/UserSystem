/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
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
    public void readUser() throws IOException{
        FileReader fileReader = new FileReader("./data/users.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String fileContent; 
        while((fileContent = bufferedReader.readLine()) != null) { 
            String[] fileData = fileContent.split(","); 
            user = new User(fileData[0], fileData[1]);
            users.add(user);
        }
            
        fileReader.close();
    }
    
    // CRUD - Read user
    public boolean readUser(String username, String password) throws IOException{
        readUser();
        for(int i = 0; i < users.size(); i++) {
            // Always use equals() when comparing strings and objects in JAVA!
            if( users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password) ){
                return true;
            }
        }
        return false;
    }
    
    // CRUD - Update user
    public void updateUser(){
    
    }
    
    // CRUD - Delete user
    public void deleteUser(){
    
    }
}
