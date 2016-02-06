package com.mycuteblog.api;

import com.mycuteblog.ejb.core.bean.runner.IRunnerBeanLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
 * Created on : 1/30/16 3:46 PM
 */
public class GetCountServlet extends HttpServlet {

    @EJB
    private IRunnerBeanLocal runnerBeanLocal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/plain");
        PrintWriter writer = response.getWriter();
        writer.print(runnerBeanLocal.getStepCount());
        writer.close();
    }

}
