package net.devstudy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//Конфигурирование слушателей
//Конфигурирование с помощью Java code

public class ServletContextListenerImplJava implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext();
        System.out.println("!!!!!******** -> ServletContextListenerImplJava");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext();
    }
}
