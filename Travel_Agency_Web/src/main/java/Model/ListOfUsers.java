/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * TripList class is used to store our Trip objects in ArrayList.
 * @author Kamil Krupa
 */

public class ListOfUsers {
   
    private final List<tripUser> data = new ArrayList<>();
    
    private final EntityManagerFactory emf;

    public ListOfUsers() {
        emf = Persistence.createEntityManagerFactory("Travel_Agency_Web");
    }
    
    /**
     * add method, it allows us to add a trip into our list
     * @param trip 
     */
    
    public void add(tripUser tripUser) throws NullException, EmptyFieldsException {
        if(tripUser == null) {
            throw new NullException("Fields cannot be null");
        }
        if(tripUser.equals("")) {
            throw new EmptyFieldsException("Fields cannot be empty");
        }
        data.add(tripUser);
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
    
    public tripUser get(int x) throws OutOfBoundsException {
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
    
    public void persistObject(Object object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();     
        } catch (PersistenceException e) {            
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public List<tripUser> getData() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT u FROM tripUser u");            
            return query.getResultList();         
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return new ArrayList<>();
    }
      
    public boolean update(tripUser tripUser) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(tripUser);
            em.getTransaction().commit();
        } catch(Exception ex){            
        }        
        return true;
    }
        
    public boolean delete(int id) {
        EntityManager em = emf.createEntityManager();
        try{           
            em.getTransaction().begin();
            var result = em.createQuery("DELETE FROM tripUser u WHERE u.id=:id").setParameter("id", id).executeUpdate() != 0;
            em.getTransaction().commit(); 
            return result;
        } catch(Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();            
        }    
        return true;
    }
    
}
