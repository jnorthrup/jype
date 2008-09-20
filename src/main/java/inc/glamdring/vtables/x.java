package inc.glamdring.vtables;

import javolution.lang.Reference;

import java.nio.ByteBuffer;
import java.util.Iterator;


 abstract class _ref<T> implements $narrow<T, $narrow<ByteBuffer, Integer>> {


    public _ref(T $) {
    }

    public _ref() {


    }


    public <$$$ extends Reference<?>> T revive($$$ $$$) {
        return null;  //todo: verify for a purpose
    }

    public Class getValueClass() {
        return null;  //todo: verify for a purpose
    }

    public static void main(String[] a) throws Error {

        final int ptr = 6 * 8;
        ByteBuffer heap = null;
        heap = ByteBuffer.allocate(64 * 8);
        heap.position(ptr);
        Long val = 8L;

        heap.putLong(val);

        final _ref<Long> ref = new _ref<Long>() {
            public Long $() {
                return null;  //todo: verify for a purpose
            }

            public Long $($narrow<ByteBuffer, Integer> byteBufferIntegerp) {
                return byteBufferIntegerp.$(ptr).getLong();  //todo: verify for a purpose
            }

            public <$$> Long ctor(Iterator<?> first, $$ last) {
                return null;  //todo: verify for a purpose
            }

            public Long $(Iterable $$$) {
                return null;  //todo: verify for a purpose
            }
        };

        final _ptr_deref ptr_deref = new _ptr_deref(heap);
        ptr_deref.$(ptr);
        Long l = ref.$(($narrow<ByteBuffer,Integer>) ptr_deref);
        if (l == 8) System.out.println("Success");
        else {
            throw new Error(l.toString());
        }
    }

}



