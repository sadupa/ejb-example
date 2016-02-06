package com.mycuteblog.ejb.persistent;

import com.mycuteblog.ejb.core.bean.step.IStepPersistentBeanLocal;
import com.mycuteblog.ejb.core.model.StepCount;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * Created on : 2/4/16 9:56 PM
 */

@Stateless
public class StepPersistentBean implements IStepPersistentBeanLocal {

    @PersistenceContext(unitName = "EjbComponentPU2")
    private EntityManager entityManager;

    private static final Logger logger = LogManager.getLogger(StepPersistentBean.class);

    @Override
    public void SaveStep(StepCount stepCount) {
        try {
            entityManager.persist(stepCount);
        } catch (Exception e) {
            logger.error(e);
        }

    }

    @Override
    public List<StepCount> getStepCounts() {
        return entityManager.createQuery("From StepCount").getResultList();
    }

    @Override
    public void updateStep(StepCount stepCount) {
        entityManager.merge(stepCount);
    }
}
