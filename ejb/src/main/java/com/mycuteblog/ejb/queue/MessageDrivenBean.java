package com.mycuteblog.ejb.queue;

import com.mycuteblog.ejb.core.bean.LibrarySessionBeanRemote;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

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
 * Created on : 1/18/16 4:25 PM
 */

@MessageDriven(
        name = "BookMessageHandler",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType",
                        propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination",
                        propertyValue = "/queue/BookQueue")
        }
)

public class MessageDrivenBean implements MessageListener {

    @Resource
    private MessageDrivenContext messageDrivenContext;

    @EJB(beanName = "StatefulLibrarySessionBean")
    private LibrarySessionBeanRemote libraryBean;

    public MessageDrivenBean() {
    }

    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = null;
        try {
            objectMessage = (ObjectMessage) message;
            String bookName = (String) objectMessage.getObject();
            libraryBean.addBook(bookName);
            System.out.println(libraryBean.getBooks());
        } catch (JMSException e) {
            messageDrivenContext.setRollbackOnly();
            e.printStackTrace();
        }

    }
}
