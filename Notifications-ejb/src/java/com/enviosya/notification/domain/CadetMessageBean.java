/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enviosya.notification.domain;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;


/**
 *
 * @author Gonzalo
 */

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "jms/QueueCadete"),
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Queue")
})
public class CadetMessageBean implements MessageListener {

//    @EJB
//    private MailBean mailBean;

    static Logger log = Logger.getLogger("FILE");

    public CadetMessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {

            TextMessage txt = (TextMessage) message;
            String msg = txt.getText();
//            EnvioCorreo correo = new EnvioCorreo();
//            correo.enviarCorreo(msg);
            System.out.println("ESTOY ENTRANDO EN MAIL");
            System.out.println(msg);
           // mailBean.enviarMail(msg);
            log.info("Mensaje del cadete recibido. Mensaje:" + msg);

        } catch (JMSException ex) {
            log.error("ERROR:"  + ex.getMessage());
        }
    }
}
