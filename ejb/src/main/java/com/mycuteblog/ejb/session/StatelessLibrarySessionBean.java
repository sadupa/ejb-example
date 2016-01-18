package com.mycuteblog.ejb.session;

import com.mycuteblog.ejb.core.bean.LibrarySessionBeanRemote;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

@Remote
@Path("get-book")
@Stateless
public class StatelessLibrarySessionBean implements LibrarySessionBeanRemote {

    List<String> bookShelf;

    public StatelessLibrarySessionBean() {
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

    @GET
    @Produces({"text/plain"})
    public String getBookList() {
        return "ok";
    }
}
