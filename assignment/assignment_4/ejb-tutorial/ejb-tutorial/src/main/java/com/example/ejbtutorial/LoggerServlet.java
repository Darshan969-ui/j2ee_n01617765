package com.example.ejbtutorial;

import com.example.ejb.LoggerBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logger")
public class LoggerServlet extends HttpServlet {

    @EJB
    private LoggerBean loggerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            loggerBean.logAction(action);
        }
        response.getWriter().write("Action logged: " + action);
    }
}
