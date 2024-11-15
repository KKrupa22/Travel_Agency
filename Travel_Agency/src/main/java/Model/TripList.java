/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * TripList class is used to store our Trip objects in ArrayList.
 * @author Kamil Krupa
 */

public class TripList {
    
    private ObservableList<Trip> data = FXCollections.observableArrayList();
    private Trip trip;
    
    /**
     * add method, it allows us to add a trip into our list
     * @param trip 
     */
    
    public Trip add(Trip trip) {
        data.add(trip);
        return trip;
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
    
    public Trip get(int x) {
        return data.get(x);
    }
    
    /**
     * getData method is used to return data from observable list
     * @return 
     */
    
    public ObservableList<Trip> getData() {
        return data;
    }
    
}
