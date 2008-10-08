package inc.glamdring.vtables;

import com.thoughtworks.xstream.XStream;

import java.nio.ByteBuffer;

/**
 * ref class -- approximation of c++ '&'
 * User: jim
 * Date: Sep 20, 2008
 * Time: 12:27:26 AM
 */

public class £<T> implements Û<T, $> {
    static final XStream X_STREAM = new XStream();
    T l;

    $ r;

    public T l$() {
        return l;
    }

    /**
     * grab left from the incoming, if any,
     * return left in all cases.
     *
     * @param e
     * @return
     */
    public T l$(Û<T, $> e) {

        if (e != this)
            bind(e.l$(e), e.$r(e));
        return l$();
    }

    public $ $r() {
        return r;
    }

    /**
     * grab right from the incoming, if any,
     * and return right in all cases.
     *
     * @param e
     * @return
     */
    public $ $r(Û<T, $> e) {
        if (e != this) {
            bind(e.l$(e), e.$r(e));
        }
        return $r();
    }


    /**
     * bind and write pointer
     *
     * @param t   object
     * @param ref heap waiting for a write, several
     * @return ussualy this
     */
    public Û<T, $> bind(T t, $ ref) {
        byte[] bytes = null;
        l = t;

        if (bytes == null) bytes = X_STREAM.toXML(t).getBytes();
        Integer integer = ref.$r();
        this.r = ($) ref.bind(ref.l$(ref).putInt(bytes.length).put(bytes), integer);
        return this;
    }

    /**
     * reads object from the first ptr sent in, or returns the most local version
     *
     * @param void$
     * @return
     */
    @SuppressWarnings("unchecked")
    public T reify($ void$) {/*
        for (voidp voidp : voidp) */
        {
            ByteBuffer buffer = void$.l$();
            Integer integer = void$.$r();
            buffer.getInt(integer);
            ByteBuffer buffer1 = (ByteBuffer) buffer.slice().limit(integer);
            String s = buffer1.asCharBuffer().toString();
            T fromXML = (T) X_STREAM.fromXML(s);
            return fromXML;
        }
    }

}
