package net.devstudy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// Конфигурирование слушателей
//Конфигурирование с помощью аннотаций

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext();
        System.out.println("!!!!!******** -> ServletContextListenerImpl"); // выводится в консоль
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext();
    }
}
