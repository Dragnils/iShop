package net.devstudy.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


//Обработчик простого тэга (JSP 2.0)

public class Static1Tag extends SimpleTagSupport {// тэг который должен вывести на экране текущую дату
    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().println("Current date: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
    }
}
