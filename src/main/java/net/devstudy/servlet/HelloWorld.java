package net.devstudy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//передача управлени Forward, include, redirect
@WebServlet("/hello-world")
public class HelloWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //String attr1 = (String) req.getAttribute("attr1"); // Передача данных между компонентами. include, Forward
        String attr1 = (String)req.getSession().getAttribute("attr1");// Передача данных между компонентами. Redirect
        req.getSession().removeAttribute("attr1");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Hello world2222 " + attr1);
//out.close();
    }
}

