package com.mycuteblog.jsf;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

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
    String book;

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book=book;
    }
}
