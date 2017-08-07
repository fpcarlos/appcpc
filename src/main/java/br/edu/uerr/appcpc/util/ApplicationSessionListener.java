/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author fpcarlos
 */
public class ApplicationSessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session Created");
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        //write your logic
        System.out.println("Session Destroyed");
    }
}
