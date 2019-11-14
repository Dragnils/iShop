package net.devstudy.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;


//Обработчик тэга с итерациями(JSP2.0)

public class Loop1Tag  extends SimpleTagSupport {
    private int count;
    @Override
    public void doTag() throws JspException, IOException {
        while(count > 0) {
            getJspBody().invoke(null); // чтобы обработать свое body
            count-- ;
        }
    }
    public void setCount(int count) {
        this.count = count;
    }
}
