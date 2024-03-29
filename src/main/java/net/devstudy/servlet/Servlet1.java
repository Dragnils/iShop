package net.devstudy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//передача управлени Forward
@WebServlet("/serv1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws IOException, ServletException {
        req.setAttribute("attr1", "serv1"); // Передача данных между компонентами.
        req.getRequestDispatcher("/hello-world").forward(req, resp);
    }
}
