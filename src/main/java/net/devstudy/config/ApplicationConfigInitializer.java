package net.devstudy.config;

import net.devstudy.servlet.JavaConfigServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class ApplicationConfigInitializer implements ServletContainerInitializer { // создание Сервлета через Java код
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        JavaConfigServlet servlet = new JavaConfigServlet();
        ServletRegistration.Dynamic servletConfig = ctx.addServlet("JavaConfigServlet", servlet);
        servletConfig.addMapping("/java");
        System.out.println("ApplicationConfigInitializer");
    }
}
