package net.devstudy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

//Написать фильтр, который автоматически удалить все символы из Response: \t \r \n

//@WebFilter({"/trim", "/trim-params.html"})
public class TrimResponseFilter_Var2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse originalResponse = (HttpServletResponse) resp;
        TrimWriter trimWriter = new TrimWriter();// сперва записываем в наш trimWriter с удалением ненужных символов
        TrimResponse response = new TrimResponse(originalResponse, trimWriter);
        chain.doFilter(req, response);
        PrintWriter pw = originalResponse.getWriter();
        pw.write(trimWriter.getContent());//а вторым циклом должны записать нашу строку в наш originalResponse
        originalResponse.setContentLength(trimWriter.getLength());
        pw.flush();
        pw.close();
    }

    @Override
    public void destroy() {
    }

   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static class TrimResponse extends HttpServletResponseWrapper {
        private TrimWriter trimWriter;

        private TrimResponse(HttpServletResponse response, TrimWriter trimWriter) {
            super(response);
            this.trimWriter = trimWriter;
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(trimWriter);
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
                    trimWriter.write(b);
                }
            };
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static class TrimWriter extends Writer {
        private final StringBuilder buf = new StringBuilder();
        @Override
        public void write(int c) throws IOException {
            processChar((char)c);
        }
        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            for (int i = off; i < len; i++) {
                processChar(cbuf[i]);
            }
        }
        @Override
        public void write(String str, int off, int len) throws IOException { // при записи в наш буфер происходит проверка на необходимые символы
            for (int i = off; i < len; i++) {
                processChar(str.charAt(i));
            }
        }
        private void processChar(char ch) throws IOException { // при записи в наш буфер buf, делают проверку "если символ не соответсвтвует \t' '\r' '\n', то тогда записываются в наш буфер"
            if (ch != '\t' && ch != '\r' && ch != '\n') {
                buf.append(ch);
            }
        }
        @Override
        public void flush() throws IOException {
        }
        @Override
        public void close() throws IOException {
        }
        private String getContent(){
            return buf.toString();
        }
        private int getLength(){
            return buf.length();
        }
    }
}
