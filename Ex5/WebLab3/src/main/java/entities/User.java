/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * Model class of the application responsible for user data.
 *
 * @author Oliwia Gowor
 * @version 5.0
 */
//@Entity
public class User /*implements Serializable*/ {
    
    //private static final long serialVersionUID = 1L;
    //@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)  
    private String username;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    private String password;

    public User() {

    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
