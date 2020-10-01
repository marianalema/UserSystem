/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author oscarneiva
 */
public class UserController {
    private User user;
    private LinkedList<User> users;
    
    public UserController(){
        try {
            read();
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void read() throws IOException{
        FileReader filePath = new FileReader("./data/users.csv");
        Scanner file = new Scanner(filePath);
        users = new LinkedList<User>();
        
        while(file.hasNext()){
            String[] data = file.nextLine().split(",");
            user = new User(data[0], data[1]);
            users.add(user);
        }
        
        file.close();
        filePath.close();
    }
    
    public boolean read(String username, String password){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUsername().equals(username) 
                && users.get(i).getPassword().equals(password)){
                System.out.println("welcome");
                return true;
            }
        }
        System.out.println("Access Denied");
        return false;
    }
}
