package com.liuhq7.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
urlPattern配置：
    urlPattern：一个Servlet可以配置多个访问路径 @WebServlet(urlPatterns = {"/demo5a", "/demo5b"})
    精确匹配（优先）：输入的url与urlPattern完全匹配 @WebServlet(urlPatterns = "/demo5/user")
    目录匹配：*为任何字符，前面与输入的url相同即可匹配 @WebServlet(urlPatterns = "/demo5/*")
    扩展名匹配：扩展名与输入的url相同即可匹配，urlPattern的值前面不能加“/” @WebServlet(urlPatterns = "*.do")
    任意匹配：输入任意url即可匹配 @WebServlet(urlPatterns = "/*")
 */
@WebServlet(urlPatterns = {"/demo5a", "/demo5b"})
public class ServletDemo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
    }
}
