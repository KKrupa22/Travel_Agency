/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author siano
 */
public class WrongDateException extends Exception {
    
    /**
     * Constructor of this class is used to make our exception
     * @param errorMsg 
     */
    
    public WrongDateException(String errorMsg) {
        super(errorMsg);
    }
    
}
