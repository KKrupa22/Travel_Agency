/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Kamil
 */
public class TripTest {
    
    /**
     * Testing inserting wrong price values. It should catch an exception
     * @param price 
     */
    
    @ParameterizedTest
    @ValueSource(doubles = {0, -100})
    public void wrongPriceTest(double price) {
        try {
            Trip trip = new Trip("Poland", "Katowice", "Chorzow", price, "15.02-20.02.2025");
            fail("An exception should be thrown here");
        } catch(EmptyFieldsException | NumberException | WrongDateException e) {}
    }
    
    /**
     * Testing if we can pass empty, null sources to trip. Should catch an exception
     * @param x 
     */
    
    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = {""})
    public void nullFieldsTest(String x) {
        try {
        Trip trip = new Trip(x, x, x, 0, x);
        fail("An exception should be thrown here");
        } catch(EmptyFieldsException | NumberException | WrongDateException e) {}
    }
    
    /**
     * Testing correct data. It shouldn't throw an exception.
     */
    
    @ParameterizedTest
    @ValueSource(strings = {"Poland", "Polska", "Katowice"})
    public void correctDataTest(String t) {
        assertDoesNotThrow(
                () -> new Trip(t, t, t, 1500, "15.02-20.02.2025"), 
                "All the data is correct, an exception should not be thrown.");
    }
    
    /**
     * Testing if the regex is written correct. It should throw an exception if
     * it is not correct with the DD.MM-DD.MM.YYYY template
     * @param date 
     */
    
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"15-20.01.24", "15.1-20.1.2024", "DD.MM-DD.MM.YYYY"})
    public void wrongDateTest(String date) {
        try {
            Trip trip = new Trip("Poland", "Katowice", "Chorzow", 500, date);
            fail("An exception should be thrown here");
        } catch(EmptyFieldsException | NumberException | WrongDateException e) {}
    }
}
