package inc.glamdring.vtables;

import java.nio.ByteBuffer;


public class _ptr implements _arc<ByteBuffer, Integer> {
    private ByteBuffer buf;


    public ByteBuffer l$(_arc<ByteBuffer, Integer>... p) {

        for (_arc<ByteBuffer, Integer> pp : p) {
           bind(pp.l$(),pp.$r());
        }
        return buf;
    }

    public Integer $r(_arc<ByteBuffer, Integer>... ses) {
        for (_arc<ByteBuffer, Integer> se : ses) {
            bind(se.l$(),se.$r( ));
        }
        return buf.position();
    }

    public _arc<ByteBuffer, Integer> bind(ByteBuffer byteBuffer, Integer... r) {

        for (Integer integer : r) {
           buf= (ByteBuffer) byteBuffer.position(integer);
            break;
        }
        return this;
    }

    public ByteBuffer $½(_ptr... ptr) {
        for (_ptr ptr1 : ptr) {
            return ptr1.l$();
        }
        return l$();
    }
}