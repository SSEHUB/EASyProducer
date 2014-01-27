package jess;

public interface Visitable {

    public Object accept(Visitor v);

}
