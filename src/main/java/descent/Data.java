package descent;

/**
 * this is a Tree Node holding value for a binary tree
 * <p/>
 * User: jim
 * Date: Sep 10, 2008
 * Time: 11:39:55 AM
 */
public class Data<T extends Comparable<?>> {
    //Note:  Wildcards tell javac to try very hard to do the right thin regarding type inference
    //many  non-inheritted polymorphism options can be gained from generics via unspecified wildcard parameters
    private Comparable<?> value;
    private Data<?> left = null;
    private Data<?> right = null;

    public Data(Comparable<?> value, Data<?> left, Data<?> right) {
        this.value = value;
        this.setValue(value);
        this.setLeft(left);
        this.setRight(right);
    }

    public T getValue() {
        return (T) value;
    }

    public void setValue(Comparable<?> value) {
        this.value = value;
    }

    public Data<?> getLeft() {
        return left;
    }

    public void setLeft(Data<?> left) {
        this.left = left;
    }

    public Data<?> getRight() {
        return right;
    }

    public void setRight(Data<?> right) {
        this.right = right;
    }
}
