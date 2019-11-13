package net.devstudy.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

//Обработчик тэга с аттрибутом

public class AttrTag extends TagSupport {
    private boolean condition;// атрибут
    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();// получаем объект pageContext и получаем из него JspWriter
            if(condition) {
                out.println("Condition is true");
            } else {
                out.println("Condition is false");
            }
            condition = false;
            return SKIP_BODY;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
    public void setCondition(boolean condition) {
        this.condition = condition;
    }
}
