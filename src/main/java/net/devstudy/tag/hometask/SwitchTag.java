package net.devstudy.tag.hometask;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SwitchTag extends SimpleTagSupport {
    private Object value; // атрибут который будем сравнивать
    private boolean processed;// атрибут говорит о том что сработал ли како-либо вариант из Case или же нет
    @Override
    public void doTag() throws JspException, IOException {
        processed = false;
        getJspBody().invoke(null);// вызываем содержимое тега
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public boolean isProcessed() {
        return processed;
    }
    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
