package inc.glamdring.vtables;

import java.nio.ByteBuffer;

import static bbcursive.std.bb;
import static bbcursive.std.pos;

/**
 * pointer class -- approximation of c++ '*'
 * <p>
 * this class is not exactly a Pair, it is a ByteBuffer reference with a settable position() sensor designed only for DirectByteBuffer work.
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
        return bb(core(), pos(integer)).position();
    }

    @Override
    protected Integer r$() {
        return core().position();
    }
}