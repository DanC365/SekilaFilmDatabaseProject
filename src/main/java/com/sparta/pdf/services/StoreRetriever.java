package com.sparta.pdf.services;

import com.sparta.pdf.components.Store;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Named
@Stateless
public class StoreRetriever {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Store> getFullStoreList() {
        Query query = entityManager.createNamedQuery("getStoreDetails");
        return query.getResultList();

    }
}
