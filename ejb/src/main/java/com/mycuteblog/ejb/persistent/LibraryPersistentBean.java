package com.mycuteblog.ejb.persistent;

import com.mycuteblog.ejb.core.bean.LibraryPersistentBeanRemote;
import com.mycuteblog.ejb.core.model.Book;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
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
@TransactionManagement(value = TransactionManagementType.BEAN)
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

    @PersistenceContext(unitName = "EjbComponentPU2")
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    @Override
    public void addBook(Book book) {
        try {
            userTransaction.begin();
            entityManager.persist(new Book());
            userTransaction.commit();
        } catch (Exception e) {
            try {
                userTransaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public List<Book> getBooks() {
        return entityManager.createQuery("From Book").getResultList();
    }
}
