package com.mycuteblog.api;

import com.mycuteblog.ejb.core.bean.runner.IRunnerBeanLocal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
public class RunnerAjaxServlet extends HttpServlet {

    @EJB
    private IRunnerBeanLocal iRunnerBeanLocal;

    private static final Logger logger = LogManager.getLogger(RunnerAjaxServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Ajax request received");
        iRunnerBeanLocal.recordStep();
    }

}
