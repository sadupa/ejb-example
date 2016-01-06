package com.mycuteblog.ejb.persistent;

import com.mycuteblog.ejb.model.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * (C) Copyright 2015 hSenid Mobile Solutions (Pvt) Limited.
 * All Rights Reserved.
 * <p/>
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
 * of hSenid Mobile Solutions (Pvt) Limited.
 * <p/>
 * hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
 * property rights in these materials.
 *
 * @Author Sadupa Wijeratne
 * Created on : 12/22/15 2:56 PM
 */

@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

    @PersistenceContext(unitName = "EjbComponentPU2")
    private EntityManager entityManager;

    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public List<Book> getBooks() {
        return entityManager.createQuery("From Book").getResultList();
    }
}
