package net.devstudy.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Arrays;

// Обработчик тэга с телом

public class HTag extends TagSupport {
    private String type;// аттрибут, в зависимости какй атрибут будем подавать h1,h2.h3....

    public HTag() {
        setDefaults();
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println("<" + type + ">"); // в зависимости какй атрибут будем подавать h1,h2.h3.... будет записываться в наш pageContext
            return EVAL_BODY_INCLUDE;//  обработать тело тега и продолжить выполнение
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().println("</" + type + ">"); // закрываем тэг
            setDefaults();
            return EVAL_PAGE;// продолжить обработку страницы
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
    private void setDefaults(){// по умолчанию h6
        type = "h6";
    }


    public void setType(String type) { // установка типа
        if (type != null) {
            if (Arrays.asList(new String[] { "h1", "h2", "h3", "h4", "h5", "h6" }).contains(type.toLowerCase())) {
                this.type = type;
            }
        }
    }
}
