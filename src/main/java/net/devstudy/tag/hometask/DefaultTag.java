package net.devstudy.tag.hometask;

public class DefaultTag extends AbstractSwithChildTag {
    @Override
    protected boolean shouldBeProcessed(SwitchTag sw) {
        return true;
    }
}
