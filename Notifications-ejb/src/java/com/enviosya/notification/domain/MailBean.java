/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enviosya.notification.domain;
import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Gonzalo
 */
@Stateless
@LocalBean
public class MailBean {

    public void enviarMail(String msg) {
System.out.println("LALAOAOAOAOAOAOAOAOAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        String[] datos = msg.split("-");
        String to = datos[0].trim();
        String subject = datos[1].trim();
        String body = datos[2].trim();
        System.out.println("TO: "+to);
        System.out.println("SUBJECT: "+subject);
        System.out.println("BODY: "+body);
        final String from = "lalo25886@gmail.com";
        final String username = "lalo25886";
        final String password = "gon25zalo";
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}