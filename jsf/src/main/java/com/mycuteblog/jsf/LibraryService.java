package com.mycuteblog.jsf;

import com.mycuteblog.ejb.core.bean.LibrarySessionBeanRemote;

import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.Hashtable;
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
 * Created on : 1/7/16 3:14 PM
 */

@ManagedBean(name = "libraryService", eager = true)
public class LibraryService implements Serializable {
    private InitialContext ctx;

    public LibraryService() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        hashtable.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        hashtable.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        try {
            ctx = new InitialContext(hashtable);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    public List<String> getBookList() {
        LibrarySessionBeanRemote librarySessionBean = null;
        try {
            librarySessionBean = (LibrarySessionBeanRemote) ctx.lookup("sample-ear-1.0-SNAPSHOT/StatelessLibrarySessionBean/remote");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        if (librarySessionBean != null && librarySessionBean.getBooks() != null) {
            return librarySessionBean.getBooks();
        } else {
            return null;
        }
    }

    public String getBook(){
        return "";
    }

    public void setBook(String book) {
        LibrarySessionBeanRemote librarySessionBean = null;
        try {
            librarySessionBean = (LibrarySessionBeanRemote) ctx.lookup("sample-ear-1.0-SNAPSHOT/StatelessLibrarySessionBean/remote");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        if (librarySessionBean != null) {
            librarySessionBean.addBook(book);
        }
    }
}
