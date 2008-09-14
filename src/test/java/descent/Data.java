package descent;

/**
 * Example of Tree Descent Recursion
 */

class Traversal {

    //Note:  Wildcards tell javac to try very hard to do the right thin regarding type inference
    static Comparable<?> traverse(int goalIndex, int current, Data<?> root) {
        Comparable<?> r = null;
        final int i = current + 1;
        if (current == goalIndex) {
            r = root.getValue();
        } else {
            final Data<?> left = root.getLeft();
            if (null != left && null == (r = traverse(goalIndex, i, left))) {
                final Data<?> right = root.getRight();
                if (null != right)
                    r = traverse(goalIndex, i, root.getRight());
            }
        }
        return r;
    }
}