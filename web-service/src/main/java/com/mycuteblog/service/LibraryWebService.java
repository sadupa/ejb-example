package com.mycuteblog.service;

import com.mycuteblog.ejb.core.bean.LibraryDependencyBeanRemote;
import com.mycuteblog.ejb.core.bean.LibraryPersistentBeanRemote;
import com.mycuteblog.ejb.core.model.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * (C) Copyright 2016 hSenid Mobile Solutions (Pvt) Limited.
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
 * Created on : 1/25/16 3:24 PM
 */

@Stateless
@WebService(serviceName = "LibraryWebService")
public class LibraryWebService implements LibraryDependencyBeanRemote {

    @EJB
    private LibraryPersistentBeanRemote libraryBean;


    @Override
    public void addBook(String bookName) {

    }

    @Override
    @WebMethod(operationName = "getBooks")
    public List<Book> getBooks() {
        return libraryBean.getBooks();
    }
}
