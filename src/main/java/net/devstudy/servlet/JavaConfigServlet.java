package net.devstudy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JavaConfigServlet extends HttpServlet { //создание сервлета черз Java код, смотреть package config, папку resources-META-INF-services
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("JavaConfigServlet");
    }
}

