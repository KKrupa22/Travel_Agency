/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * TripList class is used to store our Trip objects in ArrayList.
 * @author Kamil Krupa
 */

public class GenericList {
   
    private final List<Trip> data = new ArrayList<>();
    
    public GenericList() {
        try {
        data.add(new Trip("Poland", "Warsaw", "Katowice", 500, "20.11-24.11.2024"));
        data.add(new Trip("Germany", "Berlin", "Katowice", 1500, "20.11-24.11.2024"));
        data.add(new Trip("Spain", "Madrid", "Cracow", 2000, "10.12-16.12.2024"));
        data.add(new Trip("England", "London", "Warsaw", 1250, "20.12-27.12.2024"));
        data.add(new Trip("Japan", "Tokyo", "Berlin", 3000, "03.01-05.01.2025"));
        data.add(new Trip("Italy", "Rome", "Katowice", 2200, "30.01-07.02.2024"));
        } catch(NumberException | EmptyFieldsException | WrongDateException ex) {}
    }
    
    /**
     * add method, it allows us to add a trip into our list
     * @param trip 
     */
    
    public void add(Trip trip) throws NullException, EmptyFieldsException {
        if(trip == null) {
            throw new NullException("Fields cannot be null");
        }
        if(trip.equals("")) {
            throw new EmptyFieldsException("Fields cannot be empty");
        }
        data.add(trip);
    }
    
    /**
     * size method, it is returning size of our triplist
     * @return 
     */
    
    public int size() {
        return data.size();
    }
    
    /**
     * get method, it is used to return a trip from triplist by index
     * @param x
     * @return 
     */
    
    public Trip get(int x) throws OutOfBoundsException {
        if(x >= data.size()) {
            throw new OutOfBoundsException("Out of bounds");
        }
        return data.get(x);
    }
    
    /**
     * clear method, it is used to clear our triplist
     */
    
    public void clear() {
        data.clear();
    }
    
    /**
     * getData method is used to return data from observable list
     * @return 
     */
    
    public List<Trip> getData() {
        return data;
    }
    
    public boolean delete(int id) {
        return data.removeIf(i -> i.getId() == id);
    }
    
}
