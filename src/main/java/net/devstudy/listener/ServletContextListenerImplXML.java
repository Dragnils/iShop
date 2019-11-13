package net.devstudy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//Конфигурирование слушателей
//Конфигурирование с помощью XML

public class ServletContextListenerImplXML implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext();
        System.out.println("!!!!!******** -> ServletContextListenerImplXML");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext();
    }
}
