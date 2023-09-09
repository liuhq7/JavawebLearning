package com.liuhq7.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

// 配置Servlet的访问路径
@WebServlet("/demo1")
// 实现Servlet接口，重写其中的方法
public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Hello World!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
