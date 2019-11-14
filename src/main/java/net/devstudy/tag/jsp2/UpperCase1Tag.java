package net.devstudy.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class UpperCase1Tag  extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        StringWriter sw = new StringWriter();
        getJspBody().invoke(sw); // все что необходимо обработать в теле мы записываем в sw
        getJspContext().getOut().print(sw.toString().toUpperCase());
    }
}
