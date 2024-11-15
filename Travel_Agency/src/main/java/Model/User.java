/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kamil
 */

public class User {
    private String login;
    private String password;
    private String name;
    private String surname;
    private boolean isAdmin;

    public User(String login, String password, String name, String surname, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.isAdmin = isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    public boolean getIsAdmin() {
        return isAdmin;
    }
}
