package inc.glamdring.vtables;

import java.nio.ByteBuffer;


public class _ptr implements _arc<ByteBuffer, Integer> {
    private ByteBuffer buf;


    public ByteBuffer rol(_arc<ByteBuffer, Integer>... p) {

        for (_arc<ByteBuffer, Integer> pp : p) {
           join(pp.rol(),pp.ror());
        }
        return buf;
    }

    public Integer ror(_arc<ByteBuffer, Integer>... ses) {
        for (_arc<ByteBuffer, Integer> se : ses) {
            join(se.rol(),se.ror( ));
        }
        return buf.position();
    }

    public _arc<ByteBuffer, Integer> join(ByteBuffer byteBuffer, Integer... r) {

        for (Integer integer : r) {
           buf= (ByteBuffer) byteBuffer.position(integer);
            break;
        }
        return this;
    }

    public ByteBuffer reify(_ptr... ptr) {
        for (_ptr ptr1 : ptr) {
            return ptr1.rol();
        }
        return rol();
    }
}