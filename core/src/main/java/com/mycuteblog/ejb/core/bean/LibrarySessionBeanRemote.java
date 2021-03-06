package com.mycuteblog.ejb.core.bean;

import javax.ejb.Remote;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
@Path("/library")
public interface LibrarySessionBeanRemote {
    void addBook(String bookName);

    @Path("get-book-list")
    @GET
    List<String> getBooks();
}
