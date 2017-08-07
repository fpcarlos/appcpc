/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appcpc.util;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fpcarlos
 */
public class RedirectFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        //check if "role" attribute is null
        if (req.getSession().getAttribute("userid") == null) {
            //forward request to login.jsp
            req.getRequestDispatcher("/login.xhtml").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
