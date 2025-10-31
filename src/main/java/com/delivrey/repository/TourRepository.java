package com.delivrey.repository;

import com.delivrey.entity.Tour;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class TourRepository {

    private final EntityManager entityManager;

    public TourRepository(EntityManagerFactory emf) {
        this.entityManager = emf.createEntityManager();
    }

    public Tour save(Tour tour) {
        entityManager.getTransaction().begin();
        entityManager.persist(tour);
        entityManager.getTransaction().commit();
        return tour;
    }

    public Tour findById(Long id) {
        return entityManager.find(Tour.class, id);
    }

    public List<Tour> findAll() {
        TypedQuery<Tour> query = entityManager.createQuery("SELECT t FROM Tour t", Tour.class);
        return query.getResultList();
    }

    public void delete(Tour tour) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(tour) ? tour : entityManager.merge(tour));
        entityManager.getTransaction().commit();
    }
}
