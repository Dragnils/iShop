package net.devstudy.tag.hometask;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public abstract class AbstractSwithChildTag extends SimpleTagSupport {

    @Override
    public final void doTag() throws JspException, IOException {
        SwitchTag sw = getSwitchTag();// получили Parent switch
        if (!sw.isProcessed() && shouldBeProcessed(sw)) {// если switch еще не обработан и текущий тэг должен быть обработан
            sw.setProcessed(true);// тогда устанавливаем флаг обработанный в switch
            getJspBody().invoke(null);// выполняем содержимое этого тэга
        }
    }

    protected abstract boolean shouldBeProcessed(SwitchTag sw);

    protected final SwitchTag getSwitchTag() throws JspException { // получаем наш getSwitchTag с помощью getParent()
        JspTag tag = getParent();
        if (tag instanceof SwitchTag) { //если объект getParent() является SwitchTag
            return ((SwitchTag) tag);// то возвращаем SwitchTag tag
        } else {
            throw new JspException("case tag should be inside switch tag! Current parent is: " + (tag != null ? tag.getClass() : null));
        }
    }
}
