package com.example.jdbcHW.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JdbcHwAppRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getProductName(String name) {
        Query query = entityManager.createQuery("select o.productName from Order o join o.customer c WHERE c.name = :name", String.class);
        query.setParameter("name", name);
        var result = query.getResultList();
        return result;
    }

}
