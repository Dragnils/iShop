package net.devstudy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {



 /*   @Override
    public void init() throws ServletException {
        //TODO Auto-generated method stub
        super.init();
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        Cookie c = new Cookie("author", "devstudy");
        c.setMaxAge(1800); // if negative,the cookie is not stored; if zero, deletes the cookie. время жизни куки в секундах
        c.setPath("/"); // на какой url должны передаваться куки
        c.setHttpOnly(true); // данный куки должен обрабатываться только на уровне протокола HTTP
        resp.addCookie(c); // добавляем в responce куки

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("Hello world!");
        out.println("</body></html>");
        out.close();
    }

//    @Override
//    public void destroy() {
//        //TODO Auto-generated method stub
//        super.destroy();
//    }
}
