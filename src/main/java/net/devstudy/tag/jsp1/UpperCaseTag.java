package net.devstudy.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;


// Использование тэга на JSP
public class UpperCaseTag extends BodyTagSupport {

    // все остальные методы из уже определенного класса  BodyTagSupport который предназначен для обработки содержимого текущего тега

    @Override
    public int doEndTag() throws JspException {
        BodyContent body = getBodyContent();// когда все обработали мы получаем объект body
        try {
            pageContext.getOut().print(body.getString().toUpperCase()); // получаем содержимое тела тега body.getString() и приводим его в верхний регистр и выводим на экран
        } catch (IOException e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}
