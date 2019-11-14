package net.devstudy.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Arrays;

public class H1Tag  extends SimpleTagSupport {
    private String type;// аттрибут, в зависимости какй атрибут будем подавать h1,h2.h3.... смотреть в test.jsp

    public H1Tag() {
        setDefaults();
    }
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("<" + type + ">");
        getJspBody().invoke(null);
        out.print("</" + type + ">");
    }
    private void setDefaults(){
        type = "h6";
    }
    public void setType(String type) {// установка типа
        if (type != null) {
            if (Arrays.asList(new String[] { "h1", "h2", "h3", "h4", "h5", "h6" }).contains(type.toLowerCase())) {
                this.type = type;
            }
        }
    }
}
