package inc.glamdring.vtables;

import javolution.lang.Reference;

import java.nio.ByteBuffer;
import java.util.Iterator;

/**
 * User: jim
 * Date: Sep 20, 2008
 * Time: 12:27:26 AM
 */
class _ptr_deref implements $narrow<ByteBuffer, Integer> {
    private final ByteBuffer buffer;

    public _ptr_deref(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public ByteBuffer $() {
        return this.buffer;
    }

    public ByteBuffer $(Integer integer) {
        return $(integer.intValue());
    }

    public ByteBuffer $(int integer) {
        return (ByteBuffer) buffer.position(integer);
    }

    public <$$> ByteBuffer ctor(Iterator<?> first, $$ last) {
        return null;
    }

    public <$$$ extends Reference<?>> ByteBuffer revive($$$ $$$) {
        return null;
    }

    public ByteBuffer $(Iterable $$$) {
        return null;
    }

    public Class getValueClass() {
        return null;  
    }
}
