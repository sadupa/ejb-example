package com.mycuteblog.ejb.queue;

import com.mycuteblog.ejb.core.bean.step.IStepPersistentBean;
import com.mycuteblog.ejb.core.bean.step.IStepPersistentBeanLocal;
import com.mycuteblog.ejb.core.model.StepCount;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Date;
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
 * Created on : 2/4/16 9:50 PM
 */

@MessageDriven(
        name = "RunnerMessageHandler",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType",
                        propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination",
                        propertyValue = "/queue/RunnerQueue")
        }
)
public class RunnerQueueListener implements MessageListener {

    @EJB
    private IStepPersistentBeanLocal stepPersistentBean;

    @Override
    public void onMessage(Message message) {
        List<StepCount> stepCounts = stepPersistentBean.getStepCounts();
        StepCount stepCount;
        if (stepCounts == null || stepCounts.size() == 0) {
            stepCount = new StepCount(1, new Date());
            stepPersistentBean.SaveStep(stepCount);
        } else {
            stepCount = stepCounts.get(0);
            stepCount.setCount(stepCount.getCount() + 1);
            stepCount.setRequestedTime(new Date());
            stepPersistentBean.updateStep(stepCount);
        }
    }
}