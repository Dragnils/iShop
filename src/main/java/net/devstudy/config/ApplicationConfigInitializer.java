package net.devstudy.config;

import net.devstudy.filter.SimpleFilter3;
import net.devstudy.servlet.JavaConfigServlet;

import javax.servlet.*;
import java.util.Set;

public class ApplicationConfigInitializer implements ServletContainerInitializer { // создание Сервлета через Java код
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        JavaConfigServlet servlet = new JavaConfigServlet();
        ServletRegistration.Dynamic servletConfig = ctx.addServlet("JavaConfigServlet", servlet);
        servletConfig.addMapping("/java");
        System.out.println("ApplicationConfigInitializer");

        FilterRegistration.Dynamic filterConfig = ctx.addFilter("SimpleFilter3", new SimpleFilter3()); // создание Фильтра через Java код
        filterConfig.addMappingForUrlPatterns(null, true, "/*");

    }
}
