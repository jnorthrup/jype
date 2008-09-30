package inc.glamdring.vtables;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.EnumSet;


/**
 * exploring symbolic unions
 */

public enum Triple implements _vtable<Triple>, _arc<URI, $String> {
    s,
    p,
    o;


    static Class c;
    String $as$comment$String = "an atomic graph vertice.";
    final int $as$extent$length$int;
    final int $as$extent$offset$int;
    private static int $as$Sequence$length$int;
    private int recordLen;
    private static ByteBuffer byteBuffer;
    private ByteBuffer buffer;


    /**
     * the magic happens by this *legal* trickery
     */
    private int init(int... dim) {
        int offset = dim.length > 1 ? dim[1] : getRecordLen();
        $as$Sequence$length$int = Math.max(getRecordLen(), offset + $as$extent$length$int);
        return offset;
    }

    /**
     * copy-on-write
     */
    private Triple(Triple prototype, Integer... dim) {
        $as$extent$offset$int = init($as$extent$length$int = (dim.length > 0 && dim[0] != null && dim[0] >= 0 ? dim[0] : prototype.$as$extent$length$int),
                                     dim.length > 1 && dim[1] != null && dim[1] >= 0 ? dim[1] : prototype.$as$extent$offset$int);
    }

    Triple(int... dim) {
        $as$extent$offset$int = init($as$extent$length$int = dim.length > 1 ? dim[1] : 1, dim.length > 1 ? dim[1] : 1);
    }

    /**
     * <h1>union function constructor</h1>
     * these initializers allow struct-wide manipulation of the data using seperate functors indexed by seperate ordinals/symbols and abbreviate the effort required to add groups of functions to a single struct.
     * the goal here is to provide a simple syntax to add functors to a struct that know exactly which range of bytes they are working with and operate on a union byte extent or the whole.
     *
     * @param keepOffset whether to reuse previous block(true), or create a successive block(false), or reblock (NULL,[first,last] ) whole or part of the struct
     * @param mark       optional defaults of reblocking params.  mark supplies first and last blocks to encompass a new block byte-union.  default marks are first and last, respectively.   if omitted, this provides the enum class a means of delivering itself into it's functor as a single current-rerdSize chunk.
     */
    private Triple(Boolean keepOffset, Triple... mark) {
        if (keepOffset == null) {
            $as$extent$offset$int = mark.length > 1 ? mark[1].$as$extent$offset$int + mark[1].$as$extent$length$int : 0;
            $as$extent$length$int = mark.length > 0 ? $as$extent$offset$int - mark[0].$as$extent$offset$int : getRecordLen();
            return;
        }
        Triple prev = values()[ordinal() - 1];
        $as$extent$offset$int =
                !keepOffset ? init($as$extent$length$int = prev.$as$extent$length$int) : init($as$extent$length$int = prev.$as$extent$length$int, prev.$as$extent$length$int + prev.$as$extent$offset$int);
    }

    public int getRecordLen() {
        return recordLen;
    }

//    static public void main(String[] a) {
//        final String[] strings = {"foo", "sdasadasd", "dsfasdfasdfasdfa"};
//        final ByteBuffer heap = ByteBuffer.allocate(2222);
//        int j = 0;
//
//        final ByteBuffer iterBuffer = heap.duplicate();
//
//        heap.position(Triple.$as$Sequence$length$int);
//
//        /**
//         * pascal strings
//         */
//        heap.putInt(s.$as$extent$offset$int, heap.position()).
//                putInt(strings[j].getBytes().length).put(strings[j++].getBytes()).
//                putInt(p.$as$extent$offset$int, heap.position()).
//                putInt(strings[j].getBytes().length).put(strings[j++].getBytes()).
//                putInt(o.$as$extent$offset$int, heap.position()).
//                putInt(strings[j].getBytes().length).put(strings[j++].getBytes());
//
//
//        final ArrayList<$Ptr$Deref> ptr_derefs = new ArrayList<$Ptr$Deref>();
//
//        $Ptr$Deref ptr_deref = new $Ptr$Deref(heap);
//        ptr_deref.$(heap.getInt(s.$as$extent$offset$int));
//        ptr_derefs.add(ptr_deref);
//        ptr_deref = new $Ptr$Deref(heap);
//        ptr_deref.$(heap.getInt(p.$as$extent$offset$int));
//        ptr_derefs.add(ptr_deref);
//        ptr_deref = new $Ptr$Deref(heap);
//        ptr_deref.$(heap.getInt(o.$as$extent$offset$int));
//        ptr_derefs.add(ptr_deref);
//
//        heap.flip();
//
//        final Iterator<String> iterator = new Iterator<String>() {
//            ByteBuffer
//                    byteBuffer = (ByteBuffer) iterBuffer.asReadOnlyBuffer().duplicate().rewind();
//
//
//            public boolean hasNext() {
//                return byteBuffer.hasRemaining();
//            }
//
//            public String next() {
//
//                final int addr = byteBuffer.getInt();
//                final ByteBuffer buffer1 = (ByteBuffer) iterBuffer.slice().position(addr);
//
//                buffer1.slice();
//                buffer1.limit(buffer1.getInt() + 4);
//                return buffer1.asCharBuffer().toString();
//            }
//
//            public void remove() {
//                throw new IllegalArgumentException();
//            }
//        };
//    }

    public <$ extends _ptrait> boolean is(_ptrait $) {
        return false;  //todo: verify for a purpose
    }

    public EnumSet<_ptrait> getPrimaryTraits() {
        return null;  //todo: verify for a purpose
    }

    public int getOffset() {
        return $as$extent$offset$int;
    }

    public int getSize() {
        return $as$extent$length$int;
    }

    public URI rol(_arc<URI, $String>... p) {
        for (_arc<URI, $String> uri$String_arc : p) {
            return uri$String_arc.rol(p);
        }

        return null;
    }

    public $String ror(_arc<URI, $String>... ses) {
        for (_arc<URI, $String> se : ses) {
            return se.ror(ses);
        }
        return null;
    }

    public _arc<URI, $String> join(final URI uri, $String... r) {
        for (final $String $String : r) {

            return new _arc<URI, $String>() {
                public URI rol(_arc<URI, $String>... p) {

                    return uri;
                }

                public $String ror(_arc<URI, $String>... ses) {
                    return $String;  //todo: verify for a purpose
                }


                public _arc<URI, $String> join(URI uri, $String... r) {
                    return this;
                }

                public URI reify(_ptr... ptr) {
                    return URI.create($String.rol());  //todo: verify for a purpose
                }
            };
        }
        return null;
    }

    public URI reify(_ptr... ptr) {
        final String s1 = new $String().reify(ptr);
        return URI.create(s1);

    }

}