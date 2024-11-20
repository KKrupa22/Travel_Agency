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

public class GenericList<T> {
    
    private ObservableList<T> data = FXCollections.observableArrayList();
    
    /**
     * add method, it allows us to add a trip into our list
     * @param trip 
     */
    
    public void add(T element) {
        data.add(element);
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
    
    public T get(int x) {
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
    
    public ObservableList<T> getData() {
        return data;
    }
    
}
