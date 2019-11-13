package net.devstudy.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*   Посмотреть
    /WEB-INF/tags.tld
 */
public class StaticTag extends TagSupport {// тэг который должен вывести на экране текущую дату

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();// получаем объект pageContext и получаем из него JspWriter
            out.println("Current date: "+ new SimpleDateFormat("dd-MM-yyyy").format(new Date()));// в JspWriter записываем текущую дату
            return SKIP_BODY; //пропустить обработку тела
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
}
