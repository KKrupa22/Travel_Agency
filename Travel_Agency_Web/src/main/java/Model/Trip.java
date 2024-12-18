/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.*;

/**
 *  Trip class is a class where we can create new Trip objects
 * @author Kamil Krupa
 */
@ToString
@Setter
public class Trip {

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getPlace() {
        return place;
    }

    public String getDepPlace() {
        return depPlace;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    private Random rand = new Random();
    
    private final int id;
    private String country;
    private String place;
    private String depPlace;
    private double price;
    private String date;
    
    public Trip(String country, String place, String depPlace, double price, String date) throws NumberException, EmptyFieldsException, WrongDateException {
    
        if(country == null || place == null || depPlace == null || String.valueOf(price) == null || date == null || country.isEmpty() || place.isEmpty() || depPlace.isEmpty() || date.isEmpty()) {
            throw new EmptyFieldsException("Fields cannot be empty or null");
        }
        if(price <= 0) {
            throw new NumberException("Price cannot be 0 or less");
        }
        
        Pattern datePattern = Pattern.compile("\\d{2}\\.\\d{2}-\\d{2}\\.\\d{2}\\.20[2-3]\\d");
        Matcher dateMatch = datePattern.matcher(date);
        boolean dateMatchFound = dateMatch.matches();
        
        if(!dateMatchFound) {
           throw new WrongDateException("Write date in DD.MM-DD.MM.YYYY"); 
        }
        
        this.id = Math.abs(rand.nextInt() % 1000);
        this.country = country;
        this.place = place;
        this.depPlace = depPlace;
        this.price = price;
        this.date = date;
    }
    
}
