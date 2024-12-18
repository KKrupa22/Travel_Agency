/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern.Flag;
import java.io.Serializable;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.*;

/**
 *  Trip class is a class where we can create new Trip objects
 * @author Kamil Krupa
 */

@Entity
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Trip implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    
    @Column(name = "country", length = 20)
    private String country;
    
    @Column(name = "city", length = 20)
    private String place;
    
    @Column(name = "depPlace", length = 20)
    private String depPlace;
    
    @Column(name = "price", length = 10)
    private double price;
    
    @Column(name = "date", length = 20)
    @jakarta.validation.constraints.Pattern(regexp = "\\d{2}\\.\\d{2}-\\d{2}\\.\\d{2}\\.20[2-3]\\d", flags = Flag.UNICODE_CASE)
    private String date;
    
    public Trip(int id, String country, String place, String depPlace, double price, String date) throws NumberException, EmptyFieldsException, WrongDateException {
    
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
        
        this.id = id;
        this.country = country;
        this.place = place;
        this.depPlace = depPlace;
        this.price = price;
        this.date = date;
    }
    
}
