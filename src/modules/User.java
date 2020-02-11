/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

/**
 *
 * @author oscar neiva
 */
public class User {
    private String username;
    private String password;
    
    // Constructor without parameters
    public User(){
    }
    
    // Constructor with parameters
    public User(String u, String p){
        this.username = u;
        this.password = p;
    }
    
    // Username accessor
    public String getUsername(){
        return username;
    }
    
    // Username mutator
    public void setUsername(String u){
        this.username = u;
    }
    
    // Password accessor
    public String getPassword(){
        return password;
    }
    
    // Password mutator
    public void setPassword(String p){
        this.password = p;
    }
}
