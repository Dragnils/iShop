package net.devstudy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

//Написать фильтр, который автоматически удалить все символы из Response: \t \r \n

//@WebFilter({"/trim", "/trim-params.html"})
public class TrimResponseFilter_Var3 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse originalResponse = (HttpServletResponse) resp;// приходит от браузера
        TrimResponse response = new TrimResponse(originalResponse);// создаем класс и
        chain.doFilter(req, response);// передаем его в chain.doFilter, т.е. мы подменили response своим response
        PrintWriter pw = originalResponse.getWriter();
        String content = response.getTrimContent();
        pw.write(content);// передаем в originalResponse
        originalResponse.setContentLength(content.length());// указываем длину сколько она есть
        pw.flush();
        pw.close();
    }

    @Override
    public void destroy() {
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static class TrimResponse extends HttpServletResponseWrapper {
        private StringWriter sw = new StringWriter();

        private TrimResponse(HttpServletResponse response) {
            super(response);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(sw);
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new ServletOutputStream(){
                @Override
                public boolean isReady() {
                    return false;
                }
                @Override
                public void setWriteListener(WriteListener writeListener) {

                }
                @Override
                public void write(int b) throws IOException {
                    sw.write(b);
                }
            };
        }

        private String getTrimContent() {
            return trim(sw.toString());
        }
    }

    private static String trim(String text) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != '\t' && ch != '\r' && ch != '\n') {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
