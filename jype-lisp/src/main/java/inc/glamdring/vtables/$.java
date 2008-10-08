package inc.glamdring.vtables;

import java.nio.ByteBuffer;

/**
 * pointer class -- approximation of c++ '*'
 *
 * @author jim
 */
public class $ implements Û<ByteBuffer, Integer> {
    private ByteBuffer l;


    public ByteBuffer l$(Û<ByteBuffer, Integer> e) {
        if (this != e) bind(e.l$(e), e.$r(e));
        return l$();
    }

    public Integer $r(Û<ByteBuffer, Integer> e) {
        if (this != e) 
            bind(e.l$(e), e.$r(e));
        return $r();
    }

    public Û<ByteBuffer, Integer> bind(ByteBuffer byteBuffer, Integer r) {

        l = (ByteBuffer) byteBuffer.duplicate().position(r);
        return this;
    }

    public ByteBuffer reify($ ptr1) {
        return ptr1.l$();

    }

    public ByteBuffer l$() {
        return l;
    }

    public Integer $r() {
        return l$(this).position();
    }
}