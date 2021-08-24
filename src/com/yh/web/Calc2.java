package com.yh.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String v_ = request.getParameter("v");
        String op = request.getParameter("operator");

        int v = 0;
        if (!v_.equals("")) v = Integer.parseInt(v_);

        if (op.equals("=")) {
            int x = (Integer) application.getAttribute("value");
            String operator = (String) application.getAttribute("op");
            int result = 0;
            if (operator.equals("+")) result = x + v;
            else result = x - v;

            out.printf("result is %d\n", result);
            
        } else {
            application.setAttribute("value", v);
            application.setAttribute("op", op);
        }
    }
}
