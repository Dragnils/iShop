package net.devstudy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/admin", initParams = {
        @WebInitParam(name="ip", value="22.22.22.22"), //эталонные параметры
        @WebInitParam(name="accessKey", value="secret"),
        @WebInitParam(name="login", value="admin"),
        @WebInitParam(name="password", value="password")
})
public class AdminServlet  extends HttpServlet {
    private String ip;
    private String accessKey;
    private String login;
    private String password;

    @Override
    public void init() throws ServletException { //считываем конфигурационный параметры, для того чтобы они были сохранены в наших переменных
        ip = getServletConfig().getInitParameter("ip");
        accessKey = getServletConfig().getInitParameter("accessKey");
        login = getServletConfig().getInitParameter("login");
        password = getServletConfig().getInitParameter("password");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip = req.getRemoteAddr(); // запрашиваем локальные данные с текущего клиента
        String accessKey = req.getHeader("ACCESS_KEY");// запрашиваем локальные данные с текущего клиента
        String login = req.getParameter("login");// запрашиваем локальные данные с текущего клиента
        String password = req.getParameter("password");// запрашиваем локальные данные с текущего клиента
        try {
            validate(ip, accessKey, login, password);
            resp.getWriter().println("OK");
        }catch (IllegalStateException e){
            System.err.println(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println("FAILED");
        }
    }

    private void validate(String ip, String accessKey, String login, String password){
        StringBuilder errors = new StringBuilder();
        if(this.ip.equals(ip)){
            System.out.println("Login via ip: " + ip);
            return;
        }else {
            errors.append(String.format("Invalid ip: %s\n", ip));
        }
        if (this.accessKey.equals(accessKey)){
            System.out.println("Login via accessKey: " + accessKey);
            return;
        }else {
            errors.append(String.format("Invalid access: %s\n", accessKey));
        }
        if(this.login.equals(login) && this.password.equals(password)){
            System.out.println("Login via login and password: " + login + "/" + password);
            return;
        }else {
            errors.append(String.format("Invalid login and(or) password: %s%s\n", login, password));
        }
        throw new IllegalStateException(errors.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
