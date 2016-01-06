package inc.glamdring.vtables;

import bbcursive.std;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static bbcursive.Cursive.pre.*;
import static bbcursive.std.bb;
import static bbcursive.std.str;

/**
 * this class reads a null terminated string. the null is not returned
 */

public class CString extends _reifier<String> {
    @Override
    public String apply(_ptr ptr) {
        ByteBuffer b = bb(ptr.core(ptr),mark,slice);
        while(b.hasRemaining()&&b.get()>0);
        return str(b.flip());
    }

    private final My_mutator mutator = new My_mutator();

    public _mutator<String> getMutator() {
        return mutator;
    }

    private class My_mutator extends _mutator<String> {
        @Override
        public _ptr apply(String s) {

            ByteBufferContext context = getContext();
            _ptr at = context.at();
            bb(std.cat(bb(at.core(), mark), StandardCharsets.UTF_8.encode(s) ),duplicate,reset,slice,debug);//wordy, but not doing much
            return getContext().at();
        }
    }
}
