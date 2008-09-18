package inc.glamdring.vtables;

import javolution.lang.Reference;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 2:33:07 AM
 */ //a bitecode struct used to allocate registers
enum RegisterFrame {
    triple(12, 0) {{
        ___doc___ = "regen phase will turn this Triple(0,12) by following contract to search for deepest instance of <package>.classname([.$]*classname)* ";
    }},
    
    arity,
    d(4),
    a(4),
    x(4),
    b0(x, 1), b1, b2, b3,
    c0(x, 2), c1(false), c2(false), c3(false), c4(false), c5(false), c6(false), c7(false),
    i0(x), i1(false), i2(false), i3(false), i4(false), i5(false), i6(false), i7(false),
    l0(8), l1(8), l2(8), l3(8), l4(8), l5(8), l6(8), l7(8),;
    private static Class<RegisterFrame> delegate;

    String ___doc___ = "a register frame.";
    final int size;
    final int offset;
    private static int recordLen;


    /**
     * <h1>union function constructor</h1>
     * these initializers allow struct-wide manipulation of the data using seperate functors indexed by seperate ordinals/symbols and abbreviate the effort required to add groups of functions to a single struct.
     * <p/>
     * <p/>
     * the goal here is to provide a simple way to add functors to a struct that know exactly which range of bytes they are working with and operate on a union byte range of the whole.
     *
     * @param keepOffset whether to reuse previous block(true), or create a successive block(false), or reblock (NULL or {@link Primary#prior }) whole or part of the struct
     * @param mark       optional defaults of reblocking params.  mark supplies first and last blocks to encompass a new block byte-union.  default marks are first and last, respectively.   if omitted, this provides the enum class a means of delivering itself into it's functor as a single current-rerdSize chunk.
     */
    private RegisterFrame(Boolean keepOffset, RegisterFrame... mark) {
        if (keepOffset == null) {
            offset = mark.length > 1 ? mark[1].offset + mark[1].size :
                     0;
            size = mark.length > 0 ? offset - mark[0].offset : getRecordLen();


        } else {
            RegisterFrame prev = values()[ordinal() - 1];
            if (!keepOffset) offset = init(size = prev.size);
            else offset = init(size = prev.size, prev.size + prev.offset);
        }
    }

    private int getRecordLen() {return recordLen;}

    private RegisterFrame( RegisterFrame prototype, Integer... dim) {

        offset = init(size = (dim.length > 0 && dim[0] != null && dim[0] >= 0 ? dim[0] : prototype.size),
                      dim.length > 1 && dim[1] != null && dim[1] >= 0 ? dim[1] : prototype.offset);
    }

    private int init(int... dim) {
        int offset = dim.length > 1 ? dim[1] : getRecordLen();
        recordLen = Math.max(
                getRecordLen(), offset + size);
        return offset;
    }

    RegisterFrame(int... dim) {
//        this.$$as$extent$length$int =$$as$extent$length$int;
        offset = init(size = dim.length > 1 ? dim[1] : 1, dim.length > 1 ? dim[1] : 1);
    }

    public Reference<? super Primary> _(ByteBuffer mmapHeapWindow, int[] registers, IntBuffer heapIndex_as_Stack) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isA(Primary a) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isA(Primary... a) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
