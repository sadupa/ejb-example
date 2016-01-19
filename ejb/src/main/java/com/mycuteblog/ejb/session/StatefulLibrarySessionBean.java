package com.mycuteblog.ejb.session;

import com.mycuteblog.ejb.core.bean.LibrarySessionBeanRemote;

import javax.ejb.Stateful;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
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
 * Created on : 12/18/15 3:36 PM
 */

@Stateful
public class StatefulLibrarySessionBean implements LibrarySessionBeanRemote {

    List<String> bookShelf;

    public StatefulLibrarySessionBean() {
        bookShelf = new ArrayList<String>();
    }

    @Override
    public void addBook(String bookName) {
        bookShelf.add(bookName);
    }

    @Override
    public List<String> getBooks() {
        return bookShelf;
    }

    @Override
    public Response getBookList() {
        System.out.println("received http get request");
        return Response.ok().build();
    }
}
