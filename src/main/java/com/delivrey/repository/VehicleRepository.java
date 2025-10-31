package com.delivrey.repository;

import com.delivrey.entity.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class VehicleRepository {

    private final EntityManager entityManager;

    public VehicleRepository(EntityManagerFactory emf) {
        this.entityManager = emf.createEntityManager();
    }

    public Vehicle save(Vehicle vehicle) {
        entityManager.getTransaction().begin();
        entityManager.persist(vehicle);
        entityManager.getTransaction().commit();
        return vehicle;
    }

    public Vehicle findById(Long id) {
        return entityManager.find(Vehicle.class, id);
    }

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createQuery("SELECT v FROM Vehicle v", Vehicle.class);
        return query.getResultList();
    }

    public void delete(Vehicle vehicle) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(vehicle) ? vehicle : entityManager.merge(vehicle));
        entityManager.getTransaction().commit();
    }
}
