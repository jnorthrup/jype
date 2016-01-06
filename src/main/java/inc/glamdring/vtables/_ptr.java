package inc.glamdring.vtables;

import bbcursive.std;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

import static bbcursive.Cursive.pre.*;
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
        return bb(core(), pos(integer)).position();
    }

    @Override
    protected Integer r$() {
        return null;
    }


    /**
     * ref class -- approximation of c++ '&'
     * User: jim
     * Date: Sep 20, 2008
     * Time: 12:27:26 AM
     */

    public abstract static class _mutator<endPojo> implements Function<endPojo, _ptr> {
        private final defaultContext context = new defaultContext();

        public defaultContext getContext() {
            return context;
        }

        protected  class defaultContext extends _edge<endPojo,_ptr> {
            protected _ptr at() {
                return  this.at();
            }

            protected _ptr goTo(_ptr ptr) {
                return  goTo(ptr);
            }

            protected _ptr r$() {
                return  r$();
            }

            public endPojo apply(_ptr ptr) {
                return  apply(ptr);
            }
        }
    }

    /**
     * this class reads a null terminated string. the null is not returned
     */

    public static class CString extends _mutator<String> {
        @Override
        public _ptr apply(String s) {
            _ptr p = getContext().at();
            ByteBuffer core = p.core();

            bb(std.cat(bb(core, mark),StandardCharsets.UTF_8.encode(s) ),duplicate,reset,slice,debug);//wordy, but not doing much
            return p;
        }
    }
}