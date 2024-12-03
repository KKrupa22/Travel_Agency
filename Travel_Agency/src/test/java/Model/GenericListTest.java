/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Kamil
 */
public class GenericListTest {
    
    /**
     * Testing of add method works fine. It should throw an exception because
     * of nulls, and empty sources
     * @param x 
     */
    
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {""})
    void addTest(String x) {
        try {
        GenericList<String> list = new GenericList<>();
        list.add(x);
        list.add(x);
        list.add(x);
        fail("Exception should be thrown here");
        } catch (NullException | EmptyFieldsException e) {}
    }
    
    /**
     * Testing get method. It should throw an exception because we want to
     * get to the third place in list.
     * @param x 
     */
    
    @ParameterizedTest
    @ValueSource(strings = {"jeden", "dwa", "1"})
    void getTest(String x) {
        try {
        GenericList<String> list = new GenericList<>();
        list.add(x);
        list.add(x);
        list.add(x);
        list.get(3);
        fail("Exception should be thrown here");
        } catch (NullException | EmptyFieldsException | OutOfBoundsException e) {}
    }
    
    /**
     * Testing clear method. It should pass both asserts cause we checking if
     * size is =0 and isEmpty()
     * @param x 
     */
    
    @ParameterizedTest
    @ValueSource(strings = {"jeden", "dwa", "1"})
    void clearTest(String x) {
        try {
        GenericList<String> list = new GenericList<>();
        list.add(x);
        list.add(x);
        list.add(x);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.getData().isEmpty());
        } catch (NullException | EmptyFieldsException e) {}
    }
    
    /**
     * Testing getData method. It should pass tests cause we are checking size
     * and using get.
     * @param x 
     */
    
    @ParameterizedTest
    @ValueSource(strings = {"jeden", "dwa", "1"})
    void getDataTest(String x) {
        try {
        GenericList<String> list = new GenericList<>();
        list.add(x);
        list.add(x);
        list.add(x);
        assertEquals(3, list.getData().size());
        assertEquals(x, list.getData().get(0));
        assertEquals(x, list.getData().get(2));
        } catch (NullException | EmptyFieldsException e) {}
    }
    
}
