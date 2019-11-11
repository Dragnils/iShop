package net.devstudy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(value="/image/*", initParams = {
        @WebInitParam(name="ROOT_DIR", value="C:\\Users\\Anuarbek\\Desktop\\Anuar\\jee-ishop\\")
})
public class ShowPictureServlet extends HttpServlet {
    private String rootDir;
    @Override
    public void init() throws ServletException {
        rootDir = getServletConfig().getInitParameter("ROOT_DIR");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpg"); // устанавливаем контент тайп  image/jpg
        String[] parts = req.getRequestURI().split("/"); //извлекаем url
        String fileName = parts[parts.length-1]; //определяем имя нашего файла
        File file = new File(rootDir + fileName); // получаем объект файла
        if(file.exists()) { // если файл существует, открываем инпут стрим из данног файла, а записывать мы будем в объект resp.getOutputStream()
            try(InputStream in = new BufferedInputStream(new FileInputStream(file));
                OutputStream out = new BufferedOutputStream(resp.getOutputStream())) {
                int data = -1;
                while((data = in.read()) != -1) { // считываем из файла
                    out.write(data); // записываем в объект responce
                }
                out.flush();
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
