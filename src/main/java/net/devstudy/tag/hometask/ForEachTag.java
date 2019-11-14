package net.devstudy.tag.hometask;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class ForEachTag extends SimpleTagSupport {
    private String var; // атрибуты
    private Object items;// атрибуты, объект items по которому будем итерировать

    @Override
    public void doTag() throws JspException, IOException {
        Iterator<?> it = iterator(); // получаем объект итератора
        while(it.hasNext()) {// пока есть следуюший элемент
            setVar(it);// мы устанавливаем текущий объект итератора в атрибут var
            handleTagBody();// обрабатываем содержимое тэга
        }
    }
    private void setVar(Iterator<?> it) {
        if(var != null) {
            getJspContext().setAttribute(var, it.next());
        }
    }
    private void handleTagBody() throws JspException, IOException{
        getJspBody().invoke(null);
    }
    private Iterator<?> iterator() throws JspException {
        if(items == null) {
            return Collections.emptyIterator(); // возвращаем нулевой итератор
        } else {
            if(items instanceof Iterable<?>) {
                return ((Iterable<?>)items).iterator();// получаем объект итератора
            } else if(items instanceof Map<?, ?>) {//если Мар
                return ((Map<?,?>)items).entrySet().iterator();// то будем итерироваться по entrySet
            } else if(items instanceof Iterator<?>){ //является ли объект items Iterator-ом
                return ((Iterator<?>)items);// получаем объект итератора
            } else if(items instanceof String) {
                return Arrays.asList(items.toString().split(",")).iterator();// преобразовываем нашу строку в split() по запятой и получаем объект итератора
            } else if(items instanceof Enumeration<?>) {
                return Collections.list((Enumeration<?>)items).iterator();//преобразуем Enumeration items в итератор
            } else if(items.getClass().isArray()) {// если items является Array
                return new Iterator<Object>() { // создаем анонимный класс итератора
                    private int current = 0;
                    private int length = Array.getLength(items);// через рефлексию считываем длину
                    @Override
                    public boolean hasNext() {
                        return current < length;
                    }
                    @Override
                    public Object next() {
                        return Array.get(items, current++);// получаем текущий объект items из нашего массива
                    }
                    @Override
                    public void remove() {
                    }
                };
            }
            throw new JspException("Can't iterate throw items: "+items.getClass());
        }
    }
    public void setVar(String var) {
        this.var = var;
    }
    public void setItems(Object items) {
        this.items = items;
    }
}
