package com.yh.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class Calc extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String tmpX = request.getParameter("x");
        String tmpY = request.getParameter("y");
        String op = request.getParameter("operator");

        int x = 0;
        int y = 0;

        if (validation(tmpX) && validation((tmpY))) {
            x = Integer.parseInt(tmpX);
            y = Integer.parseInt(tmpY);
        }

        int result =0;
        if (op.equals("덧셈")) {
            result = x + y;
        } else {
            result = x - y;
        }

        out.println(result);

    }

    protected boolean validation(String s) {
        return s != null && !s.equals("");
    }


}
