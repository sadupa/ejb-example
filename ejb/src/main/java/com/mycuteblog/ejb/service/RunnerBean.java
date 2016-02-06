package com.mycuteblog.ejb.service;

import com.mycuteblog.ejb.core.bean.runner.IRunnerBeanLocal;
import com.mycuteblog.ejb.core.bean.runner.IRunnerBeanRemote;
import com.mycuteblog.ejb.core.bean.step.IStepPersistentBeanLocal;
import com.mycuteblog.ejb.core.model.StepCount;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.*;
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
 * Created on : 2/2/16 9:11 PM
 */

@Stateless
public class RunnerBean implements IRunnerBeanLocal, IRunnerBeanRemote {

    @Resource(mappedName = "/queue/RunnerQueue")
    private Queue queue;

    @Resource(mappedName = "java:/ConnectionFactory")
    private QueueConnectionFactory queueConnectionFactory;

    @EJB
    private IStepPersistentBeanLocal stepPersistentBean;


    public void recordStep() {
        QueueConnection queueConnection = null;

        try {
            queueConnection = queueConnectionFactory.createQueueConnection();
            queueConnection.start();
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueSender sender = queueSession.createSender(queue);
            TextMessage textMessage = queueSession.createTextMessage();
            textMessage.setText("Step received");
            textMessage.setStringProperty("name", "MessageServlet");
            sender.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (queueConnection != null) {
                try {
                    queueConnection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int getStepCount() {
        List<StepCount> stepCount = stepPersistentBean.getStepCounts();
        if (stepCount == null || stepCount.size() == 0) {
            return 0;
        }
        return stepCount.get(0).getCount();
    }
}
