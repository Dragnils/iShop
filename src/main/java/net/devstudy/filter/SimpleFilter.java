package net.devstudy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName="SimpleFilter")
public class SimpleFilter implements Filter { // Конфигурирование с помощью аннотаций web.xml
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }
    public void destroy() {}
}
