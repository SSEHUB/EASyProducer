package jess;

public interface Visitor {

    public Object visitDeffacts(Deffacts d);
    public Object visitDeftemplate(Deftemplate d);
    public Object visitDeffunction(Deffunction d);
    public Object visitDefglobal(Defglobal d);
    public Object visitDefrule(Defrule d);
    public Object visitDefquery(Defquery d);
    public Object visitPattern(Pattern p);
    public Object visitGroup(Group g);
    public Object visitTest1(Test1 t);
    public Object visitAccumulate(Accumulate a);
    public Object visitDefmodule(Defmodule d);
    public Object visitFuncall(Funcall f);
    public Object visitFact(Fact f);
}
