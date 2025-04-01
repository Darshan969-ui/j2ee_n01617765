package com.example.ejbtutorial;

import com.example.ejb.CalculatorBean;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @EJB
    private CalculatorBean calculatorBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println("10 + 5 = " + calculatorBean.add(10, 5));
        response.getWriter().println("10 - 5 = " + calculatorBean.subtraction(10, 5));
        response.getWriter().println("10 * 5 = " + calculatorBean.multiplication(10, 5));
        response.getWriter().println("10 / 5 = " + calculatorBean.division(10, 5));
    }
}