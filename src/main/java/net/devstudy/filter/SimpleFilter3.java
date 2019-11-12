package net.devstudy.filter;

import javax.servlet.*;
import java.io.IOException;

public class SimpleFilter3 implements Filter { //Конфигурирование с помощью Java классов
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }
    public void destroy() {}
}
