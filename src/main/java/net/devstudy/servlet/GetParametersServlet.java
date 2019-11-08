package net.devstudy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//чтение параметров запроса
//http://localhost:8080/params?param1=qw&param2=7&param3=true&param4=a&param4=b&param4=c
//http://localhost:8080/ishop_war/params.html
//не запускается

@WebServlet("/params")
public class GetParametersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param1 = req.getParameter("param1");
        int param2 = Integer.parseInt(req.getParameter("param2"));
        boolean param3 = Boolean.parseBoolean(req.getParameter("param3"));
        String[] param4 = req.getParameterValues("param4"); // getParameterValues возворащает массив строк
        // process parameters
       // System.out.println();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

