package com.mycuteblog.jsf;

import javax.faces.bean.ManagedBean;

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
 * Created on : 1/5/16 11:22 AM
 */

@ManagedBean(name = "helloJsf", eager = true)
public class HelloJsf {
    public HelloJsf() {
        System.out.println("hello jsf");
    }
    public String getMessage(){
        return "Hello JSF";
    }
}
