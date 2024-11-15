/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Kamil
 */

public class Users {
    private ArrayList<User> users = new ArrayList<>();
    private User user;
    
    public void add(User user) {
        users.add(user);
    }
     
    public User get(int i) {
        return users.get(i);
    }
    
    public int size() {
        return users.size();
    }
}
