package com.mycuteblog.ejb.session;

import javax.ejb.EJB;
import javax.ejb.Stateful;
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
 * Created on : 1/5/16 5:37 PM
 */

@Stateful
public class DependencyLibrarySessionBean implements DependencySessionBeanRemote {

    @EJB(beanName = "StatefulLibrarySessionBean")
    LibrarySessionBeanRemote librarySessionBean;

    @Override
    public void addBook(String bookName) {
        librarySessionBean.addBook(bookName);
    }

    @Override
    public List<String> getBooks() {
        return librarySessionBean.getBooks();
    }
}
