package com.mycuteblog.ejb.core.bean;

import com.mycuteblog.ejb.core.bean.model.Book;

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
 * Created on : 12/22/15 1:33 PM
 */

public interface LibraryPersistentBeanRemote {
    void addBook(Book book);

    List<Book> getBooks();
}
