package inc.glamdring.vtables;

import static bbcursive.Cursive.pre.flip;
import static bbcursive.Cursive.pre.reset;
import static bbcursive.Cursive.pre.slice;
import static bbcursive.std.str;

/**
 * this class reads a null terminated string. the null is not returned
 */

class CString extends _mutator<String>{

    @Override
    protected _ptr at() {
        return r$();
    }

    @Override
    protected _ptr goTo(_ptr ptr) {
        return ptr;
    }

    @Override
    protected _ptr r$() {
        _ptr location = location();
        return location;
    }

    @Override
    public String apply(_ptr void$) {
        return str(void$.apply(void$).asReadOnlyBuffer(), slice, byteBuffer -> {
            while (byteBuffer.mark().hasRemaining()&& 0!= byteBuffer.get());
            return byteBuffer;
        },reset,flip);
    }

}
