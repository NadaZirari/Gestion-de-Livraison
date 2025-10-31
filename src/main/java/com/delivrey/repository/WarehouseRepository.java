package com.delivrey.repository;

import com.delivrey.entity.Warehouse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class WarehouseRepository {

    private final EntityManager entityManager;

    public WarehouseRepository(EntityManagerFactory emf) {
        this.entityManager = emf.createEntityManager();
    }

    public Warehouse save(Warehouse warehouse) {
        entityManager.getTransaction().begin();
        entityManager.persist(warehouse);
        entityManager.getTransaction().commit();
        return warehouse;
    }

    public Warehouse findById(Long id) {
        return entityManager.find(Warehouse.class, id);
    }

    public List<Warehouse> findAll() {
        TypedQuery<Warehouse> query = entityManager.createQuery("SELECT w FROM Warehouse w", Warehouse.class);
        return query.getResultList();
    }

    public void delete(Warehouse warehouse) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(warehouse) ? warehouse : entityManager.merge(warehouse));
        entityManager.getTransaction().commit();
    }

    public List<Warehouse> findByAddress(String address) {
        TypedQuery<Warehouse> query = entityManager.createQuery(
                "SELECT w FROM Warehouse w WHERE w.address = :address", Warehouse.class);
        query.setParameter("address", address);
        return query.getResultList();
    }
}
