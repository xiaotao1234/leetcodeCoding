package 设计模式.访问器模式;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/12 22:16
 */
public abstract class Visitor {
    public abstract void visitElementA(Element e);

    public abstract void visitElementB(Element e);
}
