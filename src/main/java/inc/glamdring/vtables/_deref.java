package inc.glamdring.vtables;

import com.thoughtworks.xstream.XStream;

import java.nio.ByteBuffer;

/**
 * User: jim
 * Date: Sep 20, 2008
 * Time: 12:27:26 AM
 */

public class _deref<T> implements _arc<T, _ptr> {
    static final XStream X_STREAM = new XStream();
    T l;
    _ptr r;

    /**
     * grab left from the incoming, if any,
     * return left in all cases.
     *
     * @param p
     * @return
     */
    public T rol(_arc<T, _ptr>... p) {
        for (_arc<T, _ptr> bound_ref_arc : p) {
            join(bound_ref_arc.rol(), ror());
        }
        return l;
    }

    /**
     * grab right from the incoming, if any,
     * and return right in all cases.
     *
     * @param ses
     * @return
     */
    public _ptr ror(_arc<T, _ptr>... ses) {
        for (_arc<T, _ptr> se : ses) {
            join(l, se.ror());
        }
        return r;
    }


    /**
     * @param t   object
     * @param ref heap waiting for a write, several
     * @return ussualy this
     */
    public _arc<T, _ptr> join(T t, _ptr... ref) {
        byte[] bytes = null;
        l = t;

        for (_ptr ref1 : ref) {
            bytes = (bytes == null) ?
                    X_STREAM.toXML(t).getBytes() : bytes;
            Integer integer = ref1.ror();
            this.r = (_ptr) ref1.join(ref1.rol().putInt(bytes.length).put(bytes), integer);
        }
        return this;
    }

    /**
     * reads object from the first ptr sent in, or returns the most local version
     *
     * @param ptr
     * @return
     */
    public T reify(_ptr... ptr) {
        for (_ptr ptr1 : ptr) {
            ByteBuffer buffer = ptr1.rol();
            Integer integer = ptr1.ror();
            buffer.getInt(integer);
            ByteBuffer buffer1 = (ByteBuffer) buffer.slice().limit(integer);
            String s = buffer1.asCharBuffer().toString();
            return (T) X_STREAM.fromXML(s);
        }


        return rol();
    }

}
