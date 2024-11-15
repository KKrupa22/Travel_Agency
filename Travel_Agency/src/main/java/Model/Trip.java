/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import lombok.*;

/**
 *  Trip class is a class where we can create new Trip objects
 * @author Kamil Krupa
 */
@ToString
@Getter
@Setter
public class Trip {

    private String country;
    private String place;
    private String depPlace;
    private double price;
    private String date;
    
    public Trip(String country, String place, String depPlace, double price, String date) throws NumberException {
        if(price <= 0) {
            throw new NumberException("Price cannot be 0 or less");
        }
        this.country = country;
        this.place = place;
        this.depPlace = depPlace;
        this.price = price;
        this.date = date;
    }
    
}
