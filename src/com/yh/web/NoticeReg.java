package com.yh.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // request : 입력 , response : 출력
        response.setCharacterEncoding("UTF-8"); // 사용자에게 보내는 정보
        response.setContentType("text/html; charset=UTF-8"); // 웹브라우저에게 이 정보로 읽으라고 알려줌

        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        out.println(title);
        out.println(content);


    }
}

