package com.example.appartmentsapplication;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password =request.getParameter("password");
        if((username.equals("admin")) && (password.equals("12345678"))){
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("username", "admin");
            httpSession.setMaxInactiveInterval(10*60*1000);
            response.sendRedirect("main.jsp");
        }
        else{
            out.println("<font color=red> Sorry, invalid username or password entered!! </font><br>");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.include(request,response);
            out.close();
        }
    }
}

