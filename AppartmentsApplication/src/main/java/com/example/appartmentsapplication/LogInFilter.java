package com.example.appartmentsapplication;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogInFilter implements Filter {
    static Logger logger = LogManager.getLogManager().getLogger(String.valueOf(LogInFilter.class));
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpServletRequest.getSession(false);
        try{
            if(httpSession != null || httpSession.getAttribute("username")!=null)
                filterChain.doFilter(servletRequest, servletResponse);
        }
        catch (NullPointerException e){
            System.out.println("You have not authorized access!!");
            httpServletResponse.sendRedirect("index.jsp");
        }
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
