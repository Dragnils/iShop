package net.devstudy.tag.jsp2;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

//Обработчик тэга с атрибутом (JSP2.0)

public class Attr1Tag extends SimpleTagSupport {
    private boolean condition;

    @Override
    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        if (condition) {
            out.println("Condition is true");
        } else {
            out.println("Condition is false");
        }
        condition = false;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }
}

