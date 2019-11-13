package net.devstudy.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


//Обработчик тэга с итерациями
public class LoopTag extends TagSupport {
    private int count; // количество итераций
    @Override
    public int doStartTag() throws JspException {
        if(count > 0) {
            return EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }
    }


    @Override
    public int doAfterBody() throws JspException { // вызывается каждый раз после выполнения обработки тела тега и
                                                    // определяет дальнейшее поведение обработчика:
        count--;
        if(count > 0) {
            return EVAL_BODY_AGAIN; // еще раз обработать тело тега;
        } else {
            return SKIP_BODY; // продолжить обработку страницы
        }
    }
    public void setCount(int count) {
        this.count = count;
    }
}
