package net.devstudy.tag.hometask;

import java.util.Objects;

public class CaseTag extends AbstractSwithChildTag {
    private Object value;

    @Override
    protected boolean shouldBeProcessed(SwitchTag sw) {
        return Objects.equals(value, sw.getValue());// срабатывает если сравниваем наш value с тем который записан в switch tag "sw.getValue()"
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
