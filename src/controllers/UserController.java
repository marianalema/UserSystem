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
    
    // Contructor - Load all users in the RAM memory
    public UserController() throws IOException{
        FileReader fileReader = new FileReader("./data/users.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String fileContent;
        users = new LinkedList<User>();
        while((fileContent = bufferedReader.readLine()) != null) {
            String[] fileData = fileContent.split(","); 
            user = new User(fileData[0], fileData[1]);
            users.add(user);
        }
            
        fileReader.close();
    }
    
    // CRUD - Create user
    public void createUser(String username, String password) throws IOException{
        FileWriter fileWriter = new FileWriter("./data/users.csv", true); 
        user = new User(username, password);
        users.add(user);
        fileWriter.write(user.getUsername() + "," + user.getPassword());
        fileWriter.write(System.lineSeparator());
        fileWriter.close();
        
        System.out.println("User " + username + " created.");
    }

    
    // CRUD - Read user to check if it exists
    public void readUser(String username, String password) throws IOException{
        for(int i = 0; i < users.size(); i++) {
            if( users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password) ){
                System.out.println("User " + username + " read.");
            }
        }
    }
    
    // CRUD - Update user
    public void updateUser(String username, String password, String newUsername, String newPassword) throws IOException{
        FileWriter fileWriter = new FileWriter("./data/users.csv");
        fileWriter.flush();
        for(int i = 0; i < users.size(); i++) {
            if( users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password) ){
                users.get(i).setUsername(newUsername);
                users.get(i).setPassword(newPassword);
            }
            fileWriter.write(users.get(i).getUsername() + "," + users.get(i).getPassword());
            fileWriter.write(System.lineSeparator());
        }
        fileWriter.close();
        
        System.out.println("User " + username + " updated.");
    }
    
    // CRUD - Delete user
    public void deleteUser(String username, String password) throws IOException{
        FileWriter fileWriter = new FileWriter("./data/users.csv");
        fileWriter.flush();
        for(int i = 0; i < users.size(); i++) {
            if( users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password) ){
                users.set(i, null);
            }else{
                String fileContent = users.get(i).getUsername() + "," + users.get(i).getPassword();
        
                fileWriter.write(fileContent);
                fileWriter.write(System.lineSeparator());
            }
        }
        fileWriter.close();

        System.out.println("User " + username + " deleted.");
    }
}
