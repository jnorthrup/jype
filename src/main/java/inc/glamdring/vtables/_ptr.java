package inc.glamdring.vtables;

import java.nio.ByteBuffer;

import static bbcursive.std.bb;
import static bbcursive.std.pos;

/**
 * pointer class -- approximation of c++ '*'
 *
 * @author jim
 */

public class _ptr extends _edge<ByteBuffer, Integer> {
    @Override
    protected Integer at() {
        return r$();
    }

    /**
     * bb pos
     *
     * @param integer
     * @return
     */
    @Override
    protected Integer goTo(Integer integer) {
        return bb(theCore(), pos(integer)).position();
    }

    @Override
    protected Integer r$() {
        return null;
    }

    /**
     * this should act like a clone operation ONLY on pointers, when you pass a pointer in.  everything else should coneivably perform some deserialization, but this class MUST do the nonsensical thing and provide a pointer to its pointer, which shall be self forevermore
     *
     * @param void$
     * @return
     */
    @Override
    public ByteBuffer apply(_ptr void$) {
        return bind(core(void$), location(void$)).core();

    }
}