package net.devstudy.servlet;

import net.devstudy.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/s11")
public class Servlet11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("model", new Model());// в атрибуте сохранили объект класса Model
        req.getRequestDispatcher("/WEB-INF/model.jsp").forward(req, resp);
    }
}

