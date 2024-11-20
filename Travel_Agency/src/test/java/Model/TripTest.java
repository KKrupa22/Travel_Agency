/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Kamil
 */
public class TripTest {
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }    
    
    @ParameterizedTest
    @ValueSource(doubles = {0, -100})
    public void wrongPriceTest(double price) {
        try {
            Trip trip = new Trip("Poland", "Katowice", "Chorzow", price, "15.02-20.02.2025");
            fail("An exception should be thrown here");
        } catch(EmptyFieldsException | NumberException | WrongDateException e) {}
    }
    
    @Test
    public void nullFieldsTest() {
        try {
        Trip trip = new Trip(null, null, null, 0, null);
        fail("An exception should be thrown here");
        } catch(EmptyFieldsException | NumberException | WrongDateException e) {}
    }
    
    @Test
    public void correctDataTest() {
        assertDoesNotThrow(
                () -> new Trip("Poland", "Katowice", "Chorzow", 1500, "15.02-20.02.2025"), 
                "All the data is correct, an exception should not be thrown.");
    }
    
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
