package inc.glamdring.vtables;

import java.nio.ByteBuffer;

public class $String extends _deref<String> {

    public _arc<String, _ptr> join(String string, _ptr... ref) {
        l = string;

        byte[] bytes = null;
        for (_ptr ref1 : ref) {
            bytes = (bytes == null) ?
                    (string).getBytes() : bytes;
            final Integer integer = ref1.ror();
            final ByteBuffer buffer = ref1.rol();
            r = (_ptr) ref1.join(buffer.put(bytes), integer);
        }
        return this;
    }
}
