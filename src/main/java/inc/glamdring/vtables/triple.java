package inc.glamdring.vtables;

import static inc.glamdring.vtables._ptrait.$String;

import java.nio.ByteBuffer;
import java.util.EnumSet;


/**
 * exploring symbolic unions
 */

public enum Triple implements _vtable<Triple> {
    s($String),
    p($String),
    o($String);


    _vtable $; 
    String $as$comment$String = "an atomic graph vertice.";
    final int $as$extent$length$int;
    final int $as$extent$offset$int;
    private static int $as$Sequence$length$int;
    final static int recordLen = values()[values().length-1].$as$Sequence$length$int+values()[values().length-1].$as$extent$offset$int();
    private static ByteBuffer byteBuffer;
    private ByteBuffer buffer;

    Triple(_vtable vtable, int... dim) {
        $ =vtable;
        $as$extent$length$int=vtable.$as$extent$length$int();
        $as$extent$offset$int=vtable.$as$extent$offset$int();
        
    }


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
        if (keepOffset != null) {
            Triple prev = values()[ordinal() - 1];
            $as$extent$offset$int =
                    !keepOffset ?
                            init($as$extent$length$int = prev.$as$extent$length$int)
                            : init($as$extent$length$int = prev.$as$extent$length$int, prev.$as$extent$length$int + prev.$as$extent$offset$int);
        } else {

            //on null, default start=0
            $as$extent$offset$int = mark.length > 1 ? mark[1].$as$extent$offset$int + mark[1].$as$extent$length$int : 0;

            //on null default size=all
            $as$extent$length$int = mark.length > 0 ? $as$extent$offset$int - mark[0].$as$extent$offset$int : getRecordLen();
        }
    }

    public int getRecordLen() {
        return recordLen;
    }


    public boolean is(_ptrait ptrait) {
        return getPrimaryTraits().contains(ptrait);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public EnumSet<_ptrait> getPrimaryTraits() {
        return EnumSet.of(_ptrait.$Array, _ptrait.$Cons);  //todo: verify for a purpose
    }

    public int $as$extent$offset$int() {
        return $as$extent$offset$int;
    }

    public int $as$extent$length$int() {
        return $as$extent$length$int;
    }

    public _vtable<?> $(_ptr... p) {
        return $;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Triple reify(_ptr... ptr) {
        return (Triple) $().$(ptr);  //To change body of implemented methods use File | Settings | File Templates.
    }
}