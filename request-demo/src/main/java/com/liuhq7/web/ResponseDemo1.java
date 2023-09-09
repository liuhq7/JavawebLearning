package com.liuhq7.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get...");
        System.out.println("resp1...");

        // 重定向

        // 1.设置响应状态码302
        resp.setStatus(302);
        // 2.设置响应头
        resp.setHeader("Location", "/request_demo_war/resp2");

        // 简化方法完成重定向
        resp.sendRedirect("/request_demo_war/resp2");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");

    }
}
