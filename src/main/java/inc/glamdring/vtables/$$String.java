package inc.glamdring.vtables;

import java.nio.ByteBuffer;

/**
 * User: jim
* Date: Sep 30, 2008
* Time: 7:56:55 PM
*/
public class $$String extends _deref<String> {

    public _arc<String, _ptr> bind(String string, _ptr... ref) {
        l = string;

        byte[] bytes = null;
        for (_ptr ref1 : ref) {
            bytes = bytes == null ?
                    string.getBytes() : bytes;
            final Integer integer = ref1.$r();
            final ByteBuffer buffer = ref1.l$();
            r = (_ptr) ref1.bind(buffer.put(bytes), integer);
        }
        return this;
    }
}
